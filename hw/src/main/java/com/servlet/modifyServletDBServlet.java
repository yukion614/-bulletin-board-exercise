//508170636 李佳欣 508170507 賴永宏
package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;

/**
 * Servlet implementation class modifyServletDBServlet
 */
@WebServlet("/modifyServletDBServlet")
public class modifyServletDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyServletDBServlet() {
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
		//修改頁抓取資料
		String sID = request.getParameter("id");
		String sPassword = request.getParameter("password");
		String sGender = request.getParameter("gender");
		String sEmail = request.getParameter("email");
		String sTel = request.getParameter("tel");
		String sMEMO = request.getParameter("MEMO");
		
		//執行修改
		boolean a = StudentDao.modify(sID, sPassword, sGender, sEmail, sTel,sMEMO);
		
	
		if(a==true) {
			//修改成功
			request.getSession().setAttribute("使用者修改", "資料已修改");
			response.sendRedirect("studentModify.jsp");	
		
		}else {
			//修改失敗
			request.getSession().setAttribute("使用者修改", "輸入資料有錯誤");
			response.sendRedirect("studentModify.jsp");	
			
		}
		
	}

}
