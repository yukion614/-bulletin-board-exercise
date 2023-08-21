//508170636 李佳欣 508170507 賴永宏
package com.util;
import java.sql.*;

//連接sql
public class DButil {
	public static String username = "root";
	public static String password = "root";
	public static String url = "jdbc:mysql://localhost:3306/admindb?useUnicode=true&characterEncoding=UTF-8";//sql

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");//載入驅動
		}catch(ClassNotFoundException e){
			e.printStackTrace();
	    }
		
	}
	//登入數據庫,回傳連結
	public static Connection getConnectDb() {
		Connection  conn = null;
		try {
			 conn = DriverManager.getConnection(url,username,password);
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return conn;
		
	}
	
	
	
	
}
