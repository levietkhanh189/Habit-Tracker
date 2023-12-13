package service;

import jakarta.servlet.http.HttpSession;
import manager.AppManager;
import manager.DAOManager;
import manager.ServiceManager;
import model.dao.ChallengeDAO;
import model.entity.Activity;
import model.entity.Challenge;
import model.entity.Habit;
import model.entity.MyUser;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class ChallengeService {

    private ChallengeDAO challengeDAO;

    public ChallengeService(ChallengeDAO challengeDAO) {
        this.challengeDAO = challengeDAO;
    }

    public void handleCreateChallenge(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xử lý tạo mới challenge ở đây

        Challenge newChallenge = new Challenge();
        // Thiết lập thuộc tính của newChallenge từ request

        challengeDAO.save(newChallenge);

        // Chuyển hướng hoặc gửi dữ liệu đến trang JSP để hiển thị
    }

    public void handleGetAllChallenge(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("challenges",challengeDAO.findAll());
    }

    public void handleAddUserToChallenge(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xử lý thêm user vào challenge ở đây

        Long challengeId = Long.parseLong(request.getParameter("challengeId"));
        Challenge challenge = challengeDAO.findById(challengeId);
        MyUser user = AppManager.getInstance().getCurrentUser();// Lấy MyUser từ userId, có thể sử dụng MyUserDAO

        challenge.addUser(user);
        user.addChallenge(challenge);
        challengeDAO.update(challenge);
        DAOManager.getInstance().getMyUserDAO().update(user);
        Activity activity = new Activity(user, "Join Challenge", challenge.getName(), new Date());
        DAOManager.getInstance().getActivityDAO().create(activity);
        String url = "/home.jsp";
        try {
            ServiceManager.getInstance().getHabitTrackerService().handleCreateHabitTrackersFromHabitsAndChallenges(request,response);
            request.getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
        } catch (ParseException e) {
            request.getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
        }
    }

    public void handleEndChallenge(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xử lý kết thúc challenge ở đây

        Long challengeId = Long.parseLong(request.getParameter("challengeId"));

        Challenge challenge = challengeDAO.findById(challengeId);
        // Thiết lập thuộc tính của challenge để đánh dấu là đã kết thúc
        // challenge.setStatus("Ended");

        challengeDAO.update(challenge);

        // Chuyển hướng hoặc gửi dữ liệu đến trang JSP để hiển thị
    }

    public void handleDetailChallenge(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Long challengeId = Long.parseLong(request.getParameter("info"));

        Challenge challenge = challengeDAO.findById(challengeId);
        List<Habit> challengeHabits = challengeDAO.getHabitsForChallenge(challengeId);
        session.setAttribute("habits",challengeHabits);
        session.setAttribute("challenge",challenge);
        String url = "/challenge-detail.jsp";
        request.getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
