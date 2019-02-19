package com.sp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.sp.dao.Tb_managerDao;
import com.sp.entity.Tb_manager;
import com.sp.services.Tb_managerServices;
import com.sp.util.Md5Util;

public class Tb_managerServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();		
		String f = request.getParameter("f");
		if(f.equals("login")){  //登录
			login(request,response);
		}
		else if(f.equals("exit")){  //退出
			System.out.println("exit");
			session.removeAttribute("manager"); // 清除session中的manager
			//response.sendRedirect("Login.jsp");
			out.print("<script>window.location.href='Login.jsp';</script>");
		}else if(f.equals("list")){
			ManagerList(request,response);
			
		}else if (f.equals("select")){
			SelectById(request,response);
			
		}else if(f.equals("updata")){
			ManagerUpdata(request,response);
			
		}
		
		
		out.flush();
		out.close();
	}
	private void ManagerUpdata(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		Tb_managerDao mdao = new Tb_managerDao();
		int id = Integer.parseInt(request.getParameter("id"));
		String manName = request.getParameter("manName"); //获取登录名
		String opwd = request.getParameter("opwd");  //密码
		String opwd2 = request.getParameter("pwdo"); 
		String npwd = request.getParameter("npwd"); 
		String npwd2 = request.getParameter("npwd2"); 
		Md5Util mu = new Md5Util();
		String md5opwd = mu.getMd5(opwd);
		if(!opwd2.equalsIgnoreCase(md5opwd)){
			
			Tb_manager man = mdao.getManForId(id);//根据编号查询
			session.setAttribute("man", man);//将查询的单个对象放入到作用域 中
			out.print("<script>alert('旧密码有误');window.open('ManagerUpda.jsp','Mainindex');</script>");
			//request.getRequestDispatcher("ManagerUpda.jsp").forward(request, response);
		}else if(!npwd.equalsIgnoreCase(npwd2)){
			
			Tb_manager man = mdao.getManForId(id);//根据编号查询
			session.setAttribute("man", man);//将查询的单个对象放入到作用域 中
			out.print("<script>alert('确认密码不正确');;window.open('ManagerUpda.jsp','Mainindex');</script>");
			//request.getRequestDispatcher("ManagerUpda.jsp").forward(request, response);
		}else{
			
			String md5npwd = mu.getMd5(npwd);
			boolean flag = mdao.updateMan(id, manName, md5npwd);
			
			if(flag){
				out.print("<script>alert('修改成功');</script>");
				ManagerList(request, response);
			}
			out.print("<script>alert('修改失败');</script>");
		}
	}

	private void SelectById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Tb_managerDao mdao = new Tb_managerDao();
		Tb_manager man = mdao.getManForId(id);//根据编号查询
		request.setAttribute("man", man);//将查询的单个对象放入到作用域 中
		
		request.getRequestDispatcher("ManagerUpda.jsp").forward(request, response);
		
	}

	private void ManagerList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Tb_managerDao mdao = new Tb_managerDao();
		List<Tb_manager> mlist = new ArrayList<Tb_manager>();
		mlist = mdao.ManagerList();
		request.setAttribute("mlist", mlist); // 将查询到集合对象放入到作用域 中
		request.getRequestDispatcher("Manager.jsp").forward(request, response);//请求转发到Manager.jsp页面
		
	}

	/**
	 * 登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String manName = request.getParameter("txtManName"); //获取登录名
		String pwd = request.getParameter("txtPwd");  //密码
		//调用services层的登录方法
		Tb_managerServices services = new Tb_managerServices();
		Tb_manager manager = services.Login(manName, pwd);
		if(manager!=null){
			//out.print("<script>alert('登录成功');</script>");
			//登录成功，将用户信息放入到session中
			session.setAttribute("manager", manager);
			response.sendRedirect("Index.jsp");
		}
		else{
			out.print("<script>alert('失败');</script>");
		}
	}
}
