package controller.home_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InsertExpenceDetail;
import session.Flager;

@WebServlet("/save-expense-changes")
public class SaveExpenseChangesServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//FOR THIS VERSION NO PHOTO CHANGEABLE
		//first get all the data from there url pattern
		
		String id=req.getParameter("id");
		System.out.println("id:: "+id);
		String title=req.getParameter("title");
		System.out.println("title:: "+title);
		String description=req.getParameter("description");
		String amount=req.getParameter("amount");

		boolean res=InsertExpenceDetail.insertExpense(id, title, description,amount);
		//save to the database
		
			// if success then success page

			if(res==true) {
				Flager.setFlag(true);
				resp.sendRedirect("success?title=operation success!&msg=your expense detail updated successfully.");
			}else {
				resp.sendRedirect("error?title=operation failed!&msg=your expense detail updation failed.");
			}
		
			//------------
		
			//else send to the error page
	}
	
}
