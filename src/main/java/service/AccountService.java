package service;

import manager.AppManager;
import manager.DAOManager;
import manager.ServiceManager;
import model.dao.AccountDAO;
import model.dao.MyUserDAO;
import model.entity.Account;
import model.entity.MyUser;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ulti.EmailInfo;

import java.io.IOException;
import java.text.ParseException;

public class AccountService {

    private AccountDAO accountDAO;
    private MyUserDAO myUserDAO;

    public AccountService(AccountDAO accountDAO,MyUserDAO myUserDAO) {
        this.accountDAO = accountDAO;
        this.myUserDAO = myUserDAO;
    }

    public void handleLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Kiểm tra đăng nhập
        String url = "/home.jsp";

        Account account = accountDAO.findByUsernameAndPassword(username, password);
        if (account != null) {
            MyUser user = null;
            if(!myUserDAO.findByAccount(account).isEmpty())
                 user = myUserDAO.findByAccount(account).get(0);
            AppManager.getInstance().setCurrentAccount(account);
            if(user == null){
                url = "/information-01.jsp";
            }
            else
            {
                AppManager.getInstance().setCurrentUser(user);
                ServiceManager.getInstance().getHabitTrackerService().handleCreateHabitTrackersFromHabitsAndChallenges(request,response);
                url = "/home.jsp";
            }
            // Chuyển hướng hoặc xử lý khác...
        } else {
            url = "/continue-with-email.jsp";
        }

        request.getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    public void handleRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("passwordagain");
        // Kiểm tra xem tài khoản đã tồn tại chưa
        Account existingAccount = accountDAO.findByUsername(username);
        if (existingAccount != null) {
            response.sendRedirect("continue-with-email.jsp");
        } else {
            if(confirmPassword.equals(password)){
                Account newAccount = new Account();
                newAccount.setUsername(username);
                newAccount.setPassword(password);
                accountDAO.create(newAccount);
                AppManager.getInstance().setCurrentAccount(newAccount);
                response.sendRedirect("information-01.jsp");
            }else {
                response.sendRedirect("create-your-account.jsp");
            }
        }
    }
    public void handleForgotPassword(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy thông tin người dùng quên mật khẩu
        String email = request.getParameter("email");

        // Kiểm tra xem email có tồn tại trong tài khoản nào không
        Account account = accountDAO.findByUsername(email);

        if (account != null) {
            // Gửi email khôi phục mật khẩu
            String newPassword = generateRandomPassword(); // Tạo mật khẩu tạm thời
            account.setPassword(newPassword);
            accountDAO.updateAccount(account); // Cập nhật mật khẩu mới

            String emailContent = "Mật khẩu mới của bạn là: " + newPassword;
            EmailInfo info = new EmailInfo(email,"Chăm sóc khách hàng từ Habit.IMO", emailContent);
            ServiceManager.getInstance().sendEmailService.handleSendEmail(request,response,info);

            // Trả về thông báo thành công
            request.setAttribute("message", "Vui lòng kiểm tra email của bạn để lấy mật khẩu mới.");
            request.getServletContext()
                    .getRequestDispatcher("/continue-with-email.jsp")
                    .forward(request, response);
        } else {
            // Trả về thông báo thất bại
            request.setAttribute("message", "Email không tồn tại trong hệ thống.");
            request.getServletContext()
                    .getRequestDispatcher("/forgot-password.jsp")
                    .forward(request, response);
        }
    }

    public void handleChangePassword(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy thông tin người dùng thay đổi mật khẩu
        String oldPassword = request.getParameter("oldpassword");
        String newPassword = request.getParameter("newpassword");
        String confirmPassword = request.getParameter("newpassword2");

        // Kiểm tra thông tin
        if (newPassword.equals(confirmPassword)) {
            // Kiểm tra mật khẩu cũ có đúng không
            Account account = AppManager.getInstance().getCurrentAccount();
            if (account.getPassword().equals(oldPassword)) {
                // Cập nhật mật khẩu mới
                account.setPassword(newPassword);
                accountDAO.updateAccount(account);

                // Trả về thông báo thành công
                request.setAttribute("message", "Mật khẩu đã được thay đổi thành công.");
                request.getServletContext()
                        .getRequestDispatcher("/continue-with-email.jsp")
                        .forward(request, response);
            } else {
                // Trả về thông báo thất bại
                request.setAttribute("message", "Mật khẩu cũ không chính xác.");
                request.getServletContext()
                        .getRequestDispatcher("/change-password.jsp")
                        .forward(request, response);
            }
        } else {
            // Trả về thông báo thất bại
            request.setAttribute("message", "Mật khẩu mới và mật khẩu xác nhận không trùng khớp.");
            request.getServletContext()
                    .getRequestDispatcher("/change-password.jsp")
                    .forward(request, response);
        }
    }

    public static String generateRandomPassword() {
        // Tạo một chuỗi gồm các ký tự chữ và số
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        // Tạo một mật khẩu có độ dài 8 ký tự
        int passwordLength = 8;

        // Tạo một mật khẩu ngẫu nhiên
        String password = "";
        for (int i = 0; i < passwordLength; i++) {
            password += characters.charAt((int) (Math.random() * characters.length()));
        }

        return password;
    }

}
