package session;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.dao.Expense;

public class SessionManagement {
	public static void setCredential(String username, String password, HttpServletRequest req) {

		// also save in the session to use further
		HttpSession session = req.getSession();
		session.setAttribute("username", username);
		session.setAttribute("password", password);

	}

	public static String getUsername(HttpServletRequest req) {
		HttpSession session = req.getSession();
		return session.getAttribute("username").toString();
	}

	public static String getPassword(HttpServletRequest req) {
		HttpSession session = req.getSession();
		return session.getAttribute("password").toString();
	}

}
