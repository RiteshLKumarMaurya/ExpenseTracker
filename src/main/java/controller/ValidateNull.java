package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidateNull{
	
	public static boolean isNull(String id,String username,String password) {
		if(id.trim().isBlank()||username.trim().isEmpty()||password.trim().isBlank()) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean isNull(String username,String password) {
		if(username.trim().isEmpty()||password.trim().isBlank()) {
			return true;
		}
		else {
			return false;
		}
	}

}
