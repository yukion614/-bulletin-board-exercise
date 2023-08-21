<!--508170636 李佳欣 508170507 賴永宏-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>學生註冊</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div>
<h3>學生註冊</h3>
<hr>
<form class="form-horizontal" action="sRegistServlet" method="post" >
	帳號<br>
	<input type="text" name="id"  placeholder="請輸入帳號"><br>
	姓名<br>
	<input type="text" name="name"  placeholder="請輸入姓名"><br>
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
	<label>
	已有帳號
	<a href = "sLogin.jsp">登入</a>
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