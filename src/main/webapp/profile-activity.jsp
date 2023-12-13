<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.Activity" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="initial-scale=1, width=device-width" />

    <link rel="stylesheet" href="styles/global.css" />
    <link rel="stylesheet" href="styles/profile-activity.css" />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700;900&display=swap"
    />
  </head>
  <body>
    <div class="profile-activity" data-animate-on-scroll>
      <section class="content11" id="Section">
        <div class="header14">
          <div class="status-bar9"></div>
          <div class="header-type-17">
            <div class="title-wrapper1">
              <h2 class="title54" id="Tittle">Your Profile</h2>
            </div>
            <button class="right-icon5" id="Setting">
              <img
                class="iconssetting2"
                alt=""
                src="./public/iconssetting.svg"
              />
            </button>
          </div>
          <div class="profile2">
            <img class="base-icon2" alt="" src="./public/base1@2x.png" />

            <div class="home-container">
              <div class="home9">Mert Kahveci</div>
              <div class="status-badge6">
                <img class="iconsmedal6" alt="" src="./public/iconsmedal.svg" />

                <div class="badge-text6">1452 Points</div>
              </div>
            </div>
          </div>
          <div class="segment-control2">
            <div class="st-tab2">
              <label class="text43" htmlfor="Activity">Activity</label>
            </div>
            <button class="nd-tab2" id="friendTab">
              <div class="text44">Friends</div>
              <div class="text-wrapper5">
                <b class="text45">1</b>
              </div>
            </button>
            <button class="nd-tab2" id="achievementTab">
              <div class="text44">Achievements</div>
              <div class="text-wrapper5">
                <b class="text45">1</b>
              </div>
            </button>
          </div>
        </div>
        <div class="body1">
          <div class="bar1">
            <div class="title55">Showing last month activity</div>
          </div>
          <div class="content12">
            <%
              List<Activity> activities = (List<Activity>) request.getSession().getAttribute("activities");
              if (activities != null) {
                for (Activity activity : activities) {
            %>
            <div class="activity-card1">
              <div class="text48">
                <div class="title56"><%= activity.getContent() %></div>
                <div class="description27"><%= activity.getDate().toString() %></div>
              </div>
              <div class="add-button9">
                <img class="iconsarrow-up-31" alt="" src="./public/iconsarrow--up-3.svg" />
                <div class="dot10"></div>
              </div>
            </div>
            <%
                }
              }
            %>


          <%--            <div class="activity-card1">--%>
<%--              <div class="text48">--%>
<%--                <div class="title56">112 points earned!</div>--%>
<%--                <div class="description27">Today, 12:34 PM</div>--%>
<%--              </div>--%>
<%--              <div class="add-button9">--%>
<%--                <img--%>
<%--                  class="iconsarrow-up-31"--%>
<%--                  alt=""--%>
<%--                  src="./public/iconsarrow--up-3.svg"--%>
<%--                />--%>

<%--                <div class="dot10"></div>--%>
<%--              </div>--%>
<%--            </div>--%>
<%--            <div class="activity-card1">--%>
<%--              <div class="text48">--%>
<%--                <div class="title56">112 points earned!</div>--%>
<%--                <div class="description27">Today, 12:34 PM</div>--%>
<%--              </div>--%>
<%--              <div class="add-button9">--%>
<%--                <img--%>
<%--                  class="iconsarrow-up-31"--%>
<%--                  alt=""--%>
<%--                  src="./public/iconsarrow--up-3.svg"--%>
<%--                />--%>

<%--                <div class="dot10"></div>--%>
<%--              </div>--%>
<%--            </div>--%>
<%--            <div class="activity-card1">--%>
<%--              <div class="text48">--%>
<%--                <div class="title56">112 points earned!</div>--%>
<%--                <div class="description27">Today, 12:34 PM</div>--%>
<%--              </div>--%>
<%--              <div class="add-button9">--%>
<%--                <img--%>
<%--                  class="iconsarrow-up-31"--%>
<%--                  alt=""--%>
<%--                  src="./public/iconsarrow--up-3.svg"--%>
<%--                />--%>

<%--                <div class="dot10"></div>--%>
<%--              </div>--%>
<%--            </div>--%>
<%--            <div class="activity-card1">--%>
<%--              <div class="text48">--%>
<%--                <div class="title56">112 points earned!</div>--%>
<%--                <div class="description27">Today, 12:34 PM</div>--%>
<%--              </div>--%>
<%--              <div class="add-button9">--%>
<%--                <img--%>
<%--                  class="iconsarrow-up-31"--%>
<%--                  alt=""--%>
<%--                  src="./public/iconsarrow--up-3.svg"--%>
<%--                />--%>

<%--                <div class="dot10"></div>--%>
<%--              </div>--%>
<%--            </div>--%>
<%--            <div class="activity-card1">--%>
<%--              <div class="text48">--%>
<%--                <div class="title56">112 points earned!</div>--%>
<%--                <div class="description27">Today, 12:34 PM</div>--%>
<%--              </div>--%>
<%--              <div class="add-button9">--%>
<%--                <img--%>
<%--                  class="iconsarrow-up-31"--%>
<%--                  alt=""--%>
<%--                  src="./public/iconsarrow--up-3.svg"--%>
<%--                />--%>

<%--                <div class="dot10"></div>--%>
<%--              </div>--%>
<%--            </div>--%>
<%--            <div class="activity-card1">--%>
<%--              <div class="text48">--%>
<%--                <div class="title56">112 points earned!</div>--%>
<%--                <div class="description27">Today, 12:34 PM</div>--%>
<%--              </div>--%>
<%--              <div class="add-button9">--%>
<%--                <img--%>
<%--                  class="iconsarrow-up-31"--%>
<%--                  alt=""--%>
<%--                  src="./public/iconsarrow--up-3.svg"--%>
<%--                />--%>

<%--                <div class="dot10"></div>--%>
<%--              </div>--%>
<%--            </div>--%>
<%--            <div class="activity-card1">--%>
<%--              <div class="text48">--%>
<%--                <div class="title56">112 points earned!</div>--%>
<%--                <div class="description27">Today, 12:34 PM</div>--%>
<%--              </div>--%>
<%--              <div class="add-button9">--%>
<%--                <img--%>
<%--                  class="iconsarrow-up-31"--%>
<%--                  alt=""--%>
<%--                  src="./public/iconsarrow--up-3.svg"--%>
<%--                />--%>

<%--                <div class="dot10"></div>--%>
<%--              </div>--%>
<%--            </div>--%>
          </div>
        </div>
      </section>
    </div>
    <%@ include file="app-bar.jsp" %>

    <script>
      var rightIcon = document.getElementById("Setting");
      if (rightIcon) {
        rightIcon.addEventListener("click", function (e) {
          window.location.href = "./settings.jsp";
        });
      }
      
      var ndTab = document.getElementById("friendTab");
      if (ndTab) {
        ndTab.addEventListener("click", function (e) {
          window.location.href = "./profile-friends.jsp";
        });
      }
      
      var rdTab = document.getElementById("achievementTab");
      if (rdTab) {
        rdTab.addEventListener("click", function (e) {
          window.location.href = "./profile-achievements.jsp";
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
        },
        {
          threshold: 0.15,
        }
      );
      
      for (let i = 0; i < scrollAnimElements.length; i++) {
        observer.observe(scrollAnimElements[i]);
      }
      </script>
  </body>
</html>
