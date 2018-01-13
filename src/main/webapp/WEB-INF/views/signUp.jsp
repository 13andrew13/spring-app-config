<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 13.01.18
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/resources/css/signin.css" rel="stylesheet">
</head>

<body>

<div class="container">

    <spring:form class="form-signin" action="/signUp" method="post" modelAttribute="user">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">First name</label>
        <spring:input type="text" id="inputFirstName" class="form-control" placeholder="First name" required="true" autofocus="true" path="firstName"/>
        <label for="inputEmail" class="sr-only">Email address</label>
        <spring:input type="text" id="inputLastName" class="form-control" placeholder="Last name" required="true" autofocus="true" path="lastName"/>
        <label for="inputEmail" class="sr-only">Email address</label>
        <spring:input type="email" id="inputEmail" class="form-control" placeholder="Email address" required="true" autofocus="true" path="email"/>
        <label for="inputPassword" class="sr-only">Password</label>
        <spring:input type="password" id="inputPassword" class="form-control" placeholder="Password" required="true" path="password"/>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </spring:form>

</div> <!-- /container -->
</body>
</html>