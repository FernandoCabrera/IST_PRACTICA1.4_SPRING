<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Práctica 1.4 Spring</title>

</head>
<body>
<h1>Rellene el formulario</h1>
<form action="http://localhost:8080/Practica1.4/Servlet2" method="post">
Nombre:<br> <input type="text" name="Nombre" required><br>
Apellidos:<br> <input type="text" name="Apellidos" required><br>
Email:<br> <input type="email" name="Email" required><br>
<input type="submit" value="Registrarse" >
</form>

</body>
</html>