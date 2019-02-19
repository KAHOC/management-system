package com.sp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sp.entity.Tb_manager;
import com.sp.entity.Tb_student;
import com.sp.util.DBHelper;

public class Tb_studentDao {

	public List<Tb_student> StudentList(){
		List<Tb_student> slist = new ArrayList<Tb_student>();
		Connection conn = null;  //获取连接对象
		PreparedStatement pstmt = null;
		try{
			conn = DBHelper.getConn();//获取连接对象
			pstmt = conn.prepareStatement("select * from tb_student");		
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Tb_student stu = new Tb_student();
				stu.setId(rs.getString("id"));
				stu.setAnswer(rs.getString("answer"));
				stu.setName(rs.getString("name"));
				stu.setSex(rs.getString("sex"));
				stu.setJoinTime(rs.getString("joinTime"));
				stu.setProferrsion(rs.getString("proferrsion"));
				stu.setQuestion(rs.getString("question"));
				stu.setCardNo(rs.getString("cardNo"));
				slist.add(stu);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			DBHelper.closeConn(null, pstmt, conn); //关闭资源
		}
		
		
		return slist;
	}
	public boolean deleteStuInfo(String id){
		boolean flag=false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBHelper.getConn();  //获取连接
			pstmt = conn.prepareStatement("delete from tb_student where id=?");
			//设置参数
			pstmt.setString(1, id);			
			//开始执行
			int n = pstmt.executeUpdate();
			if(n>0){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConn(null, pstmt, conn); // 关闭资源
		}
		
		
		return flag;
	}
	
}
