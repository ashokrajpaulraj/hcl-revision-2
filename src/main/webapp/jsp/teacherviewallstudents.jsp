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


<h1> Welcome to Teacher Mode :: View all students </h1>

<a href="/Security-Demo-0.0.1-SNAPSHOT/teacher/addstudentform"> Add New Student </a>

&nbsp;&nbsp;&nbsp;&nbsp;

<a href="/Security-Demo-0.0.1-SNAPSHOT/teacher/viewallstudents"> View All Students </a>

&nbsp;&nbsp;&nbsp;&nbsp;

<a href="/Security-Demo-0.0.1-SNAPSHOT/teacher/logout"> Logout </a>

<hr>

<table border="1">
	<thead>
		<tr>
			<th> Name </th>
			<th> Mark 1 </th>
			<th> Mark 2 </th>
			<th> Mark 3 </th>
			<th> Total </th>
			<th> Average </th>
			<th> Login Id </th>
			<th> Login Pwd </th>
			<th> Action </th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${data}" var="temp" > 
			<tr>
				<td>${temp.getName()}</td>

				<td>${temp.getM1()}</td>

				<td>${temp.getM2()}</td>

				<td>${temp.getM3()}</td>
				
				<td>${ temp.getM1() + temp.getM2() + temp.getM3() }</td>

				<td>${ (temp.getM1() + temp.getM2() + temp.getM3())/3 }</td>
				
				<td>${temp.getId()}</td>
				
				<td>${temp.getPassword()}</td>
				
				<td>
					<a href="/Security-Demo-0.0.1-SNAPSHOT/teacher/studentdelete/${temp.getId()}"> Delete </a>
					&nbsp;&nbsp;&nbsp;
					<a href="/Security-Demo-0.0.1-SNAPSHOT/teacher/studentupdateform?id=${temp.getId()}"> Update </a>
				</td>
			</tr>
		</c:forEach>
	</tbody>


</table>
</body>
</html>