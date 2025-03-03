<%@page import="java.util.List"%>
<%@page import="model.dao.FetchAllExpense"%>
<%@page import="model.dao.Expense"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!String id, 
	title, description, image, u_id;
	String category_id;
	String amount;
	String date;
	Expense expense;	
%>

<%

String id=request.getParameter("id");

for(int i=0;i<FetchAllExpense.commonExpenses.size();i++){
	if(id.equals(FetchAllExpense.commonExpenses.get(i).getId())){
		expense=FetchAllExpense.commonExpenses.get(i);
		break;
	}
}




//now initialize all variables

%>

<%
//initializing
id=expense.getId();
title=expense.getTitle();
description=expense.getDescription();
image=expense.getImage();
u_id=expense.getU_id();
category_id=String.valueOf(expense.getCategory_id());
amount=String.valueOf(expense.getAmount());
date=String.valueOf(expense.getDate());
%>

	<form action="save-expense-changes?id=<%= id %>" method="post">
	<div
		style="border: 1.2px solid blue; padding: 3px; margin-left: 8px; border-radius: 10px; display: inline-block;margin-top: 4px; margin-bottom: 4px;">
		<div style="display: inline-block; margin: 10px;">
			<div style="width: 240px;">
				<br>
				<div align="center">
					
					<label>title: </label>
					<input style="margin: 4px" value="<%=title %>" type="text" name="title" required="required">
					<br>
					<label>Amount: </label>
					<input value="<%=amount%>" type="text" name="amount">
					<br>
					<br>
					<div align="center"
						style="background: #cccccc; border-radius: 10px; padding: 4px;">
						
						<pre style="color: blue;"><%="< " + date + " >"%></pre>

						<textarea rows="6px" cols="24px" placeholder="describe your expense" required="required" name="description" ><%=description %></textarea>						
					
					</div>
				</div>
				
				<div
					style="display: flex; justify-content: space-between; padding: 10px;">

					<button style="color: white; background: blue; padding: 4px;" type="submit">Save changes</button>

					<a href="display_expense.jsp" style="color: white;  background: red; padding: 4px; text-decoration: none; display: inline-block; border-radius: 4px;">
    				Cancel changes
					</a>
					
				</div>
			</div>
		</div>
	</div>
	</form>

</body>
</html>