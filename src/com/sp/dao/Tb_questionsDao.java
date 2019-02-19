package com.sp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sp.entity.Tb_lesson;
import com.sp.entity.Tb_manager;
import com.sp.entity.Tb_questions;
import com.sp.entity.Tb_taoti;
import com.sp.util.DBHelper;

public class Tb_questionsDao {
	public List<Tb_questions> getQuestions(){
		List<Tb_questions> tbqs=new ArrayList<Tb_questions>();
		
		PreparedStatement pstmt = null;
		String sql ="select tb_lesson.name,tb_taoti.name,tb_questions.id,subject,type,optionA,optionB,optionC,optionD,answer,note from tb_lesson,tb_taoti,tb_questions where Tb_questions.lessonId=tb_lesson.id and Tb_questions.taoTiId=tb_taoti.id and tb_taoti.lessonId=tb_lesson.id";
		Connection conn = DBHelper.getConn(); //获取连接
		
		
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();  //执行
			while(rs.next()){
				Tb_lesson tbl=new Tb_lesson();
				tbl.setName(rs.getString("tb_lesson.name"));
				
				Tb_taoti tbt=new Tb_taoti();
				tbt.setName(rs.getString("tb_taoti.name"));
				
				Tb_questions tbqts=new Tb_questions();
				tbqts.setId(rs.getInt("id"));
				
				
				tbqts.setSubject(rs.getString("subject"));
				tbqts.setType(rs.getString("type"));
				tbqts.setOptionA(rs.getString("optionA"));
				tbqts.setOptionB(rs.getString("optionB"));
				tbqts.setOptionC(rs.getString("optionC"));
				tbqts.setOptionD(rs.getString("optionD"));
				tbqts.setAnswer(rs.getString("answer"));
				tbqts.setNote(rs.getString("note"));
				tbqts.setTbl(tbl);
				tbqts.setTbt(tbt);
				
				tbqs.add(tbqts);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBHelper.closeConn(rs, pstmt, conn);
		}
		return tbqs;

	}
	public boolean delById(String id){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBHelper.getConn();  //获取连接
			pstmt = conn.prepareStatement("delete from tb_questions where id=?");
			//设置参数
			pstmt.setString(1, id);			
			//开始执行
			int n = pstmt.executeUpdate();
			if(n>0){
				flag = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBHelper.closeConn(null, pstmt, conn);
		}
		return flag;
	}
	
	public boolean refactById(int id, String title, String subject,
			String optionA, String optionB, String optionC, String optionD,
			String answer, String a, String note) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBHelper.getConn();  //获取连接
			pstmt = conn.prepareStatement("update tb_questions set subject=?,type=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=?,note=? where id=?");
			//设置参数
			//System.out.println(title);
			pstmt.setString(1, subject);
			pstmt.setString(2, title);	
			pstmt.setString(3, optionA);
			pstmt.setString(4, optionB);
			pstmt.setString(5, optionC);
			pstmt.setString(6, optionD);
			if(title.equals("多选题")){
				pstmt.setString(7, a);
			}else if(title.equals("单选题")){
				pstmt.setString(7, answer);
			}
			
			pstmt.setString(8, note);
			pstmt.setInt(9, id);
			//开始执行
			
			int n = pstmt.executeUpdate();
			if(n>0){
				flag = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBHelper.closeConn(null, pstmt, conn);
		}
		return flag;
	}
	
	public List<Tb_questions> detailById(int id){
		List<Tb_questions> tbqs=new ArrayList<Tb_questions>();
		
		PreparedStatement pstmt = null;
		String sql ="select tb_lesson.name,tb_taoti.name,tb_questions.id,subject,type,optionA,optionB,optionC,optionD,answer,note from tb_lesson,tb_taoti,tb_questions where Tb_questions.lessonId=tb_lesson.id and Tb_questions.taoTiId=tb_taoti.id and tb_taoti.lessonId=tb_lesson.id and Tb_questions.id=?";
		Connection conn = DBHelper.getConn(); //获取连接
		
		
		ResultSet rs = null;
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);	
			rs = pstmt.executeQuery();  //执行
			while(rs.next()){
				Tb_lesson tbl=new Tb_lesson();
				tbl.setName(rs.getString("tb_lesson.name"));
				
				Tb_taoti tbt=new Tb_taoti();
				tbt.setName(rs.getString("tb_taoti.name"));
				
				Tb_questions tbqts=new Tb_questions();
				tbqts.setId(rs.getInt("id"));
				tbqts.setSubject(rs.getString("subject"));
				tbqts.setType(rs.getString("type"));
				tbqts.setOptionA(rs.getString("optionA"));
				tbqts.setOptionB(rs.getString("optionB"));
				tbqts.setOptionC(rs.getString("optionC"));
				tbqts.setOptionD(rs.getString("optionD"));
				tbqts.setAnswer(rs.getString("answer"));
				
				String[] ans = rs.getString("answer").split(","); //把标准答案按逗号分割
				for (String s : ans) {
					if(s.equals("A")){
						tbqts.setAnswerA(true);
					}
					if(s.equals("B")){
						tbqts.setAnswerB(true);
					}
					if(s.equals("C")){
						tbqts.setAnswerC(true);
					}
					if(s.equals("D")){
						tbqts.setAnswerD(true);
					}
				}
				
				tbqts.setNote(rs.getString("note"));
				tbqts.setTbl(tbl);
				tbqts.setTbt(tbt);
				
				tbqs.add(tbqts);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBHelper.closeConn(rs, pstmt, conn);
		}
		return tbqs;

	}
	/*public boolean refactById(int id){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
	}*/
	
}
