<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp page</title>
    <link href="/css/signup.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="form">

<h1> Please enter information in this the form! </h1>

<form method="POST" action="<c:url value="/servlet/signup" />">
    <label for="name"> Name:  </label>
    <div class="string name"> <input id="name" type="text" name="u_name" placeholder="Your name.."> <br> </div>

    <label for="surname"> Surname: </label>
    <div class="string surname"> <input id="surname" type="text" name="u_surname" placeholder="Your surname.."> <br> </div>

    <label for="email"> Email:   </label>
    <div class="string email"> <input id="email" type="email" name="u_email" placeholder="Your email.."> <br> </div>

    <label for="pass"> Password:</label>
    <div class="string pass"> <input id="pass" type="text" name="u_password">  </div>

    <p> <button type="submit" class="signup">Sign UP!</button> </p>
</form>
</div>
</body>
</html>
