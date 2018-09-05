<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
    <link href="/css/home.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<c:if test="${username == null}">
    <%response.sendRedirect("/servlet/login");%>
</c:if>
<div class="areabutton">

    <form action="<c:url value="/servlet/getAllFilms"/>">
    <button class="show"> Show all Films </button>
    </form>

    <form action="<c:url value="/servlet/insertFilm"/>">
    <button class="add"> Add new film </button>
    </form>

    <form action="<c:url value="/servlet/deleteFilm"/>">
    <button class="delete"> Delete film from id* </button>
    </form>

    <form method="POST" action="<c:url value="/servlet/logout" />">
     <button type="submit" class="logout"> Log Out </button>
    </form>
</div>

<div class="main"> <h1> Welcome on the site ${username}! </h1> </div>

</body>
</html>
