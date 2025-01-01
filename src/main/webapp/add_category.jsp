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
		<form action="add-category"><br><br>
			<h2>Add Category</h2>
			
			<br><br>
			
			<input required="required" type="text" placeholder="Category name" name="category">
			<br><br>
			
			<textarea required="required" rows="8px" cols="40px" placeholder="about category" name="category-desc"></textarea>
			<br><br>
			
			<input type="submit" value="add now" style="background: green;color: white;">
		</form>
	</div>
</body>
</html>