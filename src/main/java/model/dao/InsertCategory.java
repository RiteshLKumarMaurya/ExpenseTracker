package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertCategory {
	static Connection conn = null;
	static PreparedStatement pst = null;

	public static boolean insert(String category, String categoryDescription) {
		boolean flag = false;
		try {
			conn = JdbcHelper.getConnection();

			pst = conn.prepareStatement("insert into category(name,description) values(?,?)");
			pst.setString(1, category);
			pst.setString(2, categoryDescription);

			flag = pst.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean insert(int id, String category, String categoryDescription) {
		boolean flag = false;
		try {
			conn = JdbcHelper.getConnection();

			pst = conn.prepareStatement("insert into category(id,name,description) values(?,?,?)");
			
			pst.setInt(1, id);
			pst.setString(2, category);
			pst.setString(3, categoryDescription);

			flag = pst.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
