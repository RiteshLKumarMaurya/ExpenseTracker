<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="add-expense" method="post" enctype="multipart/form-data">
	<div align="center">
		<br>
		<h3>Add a new expence</h3>
		<br>
		<!-- make sure number of char limit. -->
		
		<select name="category">
			<option value="" label="Choose your option">
	
	<!-- inbuild by the app provided the category -->
			<option value="food" label="Food & Dining">
			<option value="transport" label="Transport">
			<option value="grocery" label="Groceries">
			<option value="utility" label="Utilities">
			<option value="health" label="Health & Fitness">
			<option value="shopping" label="Shopping">
			<option value="entertainment" label="Entertainment">
			<option value="education" label="Education">
			<option value="miscellaneous" label="Miscellaneous">
			
		</select><br><br>
		
		<input placeholder="enter title" name="title" type="text" required="required"><br><br>
		<textarea rows="4px" cols="20px" name="desc" placeholder="about your expence"></textarea><br><br>
		<input placeholder="enter amount" name="amount" required="required" type="number" ><br> <br>
		<input accept="image/*" type="file" name="file"><br><br>
		<input style="color: white; background: green;" type="submit" value="Add Now">
	</div>
	</form>
	
</body>
</html>