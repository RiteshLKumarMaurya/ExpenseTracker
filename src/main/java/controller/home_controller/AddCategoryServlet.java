package controller.home_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InsertCategory;

@WebServlet("/add-category")
public class AddCategoryServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String category=req.getParameter("category");
		String category_desc=req.getParameter("category-desc");
		
		if(category!=null&&category_desc!=null) {
			//save the data into the category table
			
			boolean isInserted=InsertCategory.insert(category, category_desc);
			if(isInserted) {
				//send to the success page with msg => category added successfully
				resp.sendRedirect("success?title=Operation Success!&msg=a new category added successfully!");
			}
			else {
				//category didnot added!
				resp.sendRedirect("error?title=Operation Failed!&msg=a new category didn't successfully added!");				
			}
			
		}else {
			resp.sendRedirect("add_category.jsp");
		}
		
	}

}
