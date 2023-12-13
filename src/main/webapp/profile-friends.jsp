<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="initial-scale=1, width=device-width" />

    <link rel="stylesheet" href="styles/global.css" />
    <link rel="stylesheet" href="styles/profile-friends.css" />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700;900&display=swap"
    />
  </head>
  <body>
    <div class="profile-friends">
      <div class="content9">
        <div class="header13">
          <div class="status-bar8"></div>
          <div class="header-type-16">
            <div class="left-icon5">
              <img class="iconsplus" alt="" src="./public/iconscalendar.svg" />

              <div class="dot7"></div>
            </div>
            <div class="title-frame">
              <b class="title46">Your Profile</b>
            </div>
            <div class="right-icon3">
              <img class="iconsplus" alt="" src="./public/iconssetting.svg" />

              <div class="dot7"></div>
            </div>
          </div>
          <div class="profile1">
            <img class="base-icon1" alt="" src="./public/base@2x.png" />

            <div class="home-group">
              <div class="home7">Mert Kahveci</div>
              <div class="status-badge5">
                <img class="iconsmedal5" alt="" src="./public/iconsmedal.svg" />

                <div class="badge-text5">1452 Points</div>
              </div>
            </div>
          </div>
          <div class="segment-control1">
            <div class="st-tab1">
              <div class="badge-text5">Activity</div>
              <div class="text-wrapper1">
                <b class="text29">1</b>
              </div>
            </div>
            <div class="nd-tab1">
              <div class="badge-text5">Friends</div>
              <div class="text-wrapper2">
                <b class="text29">1</b>
              </div>
            </div>
            <div class="rd-tab1">
              <div class="badge-text5">Achievements</div>
              <div class="text-wrapper1">
                <b class="text29">1</b>
              </div>
            </div>
            <div class="th-tab1">
              <div class="badge-text5">All Day</div>
              <div class="text-wrapper1">
                <b class="text29">1</b>
              </div>
            </div>
          </div>
        </div>
        <div class="top-bar2">
          <div class="bar">
            <div class="home8">0 Friends</div>
            <div class="button1">
              <div class="right-icon4">
                <img class="iconsplus" alt="" src="./public/iconsplus.svg" />

                <div class="dot7"></div>
              </div>
            </div>
          </div>
          <div class="content10">
            <div class="friend-card1">
              <img class="mask-icon14" alt="" src="./public/mask3@2x.png" />

              <div class="text36">
                <div class="title47">Micah Dantoni</div>
                <div class="description20">912 Points</div>
              </div>
              <button class="add-button2">
                <img
                  class="iconstrash-can1"
                  alt=""
                  src="./public/iconstrash-can.svg"
                />
              </button>
            </div>
            <div class="friend-card1">
              <img class="mask-icon14" alt="" src="./public/mask3@2x.png" />

              <div class="text36">
                <div class="title47">Micah Dantoni</div>
                <div class="description20">912 Points</div>
              </div>
              <button class="add-button2">
                <img
                  class="iconstrash-can1"
                  alt=""
                  src="./public/iconstrash-can.svg"
                />
              </button>
            </div>
            <div class="friend-card1">
              <img class="mask-icon14" alt="" src="./public/mask3@2x.png" />

              <div class="text36">
                <div class="title47">Micah Dantoni</div>
                <div class="description20">912 Points</div>
              </div>
              <button class="add-button2" >
                <img
                  class="iconstrash-can1"
                  alt=""
                  src="./public/iconstrash-can.svg"
                />
              </button>
            </div>
            <div class="friend-card1">
              <img class="mask-icon14" alt="" src="./public/mask3@2x.png" />

              <div class="text36">
                <div class="title47">Micah Dantoni</div>
                <div class="description20">912 Points</div>
              </div>
              <button class="add-button2">
                <img
                  class="iconstrash-can1"
                  alt=""
                  src="./public/iconstrash-can.svg"
                />
              </button>
            </div>
            <div class="friend-card1">
              <img class="mask-icon14" alt="" src="./public/mask3@2x.png" />

              <div class="text36">
                <div class="title47">Micah Dantoni</div>
                <div class="description20">912 Points</div>
              </div>
              <button class="add-button2" id="DeleteBtn">
                <img
                  class="iconstrash-can1"
                  alt=""
                  src="./public/iconstrash-can.svg"
                />
              </button>
            </div>
            <div class="friend-card1">
              <img class="mask-icon14" alt="" src="./public/mask3@2x.png" />

              <div class="text36">
                <div class="title47">Micah Dantoni</div>
                <div class="description20">912 Points</div>
              </div>
              <button class="add-button2">
                <img
                  class="iconstrash-can1"
                  alt=""
                  src="./public/iconstrash-can.svg"
                />
              </button>
            </div>
            <div class="friend-card1">
              <img class="mask-icon14" alt="" src="./public/mask3@2x.png" />

              <div class="text36">
                <div class="title47">Micah Dantoni</div>
                <div class="description20">912 Points</div>
              </div>
              <button class="add-button2">
                <img
                  class="iconstrash-can1"
                  alt=""
                  src="./public/iconstrash-can.svg"
                />
              </button>
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

      var rdTabContainer = document.getElementById("rdTabContainer");
      if (rdTabContainer) {
        rdTabContainer.addEventListener("click", function (e) {
          window.location.href = "./profile-achievements.jsp";
        });
      }
    </script>
  </body>
</html>
