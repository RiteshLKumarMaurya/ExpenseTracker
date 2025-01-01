package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.Expense;

@WebServlet("/edit-expense")
public class EditExpenseServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String flag=req.getParameter("flag");
		String id=req.getParameter("id");
		
		if(flag!=null) {
			//means we need to perform the all updation logic
			
		}else {
			//means the user should be redirected to the jsp page to updation
			
			resp.sendRedirect("edit_expense.jsp?id="+id);
		}
		
	}

}
