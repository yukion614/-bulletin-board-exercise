//508170636 李佳欣 508170507 賴永宏
package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDao;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/ARegistServlet")
public class ARegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ARegistServlet() {
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
		String username = request.getParameter("id");
		String password = request.getParameter("password");
		//註冊帳號
		boolean a = AdminDao.regist(username, password);
		if(a==true) {
			//註冊成功
			request.getSession().setAttribute("使用者A1", "註冊帳號成功,請前往登入頁面");
			response.sendRedirect("ARegister.jsp");	
		}else {
			//註冊失敗
			request.getSession().setAttribute("使用者A1", "註冊帳號失敗");
			response.sendRedirect("ARegister.jsp");	
		}
	}

}
