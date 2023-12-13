package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import manager.ServiceManager;

import java.io.IOException;
import java.text.ParseException;

public class HabitTrackerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ServiceManager.getInstance().getHabitTrackerService().handleUpdateHabitTrackerStatus(request,response);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}