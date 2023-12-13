package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.mail.Message;

import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;

import jakarta.mail.internet.MimeMessage;
import ulti.EmailInfo;

public class SendEmailService {
   public SendEmailService(){}
    public void handleSendEmail(HttpServletRequest request, HttpServletResponse response, EmailInfo info)
            throws ServletException, IOException {

        // Lấy thông tin người nhận từ request
        String email = info.email;

        // Lấy thông tin người gửi từ cấu hình
        String sender = "21110206@student.hcmute.edu.vn";//getServletContext().getInitParameter("sender");
        String password = "Cubi@2705";//getServletContext().getInitParameter("password");

        // Tạo đối tượng Session
        Session session = Session.getDefaultInstance(new Properties());

        // Tạo đối tượng Message
        Message message = new MimeMessage(session);

        // Thiết lập người gửi và người nhận
        try {
            message.setFrom(new InternetAddress(sender));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));

            message.setSubject(info.subject);
            message.setText(info.content);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


        // Gửi email
        try {
            Transport.send(message);
        } catch (MessagingException e) {
            throw new ServletException(e);
        }

        // Trả về kết quả
//        response.setContentType("text/html");
    }
}

