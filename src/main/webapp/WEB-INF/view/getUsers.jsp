<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> getUsers!</h1>

<c:forEach var="c" items="${users}" >
    <h1> <c:out value="${c.id}" />   </h1>
    <h1> <c:out value="${c.name}" />  </h1>
    <h1> <c:out value="${c.surname}"/> </h1>

</c:forEach>
</body>
</html>
