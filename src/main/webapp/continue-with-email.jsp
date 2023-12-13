<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="initial-scale=1, width=device-width" />
  <link rel="stylesheet" href="styles/global.css" />
  <link rel="stylesheet" href="styles/continue-with-email.css" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700;900&display=swap" />
</head>
<body>
<div class="continue-with-email" data-animate-on-scroll>
  <section class="header17">
    <div class="status-bar10"></div>
    <div class="header-type-19">
      <button class="left-icon9" id="back">
        <img class="iconsarrow-left-28" alt="" src="./public/iconsarrow--left-2.svg" />
      </button>
      <div class="title-wrapper2">
        <b class="title33">Continue with Email</b>
      </div>
    </div>
  </section>
  <form action="login" class="content12" method="post">
    <div class="e-mail3">
      <b class="label18">E-mail</b>
      <div class="inputtext12">
        <input class="search12" name="username" id="username" placeholder="Enter your email" type="email" />
      </div>
    </div>
    <div class="e-mail3">
      <b class="label18">Password</b>
      <div class="inputtext12">
        <input class="search12" name="password" id="password" placeholder="Enter your password" type="password" />
      </div>
    </div>
    <a class="forgot-password2" id="forgotpassword" href="./forgot-password.jsp">I forgot my password</a>
    <div class="button6">
      <a class="create-account1" id="createaccount" href="./create-your-account.jsp">Don’t have account? Let’s create!</a>
      <button class="next6" id="loginBtn" type="submit">
        <div class="login">Login</div>
      </button>
    </div>
  </form>
</div>
<script>
  var leftIcon = document.getElementById("back");
  if (leftIcon) {
    leftIcon.addEventListener("click", function(e) {
      window.location.href = "./onboarding1.jsp";
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