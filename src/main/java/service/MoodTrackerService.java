package service;

import model.dao.MoodTrackerDAO;
import model.entity.MoodTracker;
import model.entity.MyUser;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MoodTrackerService {

    private MoodTrackerDAO moodTrackerDAO;

    public MoodTrackerService(MoodTrackerDAO moodTrackerDAO) {
        this.moodTrackerDAO = moodTrackerDAO;
    }

    public void handle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("getAllMoodTrackersByUserId".equals(action)) {
            handleGetAllMoodTrackersByUserId(request, response);
        } else if ("createMoodTrackerByUserIdAndDate".equals(action)) {
            handleCreateMoodTrackerByUserIdAndDate(request, response);
        }

        // Add other actions as needed
    }

    private void handleGetAllMoodTrackersByUserId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xử lý lấy tất cả MoodTracker theo userId ở đây

        Long userId = Long.parseLong(request.getParameter("userId"));
        MyUser user = new MyUser(); // Lấy MyUser từ userId, có thể sử dụng MyUserDAO

                List<MoodTracker> moodTrackers = moodTrackerDAO.findByUser(user);

        // Gửi dữ liệu moodTrackers đến trang JSP hoặc chuyển hướng đến trang khác để hiển thị
    }

    private void handleCreateMoodTrackerByUserIdAndDate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xử lý tạo MoodTracker theo userId và date ở đây

        Long userId = Long.parseLong(request.getParameter("userId"));
        MyUser user = new MyUser();// Lấy MyUser từ userId, có thể sử dụng MyUserDAO

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(request.getParameter("date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        MoodTracker moodTracker = new MoodTracker();
        moodTracker.setUser(user);
        moodTracker.setDate(date);

        moodTrackerDAO.create(moodTracker);

        // Gửi thông báo thành công hoặc chuyển hướng đến trang khác
    }

    // Các phương thức xử lý khác có thể được thêm vào tùy theo yêu cầu
}
