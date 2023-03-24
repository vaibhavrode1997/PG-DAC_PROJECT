<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login page</title>
</head>
<body>
<form action="validate" method="get">
	<p>email :<input type="text" name="email" id="email" /></p>
	<p>Password :<input type="password" name="password" id="password" /></p>
	<button type="submit">Login</button>
	<a href="register">register</a>
	</form>
</body>
</html>