//508170636 李佳欣 508170507 賴永宏
package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDao;
import com.dao.StudentDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/sLoginServlet")
public class sLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sLoginServlet() {
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
		String userid = request.getParameter("id");
		String password = request.getParameter("password");
		//學生登入
		boolean a = StudentDao.login(userid, password);
	
		if(a==true) {
			//登入成功
			//設置session 名稱帳號
			request.getSession().setAttribute("當前登入者帳戶", userid);
			String name  = StudentDao.getSID(userid);
			request.getSession().setAttribute("當前登入者姓名", name );
			response.sendRedirect("sIndex.jsp");	
		}else {
			//登入失敗
			request.getSession().setAttribute("使用者A2", "登入失敗");
			response.sendRedirect("sLogin.jsp");	

		}
	}

}
