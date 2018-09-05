<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add into Database</title>
</head>
<body>

<c:if test="${username == null}">
    <%response.sendRedirect("/servlet/login");%>
</c:if>

<form method="POST" action="<c:url value="/servlet/insertFilm" />">
<p> Title the film: <input type="text" name="title"> </p>
<p> Description the film: <input type="text" name="description"> </p>

<p> <button type="submit"> Add Film </button> </p>
</form>

    <form action="<c:url value="/servlet/getAllFilms"/> ">
        <p> <button type="submit"> Show all films </button> </p>
    </form>
</body>
</html>
