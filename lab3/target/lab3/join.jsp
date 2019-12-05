
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>For new users</title>
</head>
<body>

<form action="join" method="POST">
    <h1><p align="center">Welcome to social network!</p></h1>
    <br/>
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
    <i>Confirm Password</i>
    <br/>
    <input type="text" name="confirmPassword" required />
    <br>
    <input type="submit" name="submit" value="Sign up"/>
    </p>
</form>

<form action="login" method="GET">
    <p align="center">
    <input type="submit" name="loginPage" value="Already registered">
    </p>
</form>

</body>
</html>
