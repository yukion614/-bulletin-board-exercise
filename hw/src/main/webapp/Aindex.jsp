<!--508170636 李佳欣 508170507 賴永宏-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理員頁面</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background:red;">

<ul style="display:inline;">
	<li style="display:inline;"><a href="Aindex.jsp">公佈欄</a></li>
    <li style="display:inline;"><a href="ASetRoom.jsp">編排房間</a></li>
    <li style="display:inline;"><a href="ASerchStudent.jsp">查找學生資料</a></li>

</ul>

<jsp:include page="Billboard.jsp"></jsp:include>



</body>
</html>