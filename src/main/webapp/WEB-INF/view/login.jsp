<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link href="/css/login.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<div id="loginborder">

<h1> Login please </h1>

<form method="POST" action="<c:url value="/servlet/login" />">
<div class="login">
    <div class="field"> <label for="email"> Email: </label> <input id="email" type="text" name="username" size="30"><br> </div>
    <div class="field"> <label for="pass"> Password: </label> <input id="pass" type="password" name="password" size="30"> </div>
</div>
    <br>
    <br>
    <p><button type="submit" class="button blogin"> Login </button> </p>

</form>

    <form action="<c:url value="/servlet/signup"/>">
        <p>  <button type="submit" class="button bsignup"> Sign Up </button> </p>
    </form>

</div>
</body>
</html>
