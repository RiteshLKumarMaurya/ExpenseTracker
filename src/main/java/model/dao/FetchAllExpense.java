package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import session.SessionManagement;

public class FetchAllExpense {
	public static List<Expense> commonExpenses;
	
	// i will be use the filter--> to implement the things known as the Comparable
	// and the Comparator
	
	public List<Expense> getAllExpenses(String username, String password,boolean flag) {
		//if flag true--> then need to fetch fresh means again execute the query otherwise not
		
		
		
		if(flag!=true&&commonExpenses!=null) {
			return commonExpenses;
		}else {
			
			List<Expense> expenses = new ArrayList<Expense>();
			commonExpenses=new ArrayList<Expense>();
			
			// first we need to get the connection and using the user credential get the all
			// expense

			Expense expense=null;
			Connection conn = JdbcHelper.getConnection();
			try {
				PreparedStatement pst = conn.prepareStatement(
						"select * from expense where u_id in(select id from user where username=? and password=?)");

				pst.setString(1, username);
				pst.setString(2, password);
				
				ResultSet rs = pst.executeQuery();
				

				while (rs.next()) {
					String id = rs.getString("id");
					String title = rs.getString("title");
					String description = rs.getString("description");
					Double amount = rs.getDouble("amount");
					String image = rs.getString("image");
					String u_id = rs.getString("u_id");
					Timestamp date = rs.getTimestamp("date");
					int category_id = rs.getInt("category_id");

					 expense=new Expense(id, title, description, image, u_id, category_id, amount, date);
				
					 expenses.add(expense);
				}

				

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return expenses;
		}
		

		
	}

}
