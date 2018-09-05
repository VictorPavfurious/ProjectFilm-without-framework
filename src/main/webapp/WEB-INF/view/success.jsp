<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<h1> Success was doing a job! </h1>
<h2> Hello ! Please, choose once a link </h2>
<p> <a href="<c:url value="/servlet/getAllFilms"/>"> Show all films </a> </p>
<p> <a href="<c:url value="/servlet/insertFilm"/>"> Add new film </a> </p>
<p> <a href="<c:url value="/servlet/deleteFilm"/>"> Delete film from id* </a> </p>
</body>
</html>
