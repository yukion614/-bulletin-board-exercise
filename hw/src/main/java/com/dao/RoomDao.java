//508170636 李佳欣 508170507 賴永宏
package com.dao;
import java.sql.*;
import java.util.ArrayList;
import com.bean.RoomBean;
import com.util.DButil;
public class RoomDao {
	//抓房間號碼至beam
	public static ArrayList getRoomNumber() {
				ArrayList tag_Array = new ArrayList();//
				Connection conn = DButil.getConnectDb();
				String sql = "select * from `rooms` ";
				PreparedStatement stm = null;
				ResultSet rs = null;
				try {
					stm = conn.prepareStatement(sql);
					rs = stm.executeQuery();
					while(rs.next()) {
						RoomBean tag = new RoomBean();
						tag.setRoomNumber(rs.getString("roomNumber"));  
						tag_Array.add(tag);
					}
					rs.close();
					stm.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				return tag_Array;
			}

}
