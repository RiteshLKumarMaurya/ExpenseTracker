//package model.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Timestamp;
//
//public class ExpenseLoader {
//	// to get the all data of the particular expense and initialize to the
//	// constructor of expense that any req can be use this
//
//	public Expense loadNow(String id) {
//		Connection conn = null;
//		Expense expense = null;
//		try {
//
//			// connectio build and pass the quey and then execute the query
//			conn = JdbcHelper.getConnection();
//			PreparedStatement pst = conn.prepareStatement("select * from expense where id=?");
//
//			pst.setString(1, id);
//			
//			ResultSet rs = pst.executeQuery();
//
//			// now get all the data from the resultset and pass to the constructor
//
//			String e_id = null, title = null, description = null, image = null, u_id = null;
//			double amount = 0.0;
//			Timestamp date = null;
//			int category_id = 0;
//			if (rs.next()) {
//
//				e_id = rs.getString("id");
//				title = rs.getString("title");
//				description = rs.getString("description");
//				amount = rs.getDouble("amount");
//				image = rs.getString("image");
//				u_id = rs.getString("u_id");
//				date = rs.getTimestamp("date");
//				category_id = rs.getInt("category_id");
//
//			}
//
//			expense = new Expense(e_id, title, description, image, u_id, category_id, amount, date);
//
//		} catch (Exception e0) {
//			e0.printStackTrace();
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e2) {
//				e2.printStackTrace();
//			}
//		}
//		return expense;
//	}
//}
