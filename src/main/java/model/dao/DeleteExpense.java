package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteExpense {
	static Connection conn=null;
	
	public static boolean deleteNow(String id) {
		boolean flag=false;
		try {
			
			conn=JdbcHelper.getConnection();
			PreparedStatement pst=conn.prepareStatement("delete from expense where id=?");
			pst.setString(1, id);
			
			int x=pst.executeUpdate();
			if(x>0) {
				flag=true;
			}
			
		}catch (Exception e) {
		
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
}
