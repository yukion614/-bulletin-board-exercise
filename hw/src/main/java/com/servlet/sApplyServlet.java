//508170636 李佳欣 508170507 賴永宏
package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.dao.AdminDao;
import com.dao.StudentDao;

/**
 * Servlet implementation class sApplyServlet

 */
@WebServlet("/sApplyServlet")
public class sApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sApplyServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//取得現在時間
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String time  = dtf.format(LocalDateTime.now());
		//取得標單資訊
		String room = request.getParameter("room");
		String id = request.getParameter("sid");
		//申請房間
		boolean a = StudentDao.setApplyRoom(id, room ,time );
		System.out.print("a="+a);
		if(a==true) {
			//成功
			request.getSession().setAttribute("s", "申請成功");
			response.sendRedirect("StudentApply.jsp");	
			
		}else {
			//失敗
			request.getSession().setAttribute("s", "申請失敗");
			response.sendRedirect("StudentApply.jsp");	

		}
		 
	}

}
