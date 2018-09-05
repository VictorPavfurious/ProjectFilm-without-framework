<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Description</title>
    <link href="/css/description.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<c:if test="${username == null}">
    <%response.sendRedirect("/servlet/login");%>
</c:if>

<h1 class="d${filmById.id}"> <c:out value="${filmById.description}" /> </h1>
<p class="image${filmById.id}"> </p>
</body>
</html>
