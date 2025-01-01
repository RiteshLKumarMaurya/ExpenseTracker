<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<br>
	<h3>Login</h3><br>
	<form action="login" method="post">
		<input required="required" name="username" placeholder="enter username" type="text"><br><br>
		<input required="required" name="password" placeholder="enter password" type="password"><br><br>
		<input type="submit" value="login" style="color: white; background: green;">
		<br><br><br> 
		Don't have,<a href="signup" title="click to login"> an account?</a>
	</form>
	</div>
</body>
</html>