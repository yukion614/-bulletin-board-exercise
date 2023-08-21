<!--508170636 李佳欣 508170507 賴永宏-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理員註冊</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h3>管理員註冊</h3>
<hr>
<form action="ARegistServlet" method="post">
	
	帳號<br>
	<input  type="text" name="id"  placeholder="請輸入帳號"><br>
	密碼<br>
	<input type="password" name="password" placeholder="請輸入密碼"><br>
	<input type="submit" value="送出" >
	<label>
		已有帳號
		<a href = "ALogin.jsp">登入頁面</a>
	</label>
	<br>
	
	
<label>
	<%
	String state = (String)session.getAttribute("使用者A1");
	session.removeAttribute("使用者A1");
	if(state != null){
		out.print(state);
	}
	%>

</label>
	
</form>

</body>
</html>