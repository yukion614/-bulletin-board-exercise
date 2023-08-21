<!--508170636 李佳欣 508170507 賴永宏-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="com.bean.StudentBean" %>
<%@ page import="java.util.*" %>
<%@ page import=" com.dao.StudentDao" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公佈欄</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<label>
		<%
		String state = (String)session.getAttribute("ss");
		session.removeAttribute("ss");
		if(state != null){
			out.print(state);
		}
		%>
	</label >
<div>公佈欄</div>
<!--表格  -->
<table id="table" border="1">
    <thead>
        <tr>
            <td>學號</td>
            <td>姓名</td>
            <td>性別</td>
            <td>房號</td>
        </tr>
    </thead>
	<tbody>

<%
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");
//抓取公佈欄
ArrayList a = StudentDao.getBillboard();
if(a!=null){	
	for(int i =0;i < a.size() ; i++){
		StudentBean student = (StudentBean) a.get(i);
		//讀取學生資訊
%>
	
		<tr>
            <td><%=student.getsID() %></td>
            <td><%=student.getsName() %></td>
            <td><%=student.getGender() %></td>
            <td><%=student.getsRoom() %></td>
        </tr>
<%
	}	
}

%>
	</tbody>
</table>



	
</body>
</html>