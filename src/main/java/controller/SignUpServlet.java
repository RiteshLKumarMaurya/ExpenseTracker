package controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InsertUser;
import model.dao.ValidateUser;
import session.SessionManagement;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("fullName") != null) {
			String fullName = req.getParameter("fullName");
			String username = req.getParameter("username");
			String password = req.getParameter("password");

			// validate coming data is null or not
			if (ValidateNull.isNull(username, password)) {
				resp.sendRedirect("error?msg=please enter data in the given field!");
			} else {
				boolean isUserNameExist = ValidateUser.validateUsername(username);
				if (isUserNameExist) {
					// send to the error that--> unavailable user-name
					// Inside your servlet method
					String errorMessage = "this username is already taken by another user!";
					String encodedMessage = URLEncoder.encode(errorMessage, "UTF-8");
					resp.sendRedirect("error?msg=" + encodedMessage);

				} else {

					// send data to the db
					String id = String.valueOf((int) System.currentTimeMillis());
					boolean inserted = InsertUser.insert(id, fullName, username, password);
					if (inserted) {
						// store in the session to further use
						SessionManagement.setCredential(username, password, req);

						// send to the home page
						resp.sendRedirect("home");
					} else {
						// send to the error page

						resp.sendRedirect("error?msg=already user exist!");

					}
				}
			}
		} else {
			resp.sendRedirect("signup.jsp");
		}
	}

}
