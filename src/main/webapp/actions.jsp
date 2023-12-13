<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="initial-scale=1, width=device-width" />
  <link rel="stylesheet" href="styles/global.css" />
  <link rel="stylesheet" href="styles/actions.css" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700;900&display=swap" />
</head>
<body>
<div class="actions">

  <div class="form" >
    <form action="createhabit" method="post">
      <button class="a"type="submit" name="info" value="open">
        <div class="bad-habit">
          <div class="text">
            <div class="title1">Quit Bad Habit</div>
            <div class="description1">Never too late...</div>
          </div>
          <img
                  class="iconsshield-fail"
                  alt=""
                  src="./public/iconsshield-fail.svg"
          />
        </div>
        <div class="bad-habit">
          <div class="text">
            <div class="title1">New Good Habit</div>
            <div class="description1">For a better life</div>
          </div>
          <img
                  class="iconsshield-fail"
                  alt=""
                  src="./public/iconsshield-done.svg"
          />
        </div>
      </button>
    </form>

    <div class="mood">
      <div class="text2">
        <div class="title3">Add Mood</div>
        <div class="description1">How’re you feeling?</div>
      </div>
      <div class="moods">
        <div class="icon-button">
          <div class="emoji">😡</div>
        </div>
        <div class="icon-button">
          <div class="emoji">☹️</div>
        </div>
        <div class="icon-button">
          <div class="emoji">😐</div>
        </div>
        <div class="icon-button">
          <div class="emoji">🙂</div>
        </div>
        <div class="icon-button">
          <div class="emoji">😍</div>
        </div>
      </div>
    </div>
  </div>
  <img
          class="add-button-icon"
          alt=""
          src="./public/add-button.svg"
          id="popupaddButton"
  />
</div>

<script>
  var popupaddButton = document.getElementById("popupaddButton");
  if (popupaddButton) {
    popupaddButton.addEventListener("click", function (e) {
      var popup = e.currentTarget.parentNode;
      function isOverlay(node) {
        return !!(
                node &&
                node.classList &&
                node.classList.contains("popup-overlay")
        );
      }
      while (popup && !isOverlay(popup)) {
        popup = popup.parentNode;
      }
      if (isOverlay(popup)) {
        popup.style.display = "none";
      }
    });
  }
</script>
</body>
</html>