<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> Welcome to Student Mode :: Hi, ${student.getName()}</h1>

<a href="/Security-Demo-0.0.1-SNAPSHOT/teacher/logout"> Logout </a>

<hr>

<table border="1">
	<tr>
		<th>Subject 1 </th>
		<td> ${student.getM1()} </td>
	</tr>
	<tr>
		<th>Subject 2 </th>
		<td> ${student.getM2()} </td>
	</tr>
	<tr>
		<th>Subject 3 </th>
		<td> ${student.getM3()} </td>
	</tr>
	<tr>
		<th>Total </th>
		<td> ${student.getM1() + student.getM2() + student.getM3()} </td>
	</tr>
	<tr>
		<th>Average </th>
		<td> ${(student.getM1() + student.getM2() + student.getM3())/3} </td>
	</tr>
</table>


</body>
</html>