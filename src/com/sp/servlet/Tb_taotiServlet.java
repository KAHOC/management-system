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
import com.sp.dao.Tb_taotiDao;
import com.sp.entity.Tb_lesson;
import com.sp.entity.Tb_taoti;

public class Tb_taotiServlet extends HttpServlet {

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
			String f = request.getParameter("f");
			if(f.equals("list")){ 
				Taolist(request,response);
			}else if(f.equals("del")){
				Taodel(request,response);
			}else if(f.equals("update")){
				TaoUpdate(request, response);
			}else if(f.equals("sel")){
				TaoSel(request, response);	
			}
	}

	private void TaoSel(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id =request.getParameter("id"); 
		Tb_taotiDao tdao = new Tb_taotiDao();
		Tb_lessonDao ldao = new Tb_lessonDao();
		List<Tb_lesson> lesName = new ArrayList<Tb_lesson>();
		Tb_taoti taoti1 = new Tb_taoti();
		lesName=ldao.LessonName();
		request.setAttribute("lesName", lesName); 
		taoti1 = tdao.TaotiSel(id);
		request.setAttribute("taoti1", taoti1); 
		request.getRequestDispatcher("taotiList.jsp").forward(request, response);//请求转发到jsp页面
	}

	private void Taodel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Tb_taotiDao tdao = new Tb_taotiDao();
		String id = request.getParameter("id"); 
		String[] tid = id.split(",");
		for (String s : tid) {
			tdao.deletelesInfo(s);  //循环删除
			out.print("<script>alert('删除成功');window.location='taoti.jsp';</script>");
		}
		
//		Taolist(request,response);
	}

	private void Taolist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		Tb_taotiDao ldao = new Tb_taotiDao();
		List<Tb_taoti> daolist = new ArrayList<Tb_taoti>();
		daolist=ldao.TaoList();
		request.setAttribute("daolist", daolist); 
		request.getRequestDispatcher("taoti.jsp").forward(request, response);//请求转发到jsp页面
	}
	private void TaoUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Tb_taotiDao tdao = new Tb_taotiDao();
		String name = request.getParameter("lesName");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("_______________________"+name);
		tdao.taotiUpdata(name, id); 
		out.print("<script>alert('修改成功');</script>");
		Taolist(request,response);
	}
}

