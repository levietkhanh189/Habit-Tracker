<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="initial-scale=1, width=device-width" />
  <link rel="stylesheet" href="styles/global.css" />
  <link rel="stylesheet" href="styles/index.css" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700;900&display=swap" />
</head>
<body>
<div class="onboarding-1" data-animate-on-scroll>
  <section class="frame">
    <img class="frame-icon" alt="" src="./public/frame.svg" />
    <div class="frame1">
      <div class="status-bar"></div>
      <div class="frame2">
        <div class="frame3">
          <div class="illustration">
            <div class="frame4">
              <div class="chat-popup">
                <div class="icon">
                  <img class="path-icon" alt="" src="./public/path.svg" />
                </div>
                <img class="vector-icon" alt="" src="./public/vector.svg" />
              </div>
              <img class="frame-icon1" alt="" src="./public/frame1@2x.png" />
            </div>
            <div class="frame5">
              <div class="frame6">
                <img class="avatar-01-icon" alt="" src="./public/avatar-01@2x.png" />
                <div class="chat-popup1">
                  <div class="icon">
                    <img class="path-icon" alt="" src="./public/path.svg" />
                  </div>
                  <img class="vector-icon" alt="" src="./public/vector.svg" />
                </div>
              </div>
              <div class="frame7">
                <img class="frame-icon2" alt="" src="./public/frame2@2x.png" />
                <div class="chat-popup2">
                  <div class="icon">
                    <img class="path-icon" alt="" src="./public/path.svg" />
                  </div>
                  <img class="vector-icon" alt="" src="./public/vector.svg" />
                </div>
              </div>
            </div>
          </div>
        </div>
        <img class="frame-icon3" alt="" src="./public/frame3.svg" />
      </div>
      <div class="content">
        <div class="top">
          <div class="titles">
            <h1 class="title">
              <p class="create">Create</p>
              <p class="create">Good Habits</p>
            </h1>
            <div class="description"> Change your life by slowly adding new healty habits and sticking to them. </div>
          </div>
        </div>
        <form action="changepage" class="buttons" method="post">
          <button class="e-mail" id="continueEmail" type="submit"name="page" value="/continue-with-email.jsp">
            <img class="iconsnotification" alt="" src="./public/iconsnotification.svg" />
            <img class="iconslogin" alt="" src="./public/iconslogin.svg" />
            <div class="label">Continue with E-mail</div>
          </button>
          <div class="social-login">
            <div class="apple">
              <img class="iconsnotification1" alt="" src="./public/iconsnotification1.svg" />
              <img class="iconsapple" alt="" src="./public/iconsapple.svg" />
              <div class="label">Apple</div>
            </div>
            <div class="apple">
              <img class="iconsnotification1" alt="" src="./public/iconsnotification1.svg" />
              <img class="iconsapple" alt="" src="./public/iconsgoogle.svg" />
              <div class="label">Google</div>
            </div>
            <div class="apple">
              <img class="iconsnotification1" alt="" src="./public/iconsnotification1.svg" />
              <img class="iconsapple" alt="" src="./public/facebooklogo2019-1.svg" />
              <div class="label">Facebook</div>
            </div>
          </div>
          <div class="terms-and-conditions"> By continuing you agree Terms of Services & Privacy Policy </div>
        </form>
      </div>
    </div>
  </section>
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