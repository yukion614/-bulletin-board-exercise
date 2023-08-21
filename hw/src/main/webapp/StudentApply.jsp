<!--508170636 李佳欣 508170507 賴永宏-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,javax.servlet.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<%@ page import="com.dao.RoomDao" %>
<%@ page import="com.bean.RoomBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sApply</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background:yellow;">
	<div> 
		<label>
		登入者帳戶:
		<%
		String state = (String)session.getAttribute("當前登入者帳戶");
		if(state != null){
			out.print(state);	
		}
		%>
	</label>
	<label>
		當前使用者:
		<%
		String state2 = (String)session.getAttribute("當前登入者姓名");
		if(state2 != null){
			out.print(state2);	
		}
		%>
	</label>
		
	</div>
	<ul style="display:inline;">
	  
	<li style="display:inline;"><a href="sIndex.jsp">公佈欄</a></li>
    <li style="display:inline;"><a href="studentModify.jsp">修改個資</a></li>
    <li style="display:inline;"><a href="StudentApply.jsp">申請房間</a></li>
	</ul>

<form action="sApplyServlet" method="post" >

	<label for="">當前使用者帳號:</label><br>
	<input type="text" name = "sid" value="<%=state %>"  placeholder="<%=state %>" ><br>
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
	<input type="submit" value="送出">

	<label style="background-color:red;">
	
		<%
		String state3 = (String)session.getAttribute("s");
		if(state3 != null){
			out.print(state3);	
		}
		%>
	</label>
	
	
	

</form>	
	
		

</body>
</html>