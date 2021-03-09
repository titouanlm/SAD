<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Users</title>
</head>
<body>

	<label>Delete user by specifying UID</label>
    <form  action="/deleteUserById" method="DELETE">
        UID : <input type="text" name="uid"/><br>
        <input type="submit" />
    </form>


</body>
</html>