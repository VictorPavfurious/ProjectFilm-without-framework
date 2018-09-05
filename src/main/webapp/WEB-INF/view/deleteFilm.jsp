<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${username == null}">
    <%response.sendRedirect("/servlet/login");%>
</c:if>

<form method="POST" action="<c:url value="/servlet/deleteFilm"/> ">

    <p> Insert Id: <input type="text" name="id"> </p>

    <p> <button>Delete film</button> </p>

    <form action="<c:url value="/servlet/getAllFilms"/> ">
        <p> <button type="submit"> Show all films </button> </p>
    </form>

</form>
</body>
</html>
