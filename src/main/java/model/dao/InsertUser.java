package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertUser {

	public static boolean insert(String id, String fullName, String username, String password) {
		boolean flag = false;
		try {
			Connection conn = JdbcHelper.getConnection();
			PreparedStatement pst = conn.prepareStatement("insert into user values(?,?,?,?)");
			pst.setString(1, id);
			pst.setString(2, fullName);
			pst.setString(3, username);
			pst.setString(4, password);

			int x = pst.executeUpdate();

			if(x>0)
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
}
