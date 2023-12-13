<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="initial-scale=1, width=device-width" />

    <link rel="stylesheet" href="styles/global.css" />
    <link rel="stylesheet" href="styles/profile-achievements.css" />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700;900&display=swap"
    />
  </head>
  <body>
    <div class="profile-achievements">
      <div class="content7">
        <div class="header12">
          <div class="status-bar7"></div>
          <div class="header-type-15">
            <div class="left-icon4">
              <img
                class="iconscalendar"
                alt=""
                src="./public/iconscalendar.svg"
              />

              <div class="dot5"></div>
            </div>
            <div class="title-container">
              <b class="title32">Your Profile</b>
            </div>
            <div class="right-icon2">
              <img
                class="iconscalendar"
                alt=""
                src="./public/iconssetting.svg"
              />

              <div class="dot5"></div>
            </div>
          </div>
          <div class="profile">
            <img class="base-icon" alt="" src="./public/base@2x.png" />

            <div class="home-parent">
              <div class="home5">Mert Kahveci</div>
              <div class="status-badge4">
                <img class="iconsmedal4" alt="" src="./public/iconsmedal.svg" />

                <div class="badge-text4">1452 Points</div>
              </div>
            </div>
          </div>
          <div class="segment-control">
            <div class="st-tab">
              <div class="badge-text4">Activity</div>
              <div class="text-wrapper">
                <b class="text14">1</b>
              </div>
            </div>
            <div class="nd-tab">
              <div class="badge-text4">Friends</div>
              <div class="text-wrapper">
                <b class="text14">1</b>
              </div>
            </div>
            <div class="rd-tab">
              <div class="badge-text4">Achievements</div>
              <div class="text-frame">
                <b class="text14">1</b>
              </div>
            </div>
            <div class="th-tab">
              <div class="badge-text4">All Day</div>
              <div class="text-wrapper">
                <b class="text14">1</b>
              </div>
            </div>
          </div>
        </div>
        <div class="top-bar1">
          <div class="home6">0 Achievements</div>
          <div class="content8">
            <div class="achieve-card1">
              <div class="ellipse-group">
                <div class="frame-item"></div>
                <div class="title33">🥇</div>
              </div>
              <div class="text21">
                <div class="title34">Best of the month!</div>
                <div class="description13">2 days ago</div>
              </div>
            </div>
            <div class="achieve-card1">
              <div class="ellipse-group">
                <div class="frame-item"></div>
                <div class="title33">🥇</div>
              </div>
              <div class="text21">
                <div class="title34">Best of the month!</div>
                <div class="description13">2 days ago</div>
              </div>
            </div>
            <div class="achieve-card1">
              <div class="ellipse-group">
                <div class="frame-item"></div>
                <div class="title33">🥇</div>
              </div>
              <div class="text21">
                <div class="title34">Best of the month!</div>
                <div class="description13">2 days ago</div>
              </div>
            </div>
            <div class="achieve-card1">
              <div class="ellipse-group">
                <div class="frame-item"></div>
                <div class="title33">🥇</div>
              </div>
              <div class="text21">
                <div class="title34">Best of the month!</div>
                <div class="description13">2 days ago</div>
              </div>
            </div>
            <div class="achieve-card1">
              <div class="ellipse-group">
                <div class="frame-item"></div>
                <div class="title33">🥇</div>
              </div>
              <div class="text21">
                <div class="title34">Best of the month!</div>
                <div class="description13">2 days ago</div>
              </div>
            </div>
            <div class="achieve-card1">
              <div class="ellipse-group">
                <div class="frame-item"></div>
                <div class="title33">🥇</div>
              </div>
              <div class="text21">
                <div class="title34">Best of the month!</div>
                <div class="description13">2 days ago</div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <%@ include file="app-bar.jsp" %>
    <script>
      var rightIconContainer = document.getElementById("rightIconContainer");
      if (rightIconContainer) {
        rightIconContainer.addEventListener("click", function (e) {
          window.location.href = "./settings.jsp";
        });
      }

      var stTabContainer = document.getElementById("stTabContainer");
      if (stTabContainer) {
        stTabContainer.addEventListener("click", function (e) {
          window.location.href = "./profile-activity.jsp";
        });
      }

      var ndTabContainer = document.getElementById("ndTabContainer");
      if (ndTabContainer) {
        ndTabContainer.addEventListener("click", function (e) {
          window.location.href = "./profile-friends.jsp";
        });
      }
    </script>
  </body>
</html>
