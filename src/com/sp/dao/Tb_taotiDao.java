package com.sp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sp.entity.Tb_lesson;
import com.sp.entity.Tb_taoti;
import com.sp.util.DBHelper;

public class Tb_taotiDao {
		public List<Tb_taoti> TaoList(){
			List<Tb_taoti> taolist = new ArrayList<Tb_taoti>();
			Connection conn = null;  //获取连接对象
			PreparedStatement pstmt = null;
			try{
				conn = DBHelper.getConn();//获取连接对象
				pstmt = conn.prepareStatement("SELECT tb_taoti.name,tb_taoti.id,tb_lesson.name,tb_lesson.joinTime FROM tb_taoti,tb_lesson WHERE tb_taoti.lessonId=tb_lesson.id");		
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					Tb_lesson les = new Tb_lesson();
					les.setName(rs.getString("tb_lesson.name"));
					
					Tb_taoti tao = new Tb_taoti();
					tao.setId(rs.getInt("id"));
					tao.setName(rs.getString("tb_taoti.name"));
					tao.setJoinTime(rs.getString("joinTime"));
					tao.setLes(les);
					taolist.add(tao);
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
			finally{
				DBHelper.closeConn(null, pstmt, conn); //关闭资源
			}
			return taolist;
		}
		public Tb_taoti TaotiSel(String id){
			Connection conn = null;  //获取连接对象
			PreparedStatement pstmt = null;
			Tb_taoti tao1 = new Tb_taoti();
			try {
				conn = DBHelper.getConn();//获取连接对象
				pstmt = conn.prepareStatement("SELECT tb_taoti.name,tb_taoti.id,tb_lesson.name,tb_lesson.joinTime FROM tb_taoti,tb_lesson WHERE tb_taoti.lessonId=tb_lesson.id and tb_taoti.id= ?");
				pstmt.setString(1, id);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
				Tb_lesson les1 = new Tb_lesson();
				les1.setName(rs.getString("tb_lesson.name"));
				
				tao1 = new Tb_taoti();
				tao1.setId(rs.getInt("id"));
				tao1.setName(rs.getString("tb_taoti.name"));
				tao1.setJoinTime(rs.getString("joinTime"));
				tao1.setLes(les1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DBHelper.closeConn(null, pstmt, conn); //关闭资源
			}
			return tao1;
		}
		public boolean deletelesInfo(String id){
			boolean flag=false;
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = DBHelper.getConn();  //获取连接
				pstmt = conn.prepareStatement("delete from tb_taoti where id=?");
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
		public boolean taotiUpdata(String name,int id){
			boolean flag=false;
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = DBHelper.getConn();  //获取连接
				pstmt = conn.prepareStatement("UPDATE tb_taoti SET lessonId = ? WHERE id = ?");
				//设置参数
				pstmt.setString(1, name);		
				pstmt.setInt(2, id);			
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
	

