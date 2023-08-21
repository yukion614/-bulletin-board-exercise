<!--508170636 李佳欣 508170507 賴永宏-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.bean.StudentBean" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<%@ page import="com.dao.RoomDao" %>
<%@ page import="com.bean.RoomBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理員設定房間</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background:red;">

<ul style="display:inline;">
	<li style="display:inline;"><a href="Aindex.jsp">公佈欄</a></li>
    <li style="display:inline;"><a href="ASetRoom.jsp">編排房間</a></li>
    <li style="display:inline;"><a href="ASerchStudent.jsp">查找學生資料</a></li>
    

</ul>
<form action="SetRoomServlet" method="post" >
	<select  name="room">
		<%
		ArrayList rooms = RoomDao.getRoomNumber();
		if(rooms!=null){
			for(int i =0;i < rooms.size() ; i++){
				RoomBean a = (RoomBean) rooms.get(i);
		%>
				<option value="<%=a.getRoomNumber() %>"><%=a.getRoomNumber() %></option>
		<%   
				}
			}
		%>
	
	</select>
	<input type="submit" value="排序">

</form>
    

	<label>
		排序狀態
		<%
		String state = (String)session.getAttribute("排序狀態");
		if(state != null){
			out.print(state);	
		}
		%>
	</label>
	
	
	









</body>
</html>