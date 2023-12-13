<%@ page import="java.util.List" %>
<%@ page import="model.entity.Habit" %>
<%@ page import="model.entity.Challenge" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="initial-scale=1, width=device-width" />

    <link rel="stylesheet" href="styles/global.css" />
    <link rel="stylesheet" href="styles/explore.css" />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700;900&display=swap"
    />
  </head>
  <body>
    <div class="explore">
      <div class="header3">
        <div class="status-bar3"></div>
        <div class="header-type-11">
          <div class="tittle1">
            <b class="title7">Explore</b>
          </div>
          <div class="right-icon">
            <img class="iconssearch" alt="" src="./public/iconssearch.svg" />

            <div class="dot2"></div>
          </div>
        </div>
      </div>
      <div class="content2">
        <div class="suggested">
          <div class="header4">
            <div class="home1">Suggested for You</div>
            <b class="home2">View All</b>
          </div>
          <div class="content3">
            <div style = "overflow-x : auto; max-height:270px;white-space: nowrap;display: flex;">
              <form action="createhabit" method="post">
                <div>
                  <%
                    List<Habit> habits = (List<Habit>) request.getSession().getAttribute("habits");
                    if (habits != null && !habits.isEmpty()) {
                      for (Habit habit : habits) {
                  %>
                  <button class="habit-button" type="submit" name="info" value="<%=habit.getIdToString()%>">
                    <b class="icon4"><%= habit.getIcon() %> </b>
                    <div class="run"><%= habit.getHabitName() %> </div>
                  </button><%
                  }
                } else {
                %> <p>No habits available.</p><%
                  }
                %>
                </div>

              </form>
            </div>
<%--            <div class="habit-button">--%>
<%--              <b class="icon4">🏃🏻‍♀️</b>--%>
<%--              <div class="run">Run</div>--%>
<%--            </div>--%>
<%--            <div class="habit-button">--%>
<%--              <b class="icon4">🏃🏻‍♀️</b>--%>
<%--              <div class="run">Run</div>--%>
<%--            </div>--%>
<%--            <div class="habit-button">--%>
<%--              <b class="icon4">🏃🏻‍♀️</b>--%>
<%--              <div class="run">Run</div>--%>
<%--            </div>--%>
<%--            <div class="habit-button">--%>
<%--              <b class="icon4">🏃🏻‍♀️</b>--%>
<%--              <div class="run">Run</div>--%>
<%--            </div>--%>
          </div>
        </div>
        <div class="suggested">
          <div class="header4">
            <div class="home1">Challenges</div>
            <b class="home2">View All</b>
          </div>
          <div class="content4">
            <div style = "overflow-x : auto; max-height:270px;white-space: nowrap;display: flex;">
              <form action="detailchallenge" method="post">
                <div>
                  <%
                    List<Challenge> challenges = (List<Challenge>) request.getSession().getAttribute("challenges");
                    if (challenges != null && !challenges.isEmpty()) {
                      for (Challenge challenge : challenges) {
                  %>
                  <button class="challenge-card10" type="submit" name="info" value="<%=challenge.getId().toString()%>">
                    <img class="iconstime-circle10" alt="" src="./public/iconstime-circle.svg" />
                    <div class="titles11">
                      <div class="funny30"><%= challenge.getName() %></div>
                      <div class="funny31"><%= challenge.getEndDate() %></div>
                    </div>
                    <div class="progress-bar10">
                      <div class="progress-bar-child16"></div>
                    </div>
                    <div class="friends10">
                      <div class="member10">
                        <img class="mask-icon2" alt="" src="./public/mask@2x.png" />
                        <img class="mask-icon3" alt="" src="./public/mask1@2x.png" />
                      </div>
                      <div class="funny32">2 friends joined</div>
                    </div>
                  </button>
                  <%
                    }
                  } else {
                  %>
                  <p>No challenges available.</p>
                  <%
                    }
                  %>
                </div>

              </form>
            </div>
<%--            <div class="challenge-card10">--%>
<%--              <img--%>
<%--                class="iconstime-circle10"--%>
<%--                alt=""--%>
<%--                src="./public/iconstime-circle.svg"--%>
<%--              />--%>

<%--              <div class="titles11">--%>
<%--                <div class="funny30">Best Runners! 🏃🏻‍♂️</div>--%>
<%--                <div class="funny31">5 days 13 hours left</div>--%>
<%--              </div>--%>
<%--              <div class="progress-bar10">--%>
<%--                <div class="progress-bar-child16"></div>--%>
<%--              </div>--%>
<%--              <div class="friends10">--%>
<%--                <div class="member10">--%>
<%--                  <img class="mask-icon2" alt="" src="./public/mask@2x.png" />--%>

<%--                  <img class="mask-icon3" alt="" src="./public/mask1@2x.png" />--%>
<%--                </div>--%>
<%--                <div class="funny32">2 friends joined</div>--%>
<%--              </div>--%>
<%--            </div>--%>

<%--            <div class="challenge-card10">--%>
<%--              <img--%>
<%--                class="iconstime-circle10"--%>
<%--                alt=""--%>
<%--                src="./public/iconstime-circle.svg"--%>
<%--              />--%>

<%--              <div class="titles11">--%>
<%--                <div class="funny30">Best Runners! 🏃🏻‍♂️</div>--%>
<%--                <div class="funny31">5 days 13 hours left</div>--%>
<%--              </div>--%>
<%--              <div class="progress-bar10">--%>
<%--                <div class="progress-bar-child16"></div>--%>
<%--              </div>--%>
<%--              <div class="friends10">--%>
<%--                <div class="member10">--%>
<%--                  <img class="mask-icon2" alt="" src="./public/mask@2x.png" />--%>

<%--                  <img class="mask-icon3" alt="" src="./public/mask1@2x.png" />--%>
<%--                </div>--%>
<%--                <div class="funny32">2 friends joined</div>--%>
<%--              </div>--%>
<%--            </div>--%>
<%--            <div class="challenge-card10">--%>
<%--              <img--%>
<%--                class="iconstime-circle10"--%>
<%--                alt=""--%>
<%--                src="./public/iconstime-circle.svg"--%>
<%--              />--%>

<%--              <div class="titles11">--%>
<%--                <div class="funny30">Best Runners! 🏃🏻‍♂️</div>--%>
<%--                <div class="funny31">5 days 13 hours left</div>--%>
<%--              </div>--%>
<%--              <div class="progress-bar10">--%>
<%--                <div class="progress-bar-child16"></div>--%>
<%--              </div>--%>
<%--              <div class="friends10">--%>
<%--                <div class="member10">--%>
<%--                  <img class="mask-icon2" alt="" src="./public/mask@2x.png" />--%>

<%--                  <img class="mask-icon3" alt="" src="./public/mask1@2x.png" />--%>
<%--                </div>--%>
<%--                <div class="funny32">2 friends joined</div>--%>
<%--              </div>--%>
<%--            </div>--%>
          </div>
        </div>
      </div>
    </div>
    <%@ include file="app-bar.jsp" %>

  </body>
</html>
