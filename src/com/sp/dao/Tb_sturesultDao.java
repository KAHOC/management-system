package com.sp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sp.entity.Tb_lesson;
import com.sp.entity.Tb_student;
import com.sp.entity.Tb_sturesult;
import com.sp.util.DBHelper;

public class Tb_sturesultDao {
	public List<Tb_sturesult> SturesultList(){
		List<Tb_sturesult> srlist = new ArrayList<Tb_sturesult>();
		Connection conn = null;  //获取连接对象
		PreparedStatement pstmt = null;
		try{
			conn = DBHelper.getConn();//获取连接对象
			pstmt = conn.prepareStatement("select stuId,name,resSingle,resMore,resTotal,tb_sturesult.joinTime from tb_sturesult,tb_lesson where tb_sturesult.whichLesson=tb_lesson.id");		
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Tb_sturesult stur = new Tb_sturesult();
				Tb_lesson les = new Tb_lesson();
				les.setName(rs.getString("name"));
				
				stur.setStuId(rs.getString("stuId"));
				stur.setResSingle(rs.getInt("resSingle"));
				stur.setResMore(rs.getInt("resMore"));
				stur.setResTotal(rs.getInt("resTotal"));
				stur.setJoinTime(rs.getString("tb_sturesult.joinTime"));
				stur.setLson(les);
				srlist.add(stur);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			DBHelper.closeConn(null, pstmt, conn); //关闭资源
		}
		return srlist;
	}
	public List<Tb_sturesult> SturesultSel(String type,String value){
		List<Tb_sturesult> srlist = new ArrayList<Tb_sturesult>();
		Connection conn = null;  //获取连接对象
		PreparedStatement pstmt = null;
		String sql = "select stuId,name,resSingle,resMore,resTotal,tb_sturesult.joinTime from tb_sturesult,tb_lesson where tb_sturesult.whichLesson=tb_lesson.id";
		try{
			conn = DBHelper.getConn();//获取连接对象
			if(!value.equals("")){
				if(type.equals("1"))
				sql+=  " and stuId like '%"+value +"%'";		
				if(type.equals("2"))
				sql+=  " and name like '%"+value +"%'";				
				if(type.equals("3"))
				sql+=  " and tb_sturesult.joinTime like '%"+value +"%'";			
			}
			pstmt = conn.prepareStatement(sql);	
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Tb_sturesult stur = new Tb_sturesult();
				Tb_lesson les = new Tb_lesson();
				les.setName(rs.getString("name"));
				
				stur.setStuId(rs.getString("stuId"));
				stur.setResSingle(rs.getInt("resSingle"));
				stur.setResMore(rs.getInt("resMore"));
				stur.setResTotal(rs.getInt("resTotal"));
				stur.setJoinTime(rs.getString("tb_sturesult.joinTime"));
				stur.setLson(les);
				srlist.add(stur);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			DBHelper.closeConn(null, pstmt, conn); //关闭资源
		}
		return srlist;
	}
}
