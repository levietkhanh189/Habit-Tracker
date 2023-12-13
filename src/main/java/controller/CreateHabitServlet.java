package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import manager.AppManager;
import manager.DAOManager;
import manager.ServiceManager;
import model.entity.Habit;
import model.entity.MyUser;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class CreateHabitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String info = request.getParameter("info");
        if(info.equals("open")) {
            ServiceManager.getInstance().getHabitService().handleOpenNewDefaultHabit(request,response);
        }else if(info.equals("custom")){
            try {
                ServiceManager.getInstance().getHabitService().handleAddCustomHabit(request,response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            try {
                ServiceManager.getInstance().getHabitService().handleAddDefaultHabit(request, response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
