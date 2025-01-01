package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ValidateUser {
	public static boolean validate(String username, String password) {
		boolean flag = false;
		try {
			Connection conn = JdbcHelper.getConnection();

			if (conn != null) {
				PreparedStatement pst = conn.prepareStatement("select * from user where username=? and password=?");
				pst.setString(1, username);
				pst.setString(2, password);

				ResultSet rs = pst.executeQuery();
				flag = rs.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean validateUsername(String username) {
		boolean flag = false;
		try {
			Connection conn = JdbcHelper.getConnection();

			if (conn != null) {
				PreparedStatement pst = conn.prepareStatement("select * from user where username=?");
				pst.setString(1, username);

				ResultSet rs = pst.executeQuery();
				flag = rs.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
