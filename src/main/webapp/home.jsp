<%@ page import="java.util.List" %>
<%@ page import="model.entity.Habit" %>
<%@ page import="model.entity.HabitTracker" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="initial-scale=1, width=device-width" />
  <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
  <link rel="stylesheet" href="styles/habit-card.css" />
  <link rel="stylesheet" href="styles/global.css" />
  <link rel="stylesheet" href="styles/home.css" />
  <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700;900&display=swap" />
</head>
<body>
<div class="home4" data-animate-on-scroll>
  <div class="header11">
    <div class="status-bar6"></div>
    <div class="header-type-15">
<%--      <button class="left-icon5" id="calender">--%>
<%--        <div class="iconscalendar" id="calender1">--%>
<%--          <img class="secondary-icon" alt="" src="./public/-secondary.svg" />--%>
<%--          <img class="primary-icon" alt="" src="./public/-primary.svg" />--%>
<%--        </div>--%>
<%--        <div class="dot15"></div>--%>
<%--      </button>--%>
          <input type="date" id="datepicker" class="left-icon5">
<%--          <div class="iconscalendar" id="calender1">--%>
<%--            <img class="secondary-icon" alt="" src="./public/-secondary.svg" />--%>
<%--            <img class="primary-icon" alt="" src="./public/-primary.svg" />--%>
<%--          </div>--%>
<%--          <div class="dot15"></div>--%>
      <div class="middle1"></div>
      <div class="right-icon1">
        <img class="iconsnotification10" alt="" src="./public/iconsnotification7.svg" />
        <div class="dot16"></div>
      </div>
    </div>
    <div class="top-content">
      <div class="text12">
        <div class="title21">Hi, Mert 👋🏻</div>
        <div class="subtitle">Let’s make habits together!</div>
      </div>
      <div class="mood1">
            <textarea class="averange-mood" placeholder="😇" id="mood">
😇</textarea>
      </div>
    </div>
  </div>
  <div class="frame8">
    <div class="content8">
      <div class="info-box" id="daily">
        <div class="circle-loader5">
          <div class="circle-loader-child7"></div>
          <div class="circle-loader-child8"></div>
          <div class="div6">%25</div>
        </div>
        <aside class="text13">
          <div class="headline-1">Your daily goals almost done! 🔥</div>
          <div class="headline-2">1 of 4 completed</div>
        </aside>
      </div>
      <div class="tasks1">
        <div class="challenge-frame" id="challenge-group">
          <div class="title22">
            <div class="home5">Challenges</div>
            <b class="home6">View All</b>
          </div>
          <div class="challenge-card1">
            <div class="title22">
              <img class="iconstime-circle2" alt="" src="./public/iconstime-circle2.svg" />
              <div class="text14">
                <div class="headline-1">Best Runners! 🏃🏻‍</div>
                <div class="funny3">5 days 13 hours left</div>
              </div>
            </div>
            <div class="progress-bar1">
              <div class="progress-bar-item"></div>
            </div>
          </div>
        </div>
        <div class="habit-group" id="habit-group">
          <div class="title23">
            <div class="home5">Habits</div>
            <b class="home6">View All</b>
          </div>
          <div style="overflow-y: auto; max-height: 270px;max-width: 600px;">

          <% List<HabitTracker> habits = (List<HabitTracker>) request.getSession().getAttribute("habittrackers");
            if (habits != null) {
              for (HabitTracker habit : habits) { %>
          <div class="habit-card1" id="habit-card">
            <div class="icon9">
              <div class="circle-loader1">
                <div class="circle-loader-inner"></div>
                <div class="ellipse-div"></div>
                <div class="div2">%0</div>
              </div>
              <div class="emoji6"><%= habit.getHabit().getIcon() %></div>
            </div>
            <div class="text4">
              <div class="title5"><%= habit.getHabit().getHabitName() %></div>
            </div>
            <input class="add-button1" id="checkbox" type="checkbox" name="habitId" value="<%= habit.getId() %>" onchange="handleCheckboxChange(this)" <%=(habit.getStatus().equals("Completed")) ? "checked" : "" %>/>
            <div class="done-button1">
              <img class="iconstick-square1" alt="" src="./public/iconstick-square.svg" />
              <div class="dot3"></div>
            </div>
          </div>
          <%     }
          }
          %>
        </div>
        </div>
      </div>
    </div>

  <%@ include file="app-bar.jsp" %>
  </div>
</div>
<script>
  $(function() {
    $("#datepicker").datepicker({
      dateFormat: 'yy-mm-dd', // Định dạng ngày
      onSelect: function(dateText) {
        console.log("run servlet");
        var formattedDate = moment(dateText, 'yy-mm-dd').format('YYYY-MM-DD');
        console.log(formattedDate.toString());
        $.ajax({
          type: "POST",
          url: "historydate", // Thay thế bằng URL của servlet của bạn
          data: { selectedDate: formattedDate } // Gửi ngày đã chọn tới servlet
        });
      }
    });
  });

  function handleCheckboxChange(checkbox) {
    console.log("Checkbox changed!");
    var habitId = checkbox.value;
    var isChecked = checkbox.checked;
    $.ajax({
      type: "POST",
      url: "habittracker",
      data: { habitId: habitId, isChecked: isChecked }
    });
  }

  var scrollAnimElements = document.querySelectorAll("[data-animate-on-scroll]");
  var observer = new IntersectionObserver(
          (entries) => {
            for (const entry of entries) {
              if (entry.isIntersecting || entry.intersectionRatio > 0) {
                const targetElement = entry.target;
                targetElement.classList.add("animate");
                observer.unobserve(targetElement);
              }
            }
          }, {
            threshold: 0.15,
          });
  for (let i = 0; i < scrollAnimElements.length; i++) {
    observer.observe(scrollAnimElements[i]);
  }
</script>
</body>
</html>