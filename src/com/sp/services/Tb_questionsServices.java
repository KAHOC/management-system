package com.sp.services;

import java.util.List;

import com.sp.dao.Tb_questionsDao;
import com.sp.entity.Tb_questions;

public class Tb_questionsServices {
	public List<Tb_questions> getQuestions(){
		Tb_questionsDao qdao=new Tb_questionsDao();
		List<Tb_questions> tbq=qdao.getQuestions();
		return tbq;
		
	}
	public boolean delById(String id){
		
		Tb_questionsDao dao=new Tb_questionsDao();
		dao.delById(id);
		return true;
	}
	/*public boolean refactById(int id){
		Tb_questionsDao dao=new Tb_questionsDao();
		dao.refactById(id);
	}*/
	public List<Tb_questions> detailById(int id){
		Tb_questionsDao qdao=new Tb_questionsDao();
		List<Tb_questions> tbq=qdao.detailById(id);
		return tbq;
		
	}
	
	public boolean refactById(int id,String subject,String title,String optionA,String optionB,String optionC,String optionD,String answer,String a,String note){
		
		Tb_questionsDao dao=new Tb_questionsDao();
		boolean f =dao.refactById(id,subject,title,optionA,optionB,optionC,optionD,answer,a,note);
		return f;
	}
	
}
