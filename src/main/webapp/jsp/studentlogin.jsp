<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> Welcome to Student Login </h1>

<form action="/student/studentloginverify" method="post">
	<label>Login Id : </label>
	<input type="text" name="id" />
	<br><br>
	<label>Password : </label>
	<input type="password" name="password" />
	<br><br>
	<button type="submit"> Login </button>
</form>

</body>
</html>