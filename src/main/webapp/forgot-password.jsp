<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="initial-scale=1, width=device-width" />
  <link rel="stylesheet" href="styles/global.css" />
  <link rel="stylesheet" href="styles/forgot-password.css" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700;900&display=swap" />
</head>
<body>
<div class="forgot-password" data-animate-on-scroll>
  <div class="header2">
    <div class="status-bar2"></div>
    <div class="header-type-11">
      <button class="left-icon1" id="back">
        <img class="iconsarrow-left-21" alt="" src="./public/iconsarrow--left-2.svg" />
        <div class="dot5"></div>
      </button>
      <div class="title-container">
        <b class="title7">Forgot password</b>
      </div>
    </div>
  </div>
  <form action="forgotpassword" method="post" class="content4">
    <div class="e-mail1">
      <b class="label7">E-mail</b>
      <div class="inputtext3">
        <input class="search3" name="email" placeholder="Enter your password" type="email" />
      </div>
    </div>
    <div class="button1">
      <div class="forgot-password1">
        <p class="note-">-- Note --</p>
        <p class="note-"> We will send you a new password via email ! Please check it! </p>
        <p class="note-"> You can change your password in Security in Setting </p>
        <p class="note-">Thank you for your cooperation! Wish all!</p>
      </div>
      <button class="next1" id="resetpassword" type="submit">
        <div class="reset-password">Reset password</div>
      </button>
    </div>
  </form>
</div>
<script>
  var leftIcon = document.getElementById("back");
  if (leftIcon) {
    leftIcon.addEventListener("click", function(e) {
      window.location.href = "./continue-with-email.jsp";
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