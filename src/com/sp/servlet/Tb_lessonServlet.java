package com.sp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.dao.Tb_lessonDao;
import com.sp.dao.Tb_studentDao;
import com.sp.entity.Tb_lesson;
import com.sp.entity.Tb_student;

public class Tb_lessonServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		//  HttpSession session = request.getSession();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();	
			String f = request.getParameter("f");
			if(f.equals("list")){  //登录
				Leslist(request,response);
			}else if(f.equals("del")){
				Lesdel(request,response);
			}
	}

	private void Lesdel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		// TODO Auto-generated method stub
		Tb_lessonDao ldao = new Tb_lessonDao();
		String id = request.getParameter("id"); 
		String[] tid = id.split(",");
		for (String s : tid) {
			ldao.deletelesInfo(s);  //循环删除
		}
		
		Leslist(request,response);
	}
	

	private void Leslist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Tb_lessonDao ldao = new Tb_lessonDao();
		List<Tb_lesson> leslist = new ArrayList<Tb_lesson>();
		leslist=ldao.LessonList();
		request.setAttribute("leslist", leslist); 
		request.getRequestDispatcher("Lesson.jsp").forward(request, response);//请求转发到jsp页面
	}

}
