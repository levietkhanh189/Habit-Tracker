<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="initial-scale=1, width=device-width" />

    <link rel="stylesheet" href="styles/global.css" />
    <link rel="stylesheet" href="styles/settings.css" />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700;900&display=swap"
    />
  </head>
  <body>
    <div class="settings">
      <div class="header11">
        <div class="status-bar6"></div>
        <div class="header-type-14">
          <div class="left-icon3">
            <img
              class="iconspassword"
              alt=""
              src="./public/iconsarrow--left-2.svg"
            />
          </div>
          <div class="title-wrapper">
            <b class="title30">Settings</b>
          </div>
        </div>
      </div>
      <div class="general">
        <b class="card-setting">GENERAL</b>
        <div class="box">
          <div class="item" id="itemContainer">
            <img
              class="iconspassword"
              alt=""
              src="./public/iconspassword.svg"
            />

            <div class="share-account">Security</div>
            <img
              class="iconspassword"
              alt=""
              src="./public/iconsarrow--right-2.svg"
            />
          </div>
          <div class="item1">
            <img
              class="iconspassword"
              alt=""
              src="./public/iconsvolume-up.svg"
            />

            <div class="share-account">Sounds</div>
            <img class="switch-icon" alt="" src="./public/switch.svg" />
          </div>
          <div class="item2">
            <img class="iconspassword" alt="" src="./public/iconsplay.svg" />

            <div class="share-account">Vacation Mode</div>
            <img class="switch-icon" alt="" src="./public/switch1.svg" />
          </div>
          <div class="item" id="itemContainer3">
            <img class="iconspassword" alt="" src="./public/iconspassword1.svg"/>

            <div class="share-account">Sign out</div>
            <img class="iconspassword" alt="" src="./public/iconsarrow--right-2.svg"/>
          </div>
        </div>
      </div>
      <div class="general">
        <b class="card-setting">ABOUT US</b>
        <div class="habit-card" id="habitCardContainer">
          <div class="item1">
            <img class="iconspassword" alt="" src="./public/iconsstar.svg" />

            <div class="share-account">Rate Routiner</div>
            <img
              class="iconspassword"
              alt=""
              src="./public/iconsarrow--right-2.svg"
            />
          </div>
          <div class="item1">
            <img class="iconspassword" alt="" src="./public/iconsshare.svg" />

            <div class="share-account">Share with Friends</div>
            <img
              class="iconspassword"
              alt=""
              src="./public/iconsarrow--right-2.svg"
            />
          </div>
          <div class="item1">
            <img
              class="iconspassword"
              alt=""
              src="./public/iconsinfo-square.svg"
            />

            <div class="share-account">About Us</div>
            <img
              class="iconspassword"
              alt=""
              src="./public/iconsarrow--right-2.svg"
            />
          </div>
          <div class="item2">
            <img
              class="iconschat-dots"
              alt=""
              src="./public/iconschat-dots.svg"
            />

            <div class="share-account">Support</div>
            <img
              class="iconspassword"
              alt=""
              src="./public/iconsarrow--right-2.svg"
            />
          </div>
        </div>
      </div>
    </div>

    <script>
      var leftIconContainer = document.getElementById("leftIconContainer");
      if (leftIconContainer) {
        leftIconContainer.addEventListener("click", function (e) {
          window.location.href = "./profile-activity.jsp";
        });
      }

      var itemContainer = document.getElementById("itemContainer");
      if (itemContainer) {
        itemContainer.addEventListener("click", function (e) {
          window.location.href = "./change-password.jsp";
        });
      }
      var itemContainer3 = document.getElementById("itemContainer3");
      if (itemContainer3) {
        itemContainer3.addEventListener("click", function (e) {
          window.location.href = "./continue-with-email.jsp";
        });
      }
      
      var habitCardContainer = document.getElementById("habitCardContainer");
      if (habitCardContainer) {
        habitCardContainer.addEventListener("click", function () {
          window.location.href = "https://www.habitimo.net/home";
        });
      }
      </script>
  </body>
</html>
