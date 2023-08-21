//508170636 李佳欣 508170507 賴永宏
package com.dao;
import java.sql.*;

import com.util.DButil;

public class AdminDao {
	
	//註冊 
	public static boolean regist(String adimID, String adimpassword) {
		Connection conn = DButil.getConnectDb();
		String sql = "insert into `admin` (`adimID`,  `adimpassword` )values(?,?)";
		int a = 0 ;
		PreparedStatement stm = null;
	    boolean sta = false;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1,adimID );
			stm.setString(2,adimpassword);
			a = stm.executeUpdate();
			if(a==0) {
				sta = false;
			}else {
				sta = true;
			}
			return sta;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	//登入
		public static boolean login(String adimID, String adimpassword) {
			Connection conn = DButil.getConnectDb();//連結資料庫
			String sql = "select * from `admin` where `adimID` = ? and  `adimpassword`= ?";
			ResultSet a ;
			PreparedStatement stm = null;//上載資料為空
		    boolean sta = false;
			try {
				stm = conn.prepareStatement(sql);//執行sql命令
				stm.setString(1,adimID );//上傳第一筆
				stm.setString(2,adimpassword);//上傳第二筆
				a = stm.executeQuery();
				if(a.next()) {
					System.out.println(22);
					sta = true;
				}else {
					sta = false;
				}
				return sta;
				
			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}

		}

}
