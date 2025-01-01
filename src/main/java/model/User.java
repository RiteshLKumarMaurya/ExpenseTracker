package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.dao.JdbcHelper;

public class User {
	String id;
	String username;
	String password;
	
	User(String id,String username,String password){
		this.id=id;
		this.username=username;
		this.password=password;
	}
	
	public User() {

	}
	
	public static String getUserid(String username,String password) {
		String id=null;
		try {
			Connection conn=JdbcHelper.getConnection();
			PreparedStatement pst=conn.prepareStatement("select id from user where username=?and password=?");
			pst.setString(1, username);
			pst.setString(2, password);
			
			ResultSet rs=pst.executeQuery();
			
			if(rs.next()) {
				id=rs.getString("id");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return id;
	}
}
