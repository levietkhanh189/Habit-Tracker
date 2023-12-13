package service;

import jakarta.servlet.http.HttpSession;
import manager.AppManager;
import manager.DAOManager;
import model.dao.ChallengeDAO;
import model.dao.HabitDAO;
import model.dao.HabitTrackerDAO;
import model.dao.MyUserDAO;
import model.entity.Activity;
import model.entity.Habit;
import model.entity.HabitTracker;
import model.entity.MyUser;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.Console;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HabitTrackerService {

    private HabitTrackerDAO habitTrackerDAO;
    private HabitDAO habitDAO;
    private MyUserDAO myUserDAO;
    private ChallengeDAO challengeDAO;
    public HabitTrackerService(HabitTrackerDAO habitTrackerDAO, HabitDAO habitDAO, MyUserDAO myUserDAO, ChallengeDAO challengeDAO) {
        this.habitTrackerDAO = habitTrackerDAO;
        this.habitDAO = habitDAO;
        this.myUserDAO = myUserDAO;
        this.challengeDAO = challengeDAO;
    }

    public void handleGetAllHabitTrackersByUserIdAndDate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        MyUser user = AppManager.getInstance().getCurrentUser();
        Date date = null;
        if(request.getParameter("selectedDate") != null){
            String dateString = request.getParameter("selectedDate");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = dateFormat.parse(dateString);
            System.out.println(dateString);
        }else {
            date = new Date();
        }
        System.out.println(date.toString());
        List<HabitTracker> habitTrackers = habitTrackerDAO.findByUserAndDate(user, date);
        System.out.println(habitTrackers.isEmpty());
        HttpSession session = request.getSession();
        session.setAttribute("habittrackers",habitTrackers);
    }

    public void handleGetAllHabitTrackersByUserIdAndDateAndShow(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException  {
        handleGetAllHabitTrackersByUserIdAndDate(request,response);
        System.out.println("Hello" );
        String url = "/home.jsp";
        request.getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    public boolean checkIfHabitTrackerExists(MyUser user, Date date) {
        return habitTrackerDAO.findByUserAndDate(user,date).isEmpty();
    }


    public void handleCreateHabitTrackersFromHabitsAndChallenges(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        MyUser user = AppManager.getInstance().getCurrentUser();
        List<HabitTracker> currentTrackers = habitTrackerDAO.findByUserAndDate(user, new Date());
        AppManager.getInstance().setCurrentTracker(currentTrackers);

        if (checkIfHabitTrackerExists(user, new Date()) || (currentTrackers.size() != user.getUserHabits().size() + challengeDAO.getHabitsForUser(user.getId()).size()))
        {
            if (!checkIfHabitTrackerExists(user, new Date()))
                for (HabitTracker habitTracker : currentTrackers)
                    habitTrackerDAO.delete(habitTracker);

            List<HabitTracker> habitTrackers = new ArrayList<>();

            // Tạo habitTrackers từ challenges
            for (Habit habit : challengeDAO.getHabitsForUser(user.getId())) {
                HabitTracker habitTracker = new HabitTracker();
                habitTracker.setUser(user);
                habitTracker.setHabit(habit);
                habitTracker.setStatus("Not Completed");
                habitTracker.setDate(new Date());
                habitTrackerDAO.create(habitTracker);
                habitTrackers.add(habitTracker);
            }

            // Tạo habitTrackers từ habits
            for (Habit habit : habitDAO.findByUser(user)) {
                HabitTracker habitTracker = new HabitTracker();
                habitTracker.setUser(user);
                habitTracker.setHabit(habit);
                habitTracker.setStatus("Not Completed");
                habitTracker.setDate(new Date());
                habitTrackerDAO.create(habitTracker);
                habitTrackers.add(habitTracker);
            }

            HttpSession session = request.getSession();
            AppManager.getInstance().setCurrentTracker(habitTrackers);
            session.setAttribute("habittrackers", habitTrackers);
        }
        else
        {
            // Nếu không có sự thay đổi, hiển thị habitTrackers hiện tại
            handleGetAllHabitTrackersByUserIdAndDate(request, response);
        }
    }


    public void handleUpdateHabitTrackerStatus(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException  {
        Long habitTrackerId = Long.parseLong(request.getParameter("habitId"));
        String isCheckedStr = request.getParameter("isChecked");
        boolean isChecked = Boolean.parseBoolean(isCheckedStr);

        HabitTracker habitTracker = habitTrackerDAO.findById(habitTrackerId);
        if(isChecked){
            habitTracker.setStatus("Completed");
            Activity activity = new Activity(habitTracker.getUser(), "Habit Completed", habitTracker.getHabit().getHabitName(), new Date());
            DAOManager.getInstance().getActivityDAO().create(activity);
        }
        else
            habitTracker.setStatus("Not Completed");

        habitTrackerDAO.update(habitTracker);
        handleGetAllHabitTrackersByUserIdAndDate(request,response);
        String url = "/home.jsp";
        request.getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
