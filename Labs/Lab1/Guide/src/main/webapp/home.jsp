<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Demo</title>
</head>
<body>

    <label>Add user</label>
    <form action="addUser">
        UID : <input type="text" name="uid"/><br>
        Name : <input type="text" name="name"/><br>
        Nationality : <input type="text" name="nationality"/><br>
        <input type="submit" />
    </form>

    <label>Get user by specifying ID</label>
    <form action="getUser">
        UID : <input type="text" name="uid"/><br>
        <input type="submit" />
    </form>
</body>
</html>