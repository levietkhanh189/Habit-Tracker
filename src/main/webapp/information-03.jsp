<%@ page import="java.util.List" %>
<%@ page import="model.entity.Habit" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="initial-scale=1, width=device-width" />
  <link rel="stylesheet" href="styles/global.css" />
  <link rel="stylesheet" href="styles/icon-button.css" />
  <link rel="stylesheet" href="styles/information-03.css" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700;900&display=swap" />
</head>
<body>
<div class="information-03" data-animate-on-scroll>
  <div class="header13">
    <div class="status-bar7"></div>
    <div class="header-type-16">
      <button class="left-icon6" id="back">
        <img class="iconsarrow-left-25" alt="" src="./public/iconsarrow--left-2.svg" />
      </button>
      <div class="title-frame">
        <b class="title28">Information</b>
      </div>
    </div>
  </div>
  <div class="header14">
    <div class="title29">Choose your first habits</div>
    <div class="desc2">You may add more habits later</div>
  </div>
  <form action="userinfo" method="post">
    <div style = "overflow-y : auto; height:700px">
    <%
      List<Habit> habits = (List<Habit>) request.getSession().getAttribute("habits");
      if (habits != null && !habits.isEmpty()) {
        for (Habit habit : habits) {
    %>
    <button class="icon-button" type="submit" name="info" value="<%=habit.getIdToString()%>">
    <b class="icon3"><%= habit.getIcon() %> </b>
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
<script>
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