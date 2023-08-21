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
 * Servlet implementation class SetRoomServlet
 */
@WebServlet("/SetRoomServlet")
public class SetRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetRoomServlet() {
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
		String room = request.getParameter("room");
		//設置房間
		boolean a = StudentDao.setRoom(room);
		
		if(a==true) {
			//完成
			request.getSession().setAttribute("排序狀態", "排序完成");
			response.sendRedirect("ASetRoom.jsp");	
			
		}else {
			//失敗
			request.getSession().setAttribute("排序狀態", "排序失敗");
			response.sendRedirect("ASetRoom.jsp");	
			
		}
	
	
	}

}
