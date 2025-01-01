<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login error</title>
</head>
<body style="background: red;">

	<div align="center">
		<br><br>
		<h2 style="color: white;">Something Went Wrong!</h2>
		<br>
		

	<%!String msg;%>

	<%
		msg = request.getParameter("msg");
	%>

	<h3 style="color: white; background: blue;"><%=msg %></h3>
	</div>
</body>
</html>