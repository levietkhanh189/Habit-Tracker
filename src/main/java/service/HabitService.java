package service;

import jakarta.servlet.http.HttpSession;
import manager.AppManager;
import manager.DAOManager;
import manager.ServiceManager;
import model.dao.HabitDAO;
import model.dao.MyUserDAO;
import model.entity.Habit;
import model.entity.MyUser;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class HabitService {

    private HabitDAO habitDAO;

    public HabitService(HabitDAO habitDAO) {
        this.habitDAO = habitDAO;
    }

    public void handleGetAllHabitsByUserId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xử lý lấy tất cả habits theo userId ở đây

        Long userId = Long.parseLong(request.getParameter("userId"));
        MyUser user = new MyUser();// Lấy MyUser từ userId, có thể sử dụng MyUserDAO
                List<Habit> habits = habitDAO.findByUser(user);

        // Gửi dữ liệu habits đến trang JSP hoặc chuyển hướng đến trang khác để hiển thị
    }

    public void handleAddCustomHabit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException , ParseException {
        // Xử lý thêm habit theo userId ở đây

        MyUser user = AppManager.getInstance().getCurrentUser();

        String habitName = request.getParameter("habit-name");
        String habitIcon = request.getParameter("habitIcon");
        String habitLocation = request.getParameter("location");

        Habit newHabit = new Habit();
        newHabit.setHabitName(habitName);
        newHabit.setIcon(habitIcon);
        newHabit.setLocation(habitLocation);
        newHabit.setUser(user);

        habitDAO.create(newHabit);
        user.addUserHabit(newHabit);
        DAOManager.getInstance().getMyUserDAO().update(user);
        ServiceManager.getInstance().getHabitTrackerService().handleCreateHabitTrackersFromHabitsAndChallenges(request,response);


         String url = "/home.jsp";
            request.getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    public void handleAddDefaultHabit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException , ParseException {
        MyUser user = AppManager.getInstance().getCurrentUser();
        String habitString = request.getParameter("info");
        System.out.println("Habit id: " + habitString);
        long habitId = Long.parseLong(habitString);
        Habit originHabit = habitDAO.findById(habitId);
        if (!user.hasHabit(originHabit)) {
            Habit habit = new Habit(originHabit);
            habit.setType("Custom");
            habit.setUser(user);
            habitDAO.create(habit);
            user.addUserHabit(habit);
            DAOManager.getInstance().getMyUserDAO().update(user);
            ServiceManager.getInstance().getHabitTrackerService().handleCreateHabitTrackersFromHabitsAndChallenges(request,response);
        }

        String url = "/home.jsp";
        request.getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    public void handleDeleteHabitByUserId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xử lý xoá habit theo userId ở đây

        Long habitId = Long.parseLong(request.getParameter("habitId"));

        Habit habit = habitDAO.findById(habitId);
        habitDAO.delete(habit);

        // Gửi thông báo xoá thành công hoặc chuyển hướng đến trang khác
    }

    public void handleOpenNewDefaultHabit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Habit> userHabits = DAOManager.getInstance().getHabitDAO().findByType("Default");
        session.setAttribute("habits",userHabits);

        String url = "/new-default-habit.jsp";
        request.getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    public void handleUserHabit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Habit> userHabits = DAOManager.getInstance().getHabitDAO().findByType("Default");
        session.setAttribute("habits",userHabits);
    }
    // Các phương thức xử lý khác có thể được thêm vào tùy theo yêu cầu
}
