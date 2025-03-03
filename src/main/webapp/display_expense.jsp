<%@page import="session.Flager"%>
<%@page import="model.dao.Expense"%>
<%@page import="session.SessionManagement"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="model.dao.FetchAllExpense"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<!-- Use the sorting also...  -->
	<br>
	<div style="justify-content: space-between; display: flex;">
		<h2 style="margin: 10px">Your All Expenses</h2>
		<form action="display-expense">
			<div style="margin: 4px;">
				<div style="margin: 2px">
					<h3>Filter</h3>
					<select name="filter_value">
						<option value="" label="choose option">
						<option value="date-asc" label="date-asc">
						<option value="date-desc" label="date-desc">
						<option value="amount-desc" label="amount-desc">
						<option value="amount-asc" label="amount-asc">
						<option value="title-desc" label="title-desc">
						<option value="title-asc" label="title-asc">
					</select>
				</div>
				<input style="padding: 2px;" type="submit" value="apply filter">

			</div>
		</form>

	</div>
	<br>
	<br>

	<!-- declare a List<Expense>  -->
	<%!List<Expense> expenses;%>
	<%!String id, title, description, image, u_id;
String category_id;
String amount;
String date;%>

	<!-- fetch all resources -->
	<!-- only need to just fetch and the display! i have written the logic in the d.a.o -->

	<%
	// get the user name and the password to get the list of the expenses

	FetchAllExpense fetcher = new FetchAllExpense();
	List<Expense> expenses = fetcher.getAllExpenses(SessionManagement.getUsername(request),
			SessionManagement.getPassword(request),Flager.isFlag());
	fetcher.commonExpenses = expenses;
	%>

	<%
	System.out.println(expenses.size());
	for (int i = 0; i < expenses.size(); i++) {
		Expense expense = expenses.get(i);

		id = expense.getId();
		title = expense.getTitle();
		description = expense.getDescription();
		image = expense.getImage();
		u_id = expense.getU_id();
		category_id = String.valueOf(expense.getCategory_id());
		amount = String.valueOf(expense.getAmount());
		date = String.valueOf(expense.getDate());
	%>




	<div
		style="border: 1.2px solid blue; padding: 3px; margin-left: 8px; border-radius: 10px; display: inline-block; margin-top: 4px; margin-bottom: 4px;">
		<div style="display: inline-block; margin: 10px;">
			<div style="width: 240px;">
				<%
				if (image != null && image.length() > 10 && image.isBlank() == false && image.isEmpty() == false) {
				%>
				<div style="size: 120px;" align="center">
					<img src="data:image/png;base64,<%=image%>" alt="Uploaded Image"
						style="max-width: 160px; max-height: 160px; display: inline-block;" />
				</div>
				<br>
				<%
				}
				%>

				<div align="center">
					<h2 style="display: inline;"><%=title%></h2>
					<pre style="color: purple; font-weight: bold;"><%=" ( ₹" + amount + " )"%></pre>
					<br>
					<div align="center"
						style="background: #cccccc; border-radius: 10px; padding: 4px;">
						<pre style="color: blue;"><%="< " + date + " >"%></pre>
						<p><%=description%></p>
					</div>
				</div>
				<div
					style="display: flex; justify-content: space-between; padding: 10px;">
					<a href="edit-expense?id=<%=id%>"
						style="color: white; background: blue; padding: 4px; text-decoration: none; display: inline-block; border-radius: 4px;">
						Edit Expense </a> <a href="delete-expense?id=<%=id%>"
						style="color: white; background: red; padding: 4px; text-decoration: none; display: inline-block; border-radius: 4px;">
						Delete Expense </a>

				</div>
			</div>
		</div>
	</div>



	<%
	}
	%>

	<!-- check whether it is having [{}] or having some of the data!  -->


</body>
</html>