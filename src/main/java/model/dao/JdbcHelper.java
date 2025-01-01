package model.dao;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcHelper {
	static Connection conn = null;
	static String username = "root";
	static String password = "ghost$fuck$love";
	static String url = "jdbc:mysql://localhost:3306/expence_tracker";
	static String driver = "com.mysql.cj.jdbc.Driver";

	public static Connection getConnection() {
		try {
//			File f=new File("db.properties");
//			FileReader fr=new FileReader(f);
//			Properties p=new Properties();
//			p.load(fr);
//			String driver=(p.getProperty("driver"));
//			String url=p.getProperty("url");

			
			// load and register
			Class.forName(driver);
			conn = DriverManager.getConnection(url, JdbcHelper.username, JdbcHelper.password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(conn);
		System.out.println((int) System.currentTimeMillis());
		return conn;

	}
}
