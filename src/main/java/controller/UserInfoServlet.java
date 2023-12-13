package controller;
import java.io.IOException;
import java.text.ParseException;

import manager.*;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class UserInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String info = request.getParameter("info");
        if(info.equals("info")){
            ServiceManager.getInstance().getMyUserService().handleCreateUser(request,response);
        }else if(info.equals("male") || info.equals("female")){
            ServiceManager.getInstance().getMyUserService().handleGender(request,response);
        }else {
            try {
                ServiceManager.getInstance().getMyUserService().handleAddFirstHabit(request,response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

        }

    }
}