<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style>
.error {
	color: #ff0000;
	font-weight: bold;
}
</style>
<meta charset="ISO-8859-1">
<title>Create User</title>
</head>
<body>
	<h1>Create User</h1>
	<form:form method="POST" modelAttribute="user">
		<spring:bind path="username">
			<div>
				<form:input type="text" path="username" class="form-control"
					placeholder="Username" autofocus="true"></form:input>
				<form:errors path="username" class="error"></form:errors>
			</div>
		</spring:bind>
		<spring:bind path="password">
			<div>
				<form:input type="password" path="password" class="form-control"
					placeholder="Password"></form:input>
				<form:errors path="password" class="error"></form:errors>
			</div>
		</spring:bind>

		<spring:bind path="passwordConfirm">
			<div>
				<form:input type="password" path="passwordConfirm"
					class="form-control" placeholder="Confirm your password"></form:input>
				<form:errors path="passwordConfirm" class="error"></form:errors>
			</div>
		</spring:bind>
		<spring:bind path="email">
			<div>
				<form:input type="text" path="email" class="form-control"
					placeholder="Email" autofocus="true"></form:input>
				<form:errors path="email" class="error"></form:errors>
			</div>
		</spring:bind>

		<spring:bind path="role">
			<div>
				Roles :<br/>
				<form:radiobutton path="role" value="1" />
				ROLE_ADMIN<br/>
				
				<form:radiobutton path="role" value="2" />
				ROLE_USER<br/>
			</div>
		</spring:bind>
		
		<spring:bind path="emp.name">
			<div>
				<form:input type="text" path="emp.name" class="form-control"
					placeholder="Employee name" autofocus="true"></form:input>
			</div>
		</spring:bind><br>
		Birthday : 
		<spring:bind path="emp.birthday">
			<div>
				<form:input type="date" path="emp.birthday" class="form-control"></form:input>
			</div>
		</spring:bind><br>
		
		Level : 
		<spring:bind path="emp.level">
			<div>
				<form:select path="emp.level" class="form-control">
					<form:option value="C1" label="C1"/>  
			        <form:option value="C2" label="C2"/>  
			        <form:option value="C3" label="C3"/>  
				</form:select>  
			</div>
		</spring:bind><br>
		
		Base salary : 
		<spring:bind path="emp.baseSalary">
			<div>
				<form:input type="text" path="emp.baseSalary" class="form-control"
					placeholder="Employee Base Salary" autofocus="true"></form:input>
			</div>
		</spring:bind><br>
	
		<Input type="submit" name="submit" value="submit">
	</form:form>
	<br/>
	
</body>
</html>