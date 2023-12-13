<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="initial-scale=1, width=device-width" />
  <link rel="stylesheet" href="styles/global.css" />
  <link rel="stylesheet" href="styles/change-password.css" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700;900&display=swap" />
</head>
<body>
<div class="change-password" data-animate-on-scroll>
  <div class="header1">
    <div class="status-bar1"></div>
    <div class="header-type-1">
      <button class="left-icon" id="back">
        <img class="iconsarrow-left-2" alt="" src="./public/iconsarrow--left-2.svg" />
        <div class="dot4"></div>
      </button>
      <div class="title-wrapper">
        <b class="title6">Change password</b>
      </div>
    </div>
  </div>
  <form action="changepassword" method="post" class="content3">
    <div class="old-password">
      <b class="label4">Old Password</b>
      <div class="inputtext">
        <input class="search" name="oldpassword" placeholder="Enter your old password" type="password" />
      </div>
    </div>
    <div class="old-password">
      <b class="label4">New Password</b>
      <div class="inputtext">
        <input class="search" name="newpassword" placeholder="Enter your new password" type="password" />
      </div>
    </div>
    <div class="old-password">
      <b class="label4">Confirm New Password</b>
      <div class="inputtext">
        <input class="search" name="newpassword2" placeholder="Enter your new password" type="password" />
      </div>
    </div>
    <div class="button">
      <button class="next" id="changepass" type="submit">
        <div class="change-password1">Change password</div>
      </button>
    </div>
  </form>
</div>
<script>
  var leftIcon = document.getElementById("back");
  if (leftIcon) {
    leftIcon.addEventListener("click", function (e) {
      window.location.href = "./settings.jsp";
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