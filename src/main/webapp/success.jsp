<%@page import="java.awt.geom.Path2D"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="color: white; background: green;">

<%! String title,msg;%>

	<%
		title = request.getParameter("title");	
		msg = request.getParameter("msg");
	%>
<div align="center">

<h3 style="color: white; background: green;"><%=title%></h3>
<h3 style="color: white; background: blue;"><%=msg%></h3>

</div>
</body>
</html>