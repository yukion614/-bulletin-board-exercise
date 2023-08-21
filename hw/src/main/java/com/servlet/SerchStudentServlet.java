//508170636 李佳欣 508170507 賴永宏
package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;

/**
 * Servlet implementation class SerchStudentServlet
 */
@WebServlet("/SerchStudentServlet")
public class SerchStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerchStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//抓取表單
		String userid = request.getParameter("sid");
		//執行搜尋
		ArrayList a = StudentDao.getLikeList(userid);
		if(a != null) {
			//有該位學生
			request.getSession().setAttribute("該學生","該學生資訊" );
			request.getSession().setAttribute("該學生資訊", a );
			response.sendRedirect("ASerchStudent.jsp");	
			
		}else {
			//沒有該位學生
			request.getSession().setAttribute("該學生", "查無該學生");
			response.sendRedirect("ASerchStudent.jsp");	
			
		}
	}

}
