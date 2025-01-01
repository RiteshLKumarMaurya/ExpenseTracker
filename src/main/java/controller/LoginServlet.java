package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.ValidateUser;
import session.SessionManagement;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("username") != null) {

			// get the username and the password from the url-pattern
			String username = req.getParameter("username");
			String password = req.getParameter("password");

			// validate coming data is null or not
			if (ValidateNull.isNull(username, password)) {
				resp.sendRedirect("error?msg=please enter data in the given field!");
			} else {

				// Validate user credentials if matched then send to the home page/profile
				boolean isUserExist = ValidateUser.validate(username, password);
				if (isUserExist) {
					// store in the session to further use
					SessionManagement.setCredential(username, password, req);

					// redirect to the homePage using the controller only
					resp.sendRedirect("home");

				} else {
					// redirect to the Error page--> in error page also show the option of the
					// sign-up
					resp.sendRedirect("error?msg=username or password not matched!");
				}
			}
		} else {
			resp.sendRedirect("login.jsp");
		}
	}

}
