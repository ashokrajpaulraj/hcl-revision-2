<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1> Welcome to Teacher Mode :: Add a new student </h1>

<a href="/teacher/addstudentform"> Add New Student </a>

&nbsp;&nbsp;&nbsp;&nbsp;

<a href="/teacher/viewallstudents"> View All Students </a>

&nbsp;&nbsp;&nbsp;&nbsp;

<a href="/teacher/logout"> Logout </a>

<hr>

<form action="/teacher/savestudent" method="post">
	
	<label>Name</label>
	<br>
	<input type="text" name="name">
	
	<br><br>
	
	<label>Password</label>
	<br>
	<input type="password" name="password">
	
	<br><br>
	
	<label>Mark 1</label>
	<br>
	<input type="text" name="m1">
	
	<br><br>
	
	<label>Mark 2</label>
	<br>
	<input type="text" name="m2">
	
	<br><br>
	
	<label>Mark 3</label>
	<br>
	<input type="text" name="m3">
	
	<br><br>
	
	<button type="submit"> Add Student </button> 

</form>

</body>
</html>