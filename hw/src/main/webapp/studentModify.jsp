<!--508170636 李佳欣 508170507 賴永宏-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sModify</title>
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

<h3>學生修改資訊</h3>
<hr>
<form action="modifyServletDBServlet" method="post" >
	帳號<br>
	<input type="text" name="id"  placeholder="<%=state %>" value="<%=state %>"><br>
	密碼<br>
	<input type="password" name="password"  placeholder="請輸入密碼"><br>
	性別<br>
	<select  name="gender">
				<option value="B" >男</option>
				<option value="W">女</option>
	</select><br>
	信箱<br>
	<input type="email" name="email"><br>
	電話<br>
	<input type="tel" name="tel"><br>
	備註<br>
	<textarea  name="MEMO" rows="5" cols="40"></textarea><br>
	
	
	<input type="submit" value="送出">
	<label style="background-color:red;">
		
		<%
		String state3 = (String)session.getAttribute("使用者修改");
		if(state3 != null){
			out.print(state3);	
		}
		%>
	</label>
	
</form>

</body>
</html>