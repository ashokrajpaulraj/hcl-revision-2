<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1> Welcome to Teacher Mode :: Update student </h1>

<a href="/teacher/addstudentform"> Add New Student </a>

&nbsp;&nbsp;&nbsp;&nbsp;

<a href="/teacher/viewallstudents"> View All Students </a>

&nbsp;&nbsp;&nbsp;&nbsp;

<a href="/teacher/logout"> Logout </a>

<hr>

<form action="/teacher/updatestudent" method="post">
	
	<input type="text" name="id" value="${data.getId()}" readonly style="display: none">
	
	<label>Name</label>
	<br>
	<input type="text" name="name" value="${data.getName()}">
	
	<br><br>
	
	<label>Password</label>
	<br>
	<input type="password" name="password" value="${data.getPassword()}">
	
	<br><br>
	
	<label>Mark 1</label>
	<br>
	<input type="text" name="m1" value="${data.getM1()}">
	
	<br><br>
	
	<label>Mark 2</label>
	<br>
	<input type="text" name="m2" value="${data.getM2()}">
	
	<br><br>
	
	<label>Mark 3</label>
	<br>
	<input type="text" name="m3" value="${data.getM3()}">
	
	<br><br>
	
	<button type="submit"> Add Student </button> 

</form>

</body>
</html>