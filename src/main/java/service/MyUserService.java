package service;

import jakarta.servlet.http.HttpSession;
import manager.AppManager;
import manager.DAOManager;
import manager.ServiceManager;
import model.dao.HabitDAO;
import model.dao.MyUserDAO;
import model.entity.MyUser;
import model.entity.Habit;
import model.entity.Challenge;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyUserService {

    private MyUserDAO myUserDAO;
    private HabitDAO habitDAO;
    public MyUserService(MyUserDAO myUserDAO,HabitDAO habitDAO) {
        this.myUserDAO = myUserDAO;
        this.habitDAO = habitDAO;
    }

    public void handleCreateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String birthdayStr = request.getParameter("birthday");

        // Chuyển đổi chuỗi ngày sinh thành đối tượng Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        try {
            birthday = dateFormat.parse(birthdayStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        MyUser newUser = new MyUser();
        newUser.setName(name);
        newUser.setSurname(surname);
        newUser.setBirthday(birthday);
        newUser.setAccount(AppManager.getInstance().getCurrentAccount());
        // Lưu mới người dùng vào cơ sở dữ liệu
        myUserDAO.create(newUser);
        AppManager.getInstance().setCurrentUser(newUser);
        AppManager.getInstance().getCurrentAccount().setUser(newUser);
        DAOManager.getInstance().getAccountDAO().updateAccount(AppManager.getInstance().getCurrentAccount());
        response.sendRedirect("information-02.jsp");
    }

    public void handleGender(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String gender = request.getParameter("info");
        if(gender != null){
            MyUser user=AppManager.getInstance().getCurrentUser();
            user.setGender(gender);
            myUserDAO.update(user);
        }
        List<Habit> userHabits = DAOManager.getInstance().getHabitDAO().findByType("Default");
        session.setAttribute("habits",userHabits);

        String url = "/information-03.jsp";
        request.getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    public void handleAddFirstHabit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        MyUser user = AppManager.getInstance().getCurrentUser();
        if (user.getUserHabits() == null || user.getUserHabits().isEmpty()) {
            String habitString = request.getParameter("info");
            System.out.println("Habit id: " + habitString);
            long habitId = Long.parseLong(habitString);
            Habit originHabit = habitDAO.findById(habitId);
            Habit habit = new Habit(originHabit);
            habit.setType("Custom");
            habit.setUser(user);
            user.addUserHabit(habit);
            habitDAO.create(habit);
            myUserDAO.update(user);
        }
        ServiceManager.getInstance().getHabitTrackerService().handleCreateHabitTrackersFromHabitsAndChallenges(request,response);
        String url = "/home.jsp";
        request.getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    public void handleGetHabits(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MyUser user = AppManager.getInstance().getCurrentUser();

        List<Habit> userHabits = user.getUserHabits();

        response.sendRedirect("home.jsp");
    }

    public void handleGetChallenges(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xử lý lấy thông tin challenge ở đây

        Long userId = Long.parseLong(request.getParameter("userId"));
        MyUser user = myUserDAO.findById(userId);

        List<Challenge> userChallenges = user.getChallenges();

        // Chuyển hướng hoặc gửi dữ liệu đến trang JSP để hiển thị
    }

    // Các phương thức xử lý khác có thể được thêm vào tùy theo yêu cầu
}
