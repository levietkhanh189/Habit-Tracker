package service;

import jakarta.servlet.http.HttpSession;
import manager.AppManager;
import manager.DAOManager;
import model.dao.ActivityDAO;
import model.entity.Activity;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entity.Habit;

import java.io.IOException;
import java.util.List;

public class ActivityService {

    private ActivityDAO activityDAO;

    public ActivityService(ActivityDAO activityDAO) {
        this.activityDAO = activityDAO;
    }

    public void handleGetActivitiesByUserId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<Activity> userActivities = activityDAO.findByUserId(AppManager.getInstance().getCurrentUser().getId());
        session.setAttribute("activities",userActivities);
    }
}
