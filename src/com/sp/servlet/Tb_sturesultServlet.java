package com.sp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.dao.Tb_sturesultDao;
import com.sp.entity.Tb_sturesult;

public class Tb_sturesultServlet extends HttpServlet {

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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();		
		String f = request.getParameter("f");
		if(f.equals("list")){  //查看数据
			Sturlist(request,response);
		}else if(f.equals("select")){
			SelectSturesult(request,response);
			
		}
		
	}

	private void SelectSturesult(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String type = request.getParameter("seltype");
		String value = request.getParameter("select");
		System.out.println(type+","+value);
		Tb_sturesultDao rdao = new Tb_sturesultDao();
		List<Tb_sturesult> srlist = new  ArrayList<Tb_sturesult>();
		srlist = rdao.SturesultSel(type, value);
		request.setAttribute("srlist", srlist); 
		request.getRequestDispatcher("Sturesult.jsp").forward(request, response);//请求转发到jsp页面
	}

	private void Sturlist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		Tb_sturesultDao rdao = new Tb_sturesultDao();
		List<Tb_sturesult> srlist = new  ArrayList<Tb_sturesult>();
		srlist = rdao.SturesultList();
		request.setAttribute("srlist", srlist); 
		request.getRequestDispatcher("Sturesult.jsp").forward(request, response);//请求转发到jsp页面
	}

}
