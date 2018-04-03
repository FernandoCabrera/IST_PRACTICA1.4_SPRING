<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log in</title>
</head>
<body>

<h1>Registro</h1>
<form action="Servlet1" method="post">
User:<br> <input type="text" name="user" required><br>
Password:<br> <input type="password" name="pass" required><br>
<input type="submit" value="Inicio" >

</form>

</body>
</html>
