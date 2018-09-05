<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AllFilms</title>
    <link href="/css/allfilms.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<c:if test="${username == null}">
    <%response.sendRedirect("/servlet/login");%>
</c:if>
<div class="borderfilm">
<c:forEach var="film" items="${films}" >
     <a href="description?f_id=${film.id}"> <c:out value="${film.title}" /> </a> <br>
    <p></p>
</c:forEach>
</div>

<div class="buttonsborder">
    <form action="<c:url value="/servlet/home" />">
        <button class="bhome"> Home </button>
    </form>

<form action="<c:url value="/servlet/insertFilm" />" method="GET">
  <button class="insert"> Insert Film </button>
</form>

<form action="<c:url value="/servlet/deleteFilm" />" method="GET">
  <button class="bdelete"> Delete Film </button>
</form>

    <form method="POST" action="<c:url value="/servlet/logout" />">
        <button type="submit" class="logout"> Log Out </button>
    </form>
</div>
</body>
</html>
