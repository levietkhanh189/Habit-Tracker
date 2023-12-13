<!DOCTYPE html><%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="initial-scale=1, width=device-width" />
  <link rel="stylesheet" href="styles/global.css" />
  <link rel="stylesheet" href="styles/information-01.css" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700;900&display=swap" />
</head>
<body>
<div class="information-01" data-animate-on-scroll>
  <div class="header16">
    <div class="status-bar9"></div>
    <div class="header-type-18">
      <button class="left-icon8" id="backbtn">
        <img class="iconsarrow-left-27" alt="" src="./public/iconsarrow--left-2.svg" />
        <div class="dot25"></div>
      </button>
      <div class="title-wrapper1">
        <b class="title32">Information</b>
      </div>
    </div>
  </div>
  <form action="userinfo" method="post">
    <div class="input">
      <b class="label15">name</b>
      <div class="inputtext9">
        <input class="search9" name="name" placeholder="Enter your name" type="text" />
      </div>
    </div>
    <div class="input">
      <b class="label15">surname</b>
      <div class="inputtext9">
        <input class="search9" name="surname" placeholder="Enter your surname" type="text" />
      </div>
    </div>
    <div class="input">
      <b class="label15">Birthdate</b>
      <div class="inputtext9">
        <input class="search9" name="birthday" placeholder="mm/dd/yyyy" type="date" />
      </div>
    </div>
    <div class="buton">
      <button class="button5" id="done" type="submit"name="info" value="info">
        <div class="next5">Next</div>
      </button>
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