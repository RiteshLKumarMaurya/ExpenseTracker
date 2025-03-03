package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.home_controller.SuccessServlet;
import model.dao.DeleteExpense;
import session.Flager;

@WebServlet("/delete-expense")
public class DeleteExpenseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if (id != null) {
			boolean result = DeleteExpense.deleteNow(id);
			if(result) {
				Flager.setFlag(true);
				//send to the deletion success page
				resp.sendRedirect("success?title=deletion success!&msg=your expense record successfully deleted.");
			}
			else {
				//send to the deletion failed
				resp.sendRedirect("error?title=deletion failed!&msg=your expense deletion  failed.");
			}
		}
	}
}
