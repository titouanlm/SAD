<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employees</title>
</head>
<body>


<h1>Employees</h1>
	<table>
	<tr>
			<td>ID</td>
            <td>NAME</td>
            <td>BIRTHDAY</td>
            <td>LEVEL</td>
            <td>BASE SALARY</td>
            <td>SALARY</td>
     </tr>
	<c:forEach items="${employees}" var="employee">
	
		<tr>
			<td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.birthday}</td>
            <td>${employee.level}</td>
            <td>${employee.baseSalary}</td>
            <td>${employee.calculateSalary()}</td>
        </tr>
		     
		<br>
	</c:forEach>
	</table>
</body>
</html>