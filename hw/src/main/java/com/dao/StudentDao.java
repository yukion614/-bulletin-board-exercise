//508170636 李佳欣 508170507 賴永宏
package com.dao;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import com.bean.StudentBean;
import com.bean.*;
import com.util.DButil;
import com.dao.RoomDao;
public class StudentDao {
	//修改學生資訊
	public static boolean modify(String sID, String sPassword , String gender  , String eMail, String sPhone,String sMemo) {
		Connection conn = DButil.getConnectDb();
		String sql = "update `students` set `sPassword`=?, `gender`=?,`eMail`=?,`sPhone`=?,`sMemo` =? where `sID` = ?" ;
		PreparedStatement stm = null;
		ResultSet rs = null;
		int a = 0 ;
		boolean sta = false;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1,sPassword );
			stm.setString(2,gender );
			stm.setString(3,eMail );
			stm.setString(4,sPhone );
			stm.setString(5,sMemo );
			stm.setString(6,sID );
			a = stm.executeUpdate();
			if(a==0) {
				sta = false;
			}else {
				sta = true;
			}
			System.out.print("sta is :"+sta);
			return sta;
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}

	} 

	
	
	//取得公佈欄資訊
	public static ArrayList getBillboard() {
		ArrayList tag_Array = new ArrayList();
			Connection conn = DButil.getConnectDb();
			PreparedStatement stm = null;
			ResultSet rs = null;
		//取得房號
		ArrayList rooms = RoomDao.getRoomNumber();
		String one =null,two=null,three=null,four=null,five=null;
		if(rooms!=null){
			for(int i =0;i < rooms.size() ; i++){
				RoomBean a = (RoomBean) rooms.get(i);
				switch(i){
			    case 0 :
			        one = a.getRoomNumber();
			       break; 
			    case 1 :
			    	two = a.getRoomNumber();
			       break; 
			    case 2 :
			    	three = a.getRoomNumber();
				       break;
				case 3 :
					four = a.getRoomNumber();
				       break;
				case 4 :
					five = a.getRoomNumber();
				       break; 
				
			    default : 
			       
			}
	  
			}
		}
		String sql = "select `sID`, `sName` , `gender` ,`sRoom` from `students` where `sRoom` = "+ one +" or `sRoom` = "+ two +" or `sRoom` = "+ three +" or `sRoom` = "+ four +" or `sRoom` = " + five +" order by `sRoom`";
		//取得符合學生資訊
			try {
				stm = conn.prepareStatement(sql);
				System.out.println("runrun4");
				rs = stm.executeQuery();
				while(rs.next()) {
					StudentBean tag = new StudentBean();
					tag.setsID(rs.getString("sID"));
					tag.setsName(rs.getString("sName"));
					tag.setGender(rs.getString("gender"));
					tag.setsRoom(rs.getString("sRoom"));
					tag_Array.add(tag);
				
				}
				rs.close();
				stm.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			System.out.println("runrun6");
			return tag_Array;
			
		}
	
	
//查詢輸入ID的學生
public static ArrayList getLikeList(String sID) {
			ArrayList tag_Array = new ArrayList();//
			Connection conn = DButil.getConnectDb();
			String sql = "select * from `students` where `sid` = " + sID;
			PreparedStatement stm = null;
			ResultSet rs = null;
			try {
				
				stm = conn.prepareStatement(sql);
				rs = stm.executeQuery();
				while(rs.next()) {
					StudentBean tag = new StudentBean();
					tag.setsID(rs.getString("sID"));
					tag.setsName(rs.getString("sName"));
					tag.setGender(rs.getString("gender"));
					tag.seteMail(rs.getString("eMail")); 
					tag.setsPhone(rs.getString("sPhone"));
					tag.setsMemo(rs.getString("sMemo"));
					tag.setsRoom(rs.getString("sRoom"));
					tag.setStime(rs.getString("stime"));
					tag.setsTmpRoom(rs.getString("sTmpRoom"));
					tag.setsContactP(rs.getString("sContactP"));
					tag.setsCPPhone(rs.getString("sCPPhone"));
					tag_Array.add(tag);
				}
				rs.close();
				stm.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return tag_Array;
		}
	

	//管理員設定房間
	public static boolean setRoom(String Room ) {
		Connection conn = DButil.getConnectDb();
		String sql = "update `students`  set `sRoom` = ? where `sTmpRoom` = ?  order by `stime` DESC  limit 4";
		PreparedStatement stm = null;
		ResultSet rs = null;
		int a = 0 ;
		boolean sta = false;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1,Room );
			stm.setString(2,Room );
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
	
	//申請房間
	public static boolean setApplyRoom(String sId, String sRoom ,  String time) {
		Connection conn = DButil.getConnectDb();//連結資料庫
		String sql = "update `students`  set `sTmpRoom` = ? ,`stime` = ? where `sID` = ?";
		PreparedStatement stm = null;
		ResultSet rs = null;
		int a = 0 ;
		boolean sta = false;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1,sRoom );
			stm.setString(2,time );
			stm.setString(3,sId );
			a = stm.executeUpdate();
			if(a==0) {
				sta = false;
			}else {
				sta = true;
			}
			System.out.print("sta = " + sta);
			return sta;
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		

	}
	

	//取得當前使用者姓名
	public static String getSID( String sID) {
		String sName = new String();
		Connection conn = DButil.getConnectDb();
		String sql = "select `sName` from `students` where `sID` =" + (String)sID ;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()) {
				 sName = rs.getString("sName");
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return  sName;
	}


	//註冊 
		public static boolean regist(String sID, String sName, String sPassword, String gender, String eMail, String sPhone, String sMemo) {
			Connection conn = DButil.getConnectDb();
			String sql = "insert into `students`(`sID`,`sName`,`sPassword`,`gender`,`eMail`,`sPhone`,`sMemo`) values(?,?,?,?,?,?,?)";
			int a = 0 ;
		
			PreparedStatement stm = null;
		    boolean sta = false;
			try {
				stm = conn.prepareStatement(sql);
				stm.setString(1,sID );
				stm.setString(2,sName);
				stm.setString(3,sPassword );
				stm.setString(4,gender);
				stm.setString(5,eMail );
				stm.setString(6,sPhone);
				stm.setString(7,sMemo);
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
				String sql = "select * from `students` where `sID` = ? and  `sPassword`= ?";
				ResultSet a ;
				/////////////
				PreparedStatement stm = null;
			    boolean sta = false;
				try {
					stm = conn.prepareStatement(sql);
					stm.setString(1,adimID );
					stm.setString(2,adimpassword);
					a = stm.executeQuery();
					if(a.next()) {
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

	
	

	//學生更改信息
	public static boolean changeStudent(String sID,String sName, String sPassword , String gender  , String eMail, String sPhone,String sMemo) {
		Connection conn = DButil.getConnectDb();
		String sql = "update `students` set `sName` = ?, `sPassword`=?, `gender`=?,`eMail`=?,`sPhone`=?,`sMemo` =? where `sID` =" + sID;
		int a ;
		PreparedStatement stm = null;
	    boolean sta = false;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1,sName );
			stm.setString(2,sPassword);
			stm.setString(3,gender);
			stm.setString(4,eMail);
			stm.setString(5,sPassword);
			stm.setString(6,gender);
			stm.setString(7,eMail);
			stm.setString(8,sPhone);
			stm.setString(9,sMemo);
			a = stm.executeUpdate();
			if(a == 1) {
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



	
	
}
