<!--508170636 李佳欣 508170507 賴永宏-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入頁面</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h3>登入頁面</h3>
<hr>
<form action="ALoginServlet" method="post">
	<input type="text" name="name">
	<input type="text" name="password">
	<input type="submit" value="登入">
	<label>
	未有帳號
	<a href = "ARegister.jsp">註冊</a>
	</label>
	
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