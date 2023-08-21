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
 * Servlet implementation class RegistServlet
 */
@WebServlet("/sRegistServlet")
public class sRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sRegistServlet() {
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
		//取得表單
		String sID = request.getParameter("id");
		String sName = request.getParameter("name");
		String sPassword = request.getParameter("password");
		String sGender = request.getParameter("gender");
		String sEmail = request.getParameter("email");
		String sTel = request.getParameter("tel");
		String sMeno = request.getParameter("MEMO");
		//學生註冊
		boolean a = StudentDao.regist(sID, sName, sPassword, sGender, sEmail, sTel, sMeno);

		if(a==true) {
			//註冊成功 設定session
			request.getSession().setAttribute("使用者A2", "註冊帳號成功,請前往登入頁面");
			response.sendRedirect("sRegister.jsp");	
			
		}else {
			//註冊失敗 設定session
			request.getSession().setAttribute("使用者A2", "註冊帳號失敗");
			response.sendRedirect("sRegister.jsp");	
			
		}
	}

}
