<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="initial-scale=1, width=device-width" />
  <link rel="stylesheet" href="styles/global.css" />
  <link rel="stylesheet" href="styles/create-custom-habit.css" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700;900&display=swap" />
</head>
<body>
<div class="create-custom-habit" style = "overflow-y : auto; height:700px">
  <div class="header4">
    <div class="status-bar4"></div>
    <div class="header-type-13">
      <a class="left-icon3" href="./home.jsp">
        <img class="iconsarrow-left-23" alt="" src="./public/iconsarrow--left-2.svg" />
        <div class="dot6"></div>
      </a>
      <div class="box">
        <b class="title9">Create Custom Habit</b>
      </div>
    </div>
  </div>
  <form action="createhabit" class="content6" method="post">
    <div class="name-habit">
      <b class="label11">Name</b>
      <div class="inputtext7">
        <input class="search7" name="habit-name" placeholder="Enter your habit" type="text" />
      </div>
    </div>
    <div class="icon10">
      <b class="home">Add your icon</b>
      <div class="icon11">
        <div class="icon-habit">
          <div class="icon-wrapper">
                <textarea class="icon12" name="habitIcon" placeholder="🚶‍♀️" rows="{1}" maxlength="{1}" autofocus="{true}" cols="{1}">
🚶‍♀️</textarea>
          </div>
          <div class="text6">
            <div class="title10"> Icon can help you remember habit easily. </div>
          </div>
        </div>
      </div>
    </div>
    <div class="goal">
      <b class="home">Goal</b>
      <div class="bad-habit1">
        <div class="icon11">
          <div class="text7">
            <input class="title11" name="goal" placeholder="1 times" type="text" />
            <div class="description5">or more per day</div>
          </div>
        </div>
        <div class="header6">
          <div class="iconsarrows-clockwise-parent">
            <img class="iconsarrows-clockwise" alt="" src="./public/iconsarrows--clockwise.svg" />
            <div class="title12">Daily</div>
          </div>
          <div class="iconsarrows-clockwise-parent">
            <img class="iconsarrows-clockwise" alt="" src="./public/iconspaper.svg" />
            <div class="title12">Every day</div>
          </div>
        </div>
      </div>
    </div>
    <div class="reminders">
      <b class="home">REMINDER</b>
      <div class="reminder">
        <div class="bad-habit1">
          <div class="header7">
            <div class="text8">
              <div class="title14"> Remember to set off time for a workout today. </div>
            </div>
            <input class="switch" id="check" type="checkbox" />
          </div>
          <div class="header6">
            <div class="iconstime-circle-parent">
              <img class="iconsarrows-clockwise" alt="" src="./public/iconstime-circle1.svg" />
              <div class="title12">09:30</div>
            </div>
            <div class="iconstime-circle-parent">
              <img class="iconsbell" alt="" src="./public/iconsbell.svg" />
              <div class="title12">Every day</div>
            </div>
          </div>
        </div>
        <div class="next3">
          <img class="iconsnotification4" alt="" src="./public/iconsnotification2.svg" />
          <img class="iconsnotification5" alt="" src="./public/iconsnotification3.svg" />
          <div class="label12">Add Reminder</div>
        </div>
      </div>
    </div>
    <div class="habits">
      <b class="home">Location</b>
      <div class="inputtext7">
        <input class="search7" name="location" placeholder="Enter where you will do this" type="text" />
      </div>
    </div>
    <button class="next4" id="addhabit" type="submit" name="info" value="custom">
      <img class="iconsnotification4" alt="" src="./public/iconsnotification4.svg" />
      <img class="iconsnotification5" alt="" src="./public/iconsnotification5.svg" />
      <div class="label13">Add Habit</div>
    </button>
  </form>
</div>
</body>
</html>