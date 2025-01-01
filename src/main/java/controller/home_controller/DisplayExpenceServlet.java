package controller.home_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.filter.FilterExpense;

@WebServlet("/display-expense")
public class DisplayExpenceServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String filter_value = req.getParameter("filter_value");
		if (filter_value != null) {
			// mean apply the filter otherwise auto will be done

			// but from here we need to sort

			FilterExpense.filter(filter_value,req);
			
			
			//NOW REDIRECT
			resp.sendRedirect("display_expense.jsp");

		} else {
			// also redirect means first time user comes
			resp.sendRedirect("display_expense.jsp");
		}

	}

}
