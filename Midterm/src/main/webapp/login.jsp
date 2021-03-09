<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html  xmlns="http://www.w3.org/1999/xhtml"
    xmlns:th="http://www.thymeleaf.org"
    xmlns:sec="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	${SPRING_SECURITY_LAST_EXCEPTION.message}
	
	<form action="/login" method="POST">
		<table>
			<tr>
				<td>User:</td>
				<td><Input type="text" name="username" value=''></td>
			<tr>
			<tr>
				<td>Password:</td>
				<td><Input type="password" name="password" ></td>
			<tr>
			<tr>
				<td><Input type="submit" name="submit" value="submit"></td>
			<tr>
		</table>
	</form>
</body>
</html>