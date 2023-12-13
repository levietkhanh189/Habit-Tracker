package controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import manager.ServiceManager;

import java.io.IOException;
import java.text.ParseException;

public class AppBarServlet  extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext sc = getServletContext();
        String pageUrl = request.getParameter("page");
        if(pageUrl == null || pageUrl.isEmpty())
            pageUrl = "/home.jsp";
        else if(pageUrl.equals("/home.jsp")){
            try {
                ServiceManager.getInstance().getHabitTrackerService().handleGetAllHabitTrackersByUserIdAndDate(request,response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }else if(pageUrl.equals("/explore.jsp")){
            ServiceManager.getInstance().getHabitService().handleUserHabit(request, response);
            ServiceManager.getInstance().getChallengeService().handleGetAllChallenge(request, response);
        }else if(pageUrl.equals("/profile-activity.jsp")){
            ServiceManager.getInstance().getActivityService().handleGetActivitiesByUserId(request, response);
        }else if(pageUrl.equals("/activity.jsp")){
        }
            sc.getRequestDispatcher(pageUrl).forward(request, response);
    }
}
