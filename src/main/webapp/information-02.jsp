<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="initial-scale=1, width=device-width" />
  <link rel="stylesheet" href="styles/global.css" />
  <link rel="stylesheet" href="styles/information-02.css" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700;900&display=swap" />
</head>
<body>
<div class="information-02" data-animate-on-scroll>
  <div class="header15">
    <div class="status-bar8"></div>
    <div class="header-type-17">
      <button class="left-icon7" id="back">
        <img class="iconsarrow-left-26" alt="" src="./public/iconsarrow--left-2.svg" />
      </button>
      <div class="frame-div">
        <b class="title30">Information</b>
      </div>
    </div>
  </div>
  <form action="userinfo" method="post">
    <div class="title31">Choose your gender</div>
    <div class="options">
      <button class="icon-button13" id="male" value="male" type="male"name="info">
        <b class="b2">🤷🏻‍</b>
        <div class="male">Male</div>
      </button>
      <button class="icon-button13" id="female" value="female" type="submit"name="info">
        <b class="b2">🙋🏻‍♀️</b>
        <div class="male">Female</div>
      </button>
    </div>
    <div class="button4"></div>
  </form>
</div>
<script>
  var leftIcon = document.getElementById("back");
  if (leftIcon) {
    leftIcon.addEventListener("click", function(e) {
      window.location.href = "./information-01.html";
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