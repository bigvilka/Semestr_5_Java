
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>

<form method="POST">
    <h2><p align="center">Enter your login and password to sign in</p></h2>
    <br>
    <p align="center">
    Server time:
    <br>
    <%= new java.util.Date() %>
    <br>
    <br>
    <i>Login</i>
    <br/>
    <input type="text" name="login" required />
    <br/>
    <i>Password</i>
    <br/>
    <input type="text" name="password" required />
    <br/>
    <input type="submit" name="submit" value="Sign in"/>
    <br>
    </p>
</form>







</body>
</html>
