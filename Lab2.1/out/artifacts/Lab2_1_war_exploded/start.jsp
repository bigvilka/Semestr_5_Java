<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Form</title>
</head>
<body>
<form action="start" method="POST">
<p align="center">
    Sum of numbers: ${number1} and ${number2}
    <br><br>
    <input name="answer" />
    <br><br>
    <input type="submit" value="Submit" />
    <br><br>
    <%= new java.util.Date() %>
    <input type="hidden" name="hash" value=${hash} />
</p>
</form>
</body>
</html>
