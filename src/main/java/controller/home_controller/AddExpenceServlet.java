package controller.home_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.dao.InsertExpenceDetail;

@MultipartConfig(maxFileSize = 1024*1024*10)
@WebServlet("/add-expense")
public class AddExpenceServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String flag=req.getParameter("flag");
		
		if(flag!=null) {
			//send to the jsp page to add the expense details
			resp.sendRedirect("add_expense.jsp");
			
		}
		else {
			
			//perform the operation  of the insertion of the expenceDetails
			boolean inserted=InsertExpenceDetail.insertExpense(req);
			
			
			if(inserted) {
				//send to the insertion success page
				resp.sendRedirect("success?title=Insertion success!&msg=your expenses detail added in the list!");
			}
			else {
				//send to the error page 
				resp.sendRedirect("error?msg=expenses detailed insertion failed!");

			}
			
		}
	
	}

}
