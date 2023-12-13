package service;

import model.dao.ConnectDAO;
import model.entity.Connect;
import model.entity.MyUser;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ConnectService {

    private ConnectDAO connectDAO;

    public ConnectService(ConnectDAO connectDAO) {
        this.connectDAO = connectDAO;
    }

    public void handleGetAllConnects(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xử lý lấy tất cả connects ở đây

        List<Connect> connects = connectDAO.findAll();

        // Gửi dữ liệu connects đến trang JSP hoặc chuyển hướng đến trang khác để hiển thị
    }

    public void handleAddConnect(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xử lý thêm connect với friendId ở đây

        Long userId = Long.parseLong(request.getParameter("userId"));
        Long friendId = Long.parseLong(request.getParameter("friendId"));

        MyUser user = new MyUser();// Lấy MyUser từ userId, có thể sử dụng MyUserDAO
        MyUser friend = new MyUser();// Lấy MyUser từ friendId, có thể sử dụng MyUserDAO

                Connect newConnect = new Connect();
        newConnect.setUser(user);
        newConnect.setFriend(friend);

        connectDAO.create(newConnect);

        // Gửi thông báo thành công hoặc chuyển hướng đến trang khác
    }

    public void handleDeleteConnect(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xử lý xoá connect ở đây

        Long connectId = Long.parseLong(request.getParameter("connectId"));

        Connect connect = connectDAO.findById(connectId);
        connectDAO.delete(connect);

        // Gửi thông báo xoá thành công hoặc chuyển hướng đến trang khác
    }

    // Các phương thức xử lý khác có thể được thêm vào tùy theo yêu cầu
}
