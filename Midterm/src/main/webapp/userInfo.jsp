<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Info</title>
</head>
<body>

	<h1> My Informations </h1>
	<table>
	<tr>
			<td>ID</td>
            <td>NAME</td>
            <td>BIRTHDAY</td>
            <td>LEVEL</td>
            <td>BASE SALARY</td>
     </tr>
		<tr>
			<td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.birthday}</td>
            <td>${employee.level}</td>
            <td>${employee.baseSalary}</td>
        </tr>	    
	</table>
</body>
</html>