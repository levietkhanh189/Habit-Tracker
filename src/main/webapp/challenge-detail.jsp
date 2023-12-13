<%@ page import="java.util.List" %>
<%@ page import="model.entity.Habit" %>
<%@ page import="model.entity.HabitTracker" %>
<%@ page import="model.entity.Challenge" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="initial-scale=1, width=device-width" />
  <link rel="stylesheet" href="styles/global.css" />
  <link rel="stylesheet" href="styles/habit-card.css" />
  <link rel="stylesheet" href="styles/challenge-detail.css" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700;900&display=swap" />
</head>
<body>
<div class="challenge-detail">
  <div class="header9">
    <div class="status-bar5"></div>
    <div class="header-type-14">
      <button class="left-icon4" id="leftIcon">
        <img class="iconsarrow-left-24" alt="" src="./public/iconsarrow--left-2.svg" />
        <div class="dot7"></div>
      </button>
      <div class="middle"></div>
      <div class="right-icon">
        <img class="iconsarrow-left-24" alt="" src="./public/iconsplus.svg" />
        <div class="dot7"></div>
      </div>
    </div>
  </div>
  <% Challenge challenge = (Challenge) request.getSession().getAttribute("challenge"); %>
  <div class="content7">
    <div class="header10">
      <b class="emoji7"></b>
      <b class="title17"><%= challenge.getName() %></b>
      <div class="dates"><%= challenge.getEndDate() %></div>
    </div>
    <div class="desc">
      <div class="friends1">
        <img class="mask-icon" alt="" src="./public/mask@2x.png" />
        <img class="mask-icon1" alt="" src="./public/mask1@2x.png" />
        <img class="mask-icon1" alt="" src="./public/mask2@2x.png" />
        <img class="mask-icon1" alt="" src="./public/mask3@2x.png" />
        <img class="mask-icon1" alt="" src="./public/mask4@2x.png" />
        <div class="avatar-31">
          <b class="b1">+9</b>
        </div>
      </div>
      <div class="desc1"><%= challenge.getDescription() %></div>
    </div>
  </div>
      <form action="joinchallenge" method="post">
        <button class="button3" id="Joint" type="submit" name="challengeId" value="<%=challenge.getId().toString()%>">
          <img class="iconsnotification8" alt="" src="./public/iconsnotification4.svg" />
          <img class="iconsnotification9" alt="" src="./public/iconsnotification6.svg" />
          <div class="label14">Join the Challenge</div>
        </button>
      </form>
    </div>
    <ul class="tasks" id="Habit-group">
      <div class="home3">Tasks</div>
      <div style="overflow-y: auto; max-height: 270px;max-width: 600px;">

        <% List<Habit> habits = (List<Habit>) request.getSession().getAttribute("habits");
          if (habits != null) {
            for (Habit habit : habits) { %>
        <div class="habit-card1" id="habit-card">
          <div class="icon9">
            <div class="circle-loader1">
              <div class="circle-loader-inner"></div>
              <div class="ellipse-div"></div>
              <div class="div2">%0</div>
            </div>
            <div class="emoji6"><%= habit.getIcon() %></div>
          </div>
          <div class="text4">
            <div class="title5"><%= habit.getHabitName() %></div>
          </div>
          <input class="add-button1" id="checkbox" type="checkbox"/>
          <div class="done-button1">
            <img class="iconstick-square1" alt="" src="./public/iconstick-square.svg" />
            <div class="dot3"></div>
          </div>
        </div>
        <%     }
        }
        %>
      </div>
<%--      <div class="habit-card2">--%>
<%--        <div class="icon13">--%>
<%--          <div class="circle-loader2">--%>
<%--            <div class="circle-loader-child1"></div>--%>
<%--            <div class="circle-loader-child2"></div>--%>
<%--            <div class="div3">%0</div>--%>
<%--          </div>--%>
<%--          <div class="emoji8">💧</div>--%>
<%--        </div>--%>
<%--        <div class="text9">--%>
<%--          <div class="title18">Drink the water</div>--%>
<%--        </div>--%>
<%--        <div class="add-button2">--%>
<%--          <img class="iconsarrow-left-24" alt="" src="./public/iconsplus.svg" />--%>
<%--          <div class="dot7"></div>--%>
<%--        </div>--%>
<%--        <div class="done-button2">--%>
<%--          <img class="iconsarrow-left-24" alt="" src="./public/iconstick-square.svg" />--%>
<%--          <div class="dot7"></div>--%>
<%--        </div>--%>
<%--      </div>--%>
<%--      <div class="habit-card2">--%>
<%--        <div class="icon13">--%>
<%--          <div class="circle-loader2">--%>
<%--            <div class="circle-loader-child1"></div>--%>
<%--            <div class="circle-loader-child2"></div>--%>
<%--            <div class="div3">%0</div>--%>
<%--          </div>--%>
<%--          <div class="emoji8">💧</div>--%>
<%--        </div>--%>
<%--        <div class="text9">--%>
<%--          <div class="title18">Drink the water</div>--%>
<%--        </div>--%>
<%--        <div class="add-button2">--%>
<%--          <img class="iconsarrow-left-24" alt="" src="./public/iconsplus.svg" />--%>
<%--          <div class="dot7"></div>--%>
<%--        </div>--%>
<%--        <div class="done-button2">--%>
<%--          <img class="iconsarrow-left-24" alt="" src="./public/iconstick-square.svg" />--%>
<%--          <div class="dot7"></div>--%>
<%--        </div>--%>
<%--      </div>--%>
<%--      <div class="habit-card4">--%>
<%--        <div class="icon13">--%>
<%--          <div class="circle-loader2">--%>
<%--            <div class="circle-loader-child1"></div>--%>
<%--            <div class="circle-loader-child2"></div>--%>
<%--            <div class="div3">%0</div>--%>
<%--          </div>--%>
<%--          <div class="emoji8">💧</div>--%>
<%--        </div>--%>
<%--        <div class="text9">--%>
<%--          <div class="title18">Drink the water</div>--%>
<%--        </div>--%>
<%--        <div class="add-button2">--%>
<%--          <img class="iconsarrow-left-24" alt="" src="./public/iconsplus.svg" />--%>
<%--          <div class="dot7"></div>--%>
<%--        </div>--%>
<%--        <div class="done-button2">--%>
<%--          <img class="iconsarrow-left-24" alt="" src="./public/iconstick-square.svg" />--%>
<%--          <div class="dot7"></div>--%>
<%--        </div>--%>
<%--      </div>--%>
    </ul>
  </div>
</div>
<script>
  var leftIcon = document.getElementById("leftIcon");
  if (leftIcon) {
    leftIcon.addEventListener("click", function(e) {
      window.location.href = "./home.html";
    });
  }
</script>
</body>
</html>