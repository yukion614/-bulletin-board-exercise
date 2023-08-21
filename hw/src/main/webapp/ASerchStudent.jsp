<!--508170636 李佳欣 508170507 賴永宏-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bean.StudentBean" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理員查找學生資料</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background:red;">

<ul style="display:inline;">
	<li style="display:inline;"><a href="Aindex.jsp">公佈欄</a></li>
    <li style="display:inline;"><a href="ASetRoom.jsp">編排房間</a></li>
    <li style="display:inline;"><a href="ASerchStudent.jsp">查找學生資料</a></li>
</ul>
<center>查找學生資料</center>

<form action="SerchStudentServlet" method="post">
	<label for="">輸入學生ID</label>
	<input type="text" name="sid" placeholder="請輸入學生id">
	<input type="submit" value="送出">
</form>	
		
	<label>
		<%
		String state = (String)session.getAttribute("該學生");
		session.removeAttribute("該學生");
		if(state != null){
			out.print("<div>"+ state +"</div>");
		}
		%>
	</label>


<!--表格  -->

<table border="1">
    <thead>
        <tr>
            <td>學生帳號</td>
            <td>學生姓名</td>
            <td>學生性別</td>
            <td>學生信箱</td>
            <td>學生電話</td>
            <td>學生備註</td>
            <td>學生入住房間</td>
            <td>學生申請時間</td>
            <td>學生申請房間</td>
            <td>學生聯絡人</td>
            <td>學生聯絡人電話</td>
        </tr>
    </thead>
	<tbody>
 
<%
ArrayList stumess= (ArrayList) session.getAttribute("該學生資訊");
session.removeAttribute("該學生資訊");	
if(stumess!=null){
	for(int i =0;i < stumess.size() ; i++){
		StudentBean a = (StudentBean) stumess.get(i);

%>
	
		<tr>
            <td><%=a.getsID() %></td>
            <td><%=a.getsName() %></td>
            <td><%=a.getGender() %></td>
            <td><%=a.geteMail() %></td>
            <td><%=a.getsPhone() %></td>
            <td><%=a.getsMemo() %></td>
            <td><%=a.getsRoom() %></td>
            <td><%=a.getStime() %></td>
            <td><%=a.getsTmpRoom() %></td>
            <td><%=a.getsContactP() %></td>
            <td><%=a.getsCPPhone() %></td>
        </tr>
		
		
<%
	}
	
}

%>
	</tbody>
</table>

</body>
</html>