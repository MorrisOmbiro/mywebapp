<%--
  Created by IntelliJ IDEA.
  User: morriskalb
  Date: 8/17/2019
  Time: 7:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <h1 style="padding: auto;font-family: 'Bell MT';color: darksalmon;">Welcome to my site, please login</h1>

    <form action = "/mywebapp/login" method = "post" >
        login-name: <input type="text" name="loginname" width="30" />
        password: <input type="password" name="password" width="10" />
        <input type="submit" value="login"/>
    </form>

    <p style="color: red;">${errorMessage}</p>

</body>
</html>
