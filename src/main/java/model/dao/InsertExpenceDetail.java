package model.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import model.User;
import session.SessionManagement;

public class InsertExpenceDetail {
	public static boolean insertExpense(HttpServletRequest req) {
		boolean flag = false;

		try {
			String title = req.getParameter("title");
			String description = req.getParameter("desc");
			double amount = Double.parseDouble(req.getParameter("amount"));
			Part parts = req.getPart("file");
			String category = req.getParameter("category");
			int category_id = predictCategoryId(category);
			InputStream imgStream = parts.getInputStream();

			String imgString = Base64.getEncoder().encodeToString(imgStream.readAllBytes());

			// id=ms
			String id = String.valueOf(System.currentTimeMillis());

			// get id of the current user by session--> do this too before
			String username = SessionManagement.getUsername(req);
			String password = SessionManagement.getPassword(req);

			String user_id = User.getUserid(username, password);

			// now call the method to insert
			flag = insertNow(id, title, description, amount, imgString, user_id, category_id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

	private static int predictCategoryId(String category) {
		switch (category) {
		case "food":
			return 1;

		case "transport":
			return 2;

		case "grocery":
			return 3;

		case "utility":
			return 4;

		case "health":
			return 5;

		case "shopping":
			return 6;

		case "entertainment":
			return 7;

		case "education":
			return 8;

		case "miscellaneous":
			return 9;

		default:
			return 0;

		}

	}

	public static boolean insertNow(String id, String title, String description, double amount, String img,
			String user_id, int category_id) {
		boolean flag = false;
		try {
			Connection conn = JdbcHelper.getConnection();
			PreparedStatement pst = conn.prepareStatement(
					"insert into expense(id,title,description,amount,image,u_id,category_id) values(?,?,?,?,?,?,?)");
			pst.setString(1, id);
			pst.setString(2, title);
			pst.setString(3, description);
			pst.setDouble(4, amount);

			pst.setString(5, img);
			pst.setString(6, user_id);
			pst.setInt(7, category_id);

			int rows = pst.executeUpdate();
			if (rows > 0) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean insertExpense(String id, String title, String description, String amount) {
		
		System.out.println("id: "+id);
		System.out.println("title: "+title);
		System.out.println("desc: "+description);
		System.out.println("amount: "+amount);
		
		boolean flag = false;
		Connection conn = null;
		try {
			conn = JdbcHelper.getConnection();

			PreparedStatement pst = conn
					.prepareStatement("update expense set title=?,description=?,amount=? where id=?");
			pst.setString(1, title);
			pst.setString(2, description);
			pst.setDouble(3, Double.parseDouble(amount));
			pst.setString(4, id);

			int x = pst.executeUpdate();
			if (x > 0) {
				System.out.println("x:@@@@@@@@@@@@@@@@@@@@@ "+x);
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

}
