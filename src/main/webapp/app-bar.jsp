<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="initial-scale=1, width=device-width" />
  <link rel="stylesheet" href="styles/global.css" />
  <link rel="stylesheet" href="styles/app-bar.css" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700;900&display=swap" />
</head>
<body>
<div class="app-bar" id="app-bar">
  <form action="appbar" method="post" class="buttons1">
    <div class="left-side">
      <button class="st-button" type="submit" name="page" value="/home.jsp">
        <img class="iconshome" alt="" src="./public/iconshome.svg" />
      </button>
      <button class="st-button" type="submit" name="page" value="/explore.jsp">
        <img class="iconshome" alt="" src="./public/iconsdiscovery.svg" />
      </button>
    </div>
    <div class="left-side">
      <button class="st-button" type="submit" name="page" value="/activity.jsp">
        <img class="iconsmedal" alt="" src="./public/iconsmedal.svg" />
      </button>
      <button class="st-button" type="submit" name="page" value="/profile-activity.jsp">
        <img class="iconshome" alt="" src="./public/iconsprofile.svg" />
      </button>
    </div>
  </form>
  <button class="plus-button" id="plusButton">
    <img class="shape-icon" alt="" src="./public/shape.svg" />
    <img class="shape-icon1" alt="" src="./public/shape1.svg" />
  </button>
</div>

<div id="actionsPopup" class="popup-overlay" style="display: none">

  <%@ include file="actions.jsp" %>
</div>

<script>
  document.addEventListener("DOMContentLoaded", function() {
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
    var plusButton = document.getElementById("plusButton");
    if (plusButton) {
      console.log("JavaScript is running!");
      plusButton.addEventListener("click", function () {
        console.log("JavaScript is running!2");

        var popup = document.getElementById("actionsPopup");
        if (!popup) return;
        var popupStyle = popup.style;
        if (popupStyle) {
          popupStyle.display = "flex";
          popupStyle.zIndex = 100;
          popupStyle.backgroundColor = "rgba(113, 113, 113, 0.3)";
          popupStyle.alignItems = "center";
          popupStyle.justifyContent = "center";
        }
        popup.setAttribute("closable", "");

        var onClick =
                popup.onClick ||
                function (e) {
                  if (e.target === popup && popup.hasAttribute("closable")) {
                    popupStyle.display = "none";
                  }
                };
        popup.addEventListener("click", onClick);
      });
    }
  });
</script>
</body>
</html>