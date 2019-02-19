package com.sp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sp.dao.Tb_questionsDao;
import com.sp.entity.Tb_questions;
import com.sp.services.Tb_managerServices;
import com.sp.services.Tb_questionsServices;

public class Tb_questionsServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Tb_questionsServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String f=request.getParameter("f");
		if(f.equals("show")){
			show(request,response);
		}
		if(f.equals("del")){
			del(request,response);
		}
		if(f.equals("detail")){
			detail(request,response);
		}
		if(f.equals("refact")){
			refact(request,response);
		}
	}

	private void refact(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		String title=request.getParameter("title");
		String subject=request.getParameter("subject");
		String optionA=request.getParameter("optionA");
		String optionB=request.getParameter("optionB");
		String optionC=request.getParameter("optionC");
		String optionD=request.getParameter("optionD");
		String answer=request.getParameter("answer");
		String[] answers=request.getParameterValues("answers");
		String note=request.getParameter("note");
//		String answerA=request.getParameter("answerA");
//		String answerB=request.getParameter("answerB");
//		String answerC=request.getParameter("answerC");
//		String answerD=request.getParameter("answerD");
		String a="";
		

		
		 if(answers.length>0)
         {
          for(int j=0;j<answers.length;j++)
          {
          
           if(j==answers.length-1){
        	   a=a+answers[j];
           }else{
        	   a=a+answers[j]+","; 
           }
          }
          //a=a.substring(0, a.length()-1);
         }
         System.out.print(a);
         
         
		
		/*String[] ans = answer.split(",");
		for (String s : ans) {
			services.delById(s); //Ñ­»·É¾³ý
		}*/
		
		
		Tb_questionsServices services = new Tb_questionsServices();
		
		boolean flag= services.refactById(id,subject,title,optionA,optionB,optionC,optionD,answer,a,note);
		
		if(flag){
			out.print("<script>alert('×´Ì¬¸üÐÂ³É¹¦!');window.location='Tb_questionsServlet?f=show';</script>");
		}
		else{
			out.print("<script>alert('Ê§°Ü!');window.location='Tb_questionsServlet?f=show';</script>");
		}

	
	}

	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException  {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		
		Tb_questionsServices services = new Tb_questionsServices();
		List<Tb_questions> tbq=services.detailById(id);
		
		
		session.setAttribute("tbq", tbq);
		response.sendRedirect("detail.jsp");
	}

	/*private void refact(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		int id=Integer.parseInt("request.getParameter('id')");
		Tb_questionsServices services = new Tb_questionsServices();
		services
		
	}*/

	private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		//Integer.parseInt("request.getParameter('id')")
		String id=request.getParameter("id");
		Tb_questionsServices services = new Tb_questionsServices();
		String[] tNo = id.split(",");
		for (String s : tNo) {
			services.delById(s); //Ñ­»·É¾³ý
		}
		//services.delById(id);
		
		Tb_questionsServices service = new Tb_questionsServices();
		List<Tb_questions> tbq=service.getQuestions();
		session.setAttribute("tbq", tbq);
		response.sendRedirect("questions.jsp");
		
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		Tb_questionsServices services = new Tb_questionsServices();
		List<Tb_questions> tbq=services.getQuestions();
		
		session.setAttribute("tbq", tbq);
		response.sendRedirect("questions.jsp");
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
