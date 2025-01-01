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
	<h3>Sign-Up</h3><br>
	<form action="signup" method="post">
		<input required="required" name="fullName" placeholder="enter full name" type="text"><br><br>
		<input required="required" name="username" placeholder="enter username" type="text"><br><br>
		<input required="required" name="password" placeholder="enter password" type="password"><br><br>
		<input type="submit" value="sign-up" style="color: white; background: green;">
		<br><br> <br><br>
		Already have,<a href="login" title="click to sign up"> an account?</a>
		
	</form>
	</div>
</body>
</html>