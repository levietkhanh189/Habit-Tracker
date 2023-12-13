<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="initial-scale=1, width=device-width" />
  <link rel="stylesheet" href="styles/global.css" />
  <link rel="stylesheet" href="styles/create-your-account.css" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700;900&display=swap" />
</head>
<body>
<div class="create-your-account" data-animate-on-scroll>
  <section class="header3">
    <div class="status-bar3"></div>
    <div class="header-type-12">
      <button class="left-icon2" id="leftIcon">
        <img class="iconsarrow-left-22" alt="" src="./public/iconsarrow--left-2.svg" />
      </button>
      <div class="tittle">
        <b class="title8">Create your account</b>
      </div>
    </div>
  </section>
  <form action="createaccount" class="content5" method="post">
    <div class="e-mail2">
      <b class="label8">E-mail</b>
      <div class="inputtext4">
        <input class="search4" name="username" id="username" placeholder="Enter your email" type="email" />
      </div>
    </div>
    <div class="e-mail2">
      <b class="label8">Password</b>
      <div class="inputtext4">
        <input class="search4" name="password" id="password" placeholder="Enter your password" type="password" />
      </div>
    </div>
    <div class="e-mail2">
      <b class="label8">Confirm Password</b>
      <div class="inputtext4">
        <input class="search4" name="passwordagain" placeholder="Enter your password again" type="password" />
      </div>
    </div>
    <div class="button2">
      <button class="next2" id="createaccount" type="submit">
        <div class="create-account">Create account</div>
      </button>
    </div>
  </form>
</div>
<script>
  var leftIcon = document.getElementById("leftIcon");
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