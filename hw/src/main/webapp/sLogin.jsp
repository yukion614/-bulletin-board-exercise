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
<div class="container">

<h3>登入頁面</h3>
<hr>
<form  class="form-horizontal" action="sLoginServlet" method="post">
	<input type="text" name="id"><br>
	<input type="text" name="password"><br>
	<input type="submit" value="登入">
	<label>
	未有帳號
	<a href = "sRegister.jsp">註冊</a>
	</label>
		
		
	<label>
		<%
		String state = (String)session.getAttribute("使用者A2");
		session.removeAttribute("使用者A2");
		if(state != null){
			out.print(state);	
		}
		%>
	</label>

</form>
</div>

</body>
</html>