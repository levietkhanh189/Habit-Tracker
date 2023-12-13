<%@ page import="java.util.List" %>
<%@ page import="model.entity.Habit" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="initial-scale=1, width=device-width" />
  <link rel="stylesheet" href="styles/global.css" />
  <link rel="stylesheet" href="styles/new-default-habit.css" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700;900&display=swap" />
</head>
<body>
<div class="new-default-habit">
  <div class="top1">
    <img class="base-icon" alt="" src="./public/base.svg" />

    <div class="dot"></div>
  </div>
    <b class="card-setting">NEW GOOD HABIT</b>
    <a
            class="habit-card"
            id="createhabit"
            href="./create-custom-habit.jsp"
    >
      <div class="icon3">
        <div class="circle-loader">
          <div class="circle-loader-child"></div>
          <div class="circle-loader-item"></div>
          <div class="div">%25</div>
        </div>
        <div class="emoji5">💧</div>
      </div>
      <img
              class="iconsshield-fail1"
              alt=""
              src="./public/iconsshield-fail1.svg"
      />

      <div class="text3">
        <div class="title4">Create Custom Habit</div>
        <div class="description4">500/2000 ML</div>
      </div>
      <div class="friends">
        <img class="avatar-1-icon" alt="" src="./public/avatar-1.svg" />

        <img class="avatar-2-icon" alt="" src="./public/avatar-2.svg" />

        <div class="avatar-3">
          <b class="b">+3</b>
        </div>
      </div>
      <div class="add-button">
        <img class="iconsplus" alt="" src="./public/iconsplus.svg" />

        <div class="dot1"></div>
      </div>
      <div class="done-button">
        <img class="iconsplus" alt="" src="./public/iconstick-square.svg" />

        <div class="dot1"></div>
      </div>
    </a>
    <b class="card-setting">POPULAR Habıts</b>
    <div style = "overflow-x : auto; height:700px;white-space: nowrap;display: flex;">
      <form action="createhabit" method="post">
        <div>
          <%
            List<Habit> habits = (List<Habit>) request.getSession().getAttribute("habits");
            if (habits != null && !habits.isEmpty()) {
              for (Habit habit : habits) {
          %>
          <button class="habit-button" type="submit" name="info" value="<%=habit.getIdToString()%>">
            <b class="icon4"><%= habit.getIcon() %> </b>
            <div class="run"><%= habit.getHabitName() %> </div>
          </button><%
          }
        } else {
        %> <p>No habits available.</p><%
          }
        %>
        </div>

      </form>
    </div>
</div>
</body>
</html>