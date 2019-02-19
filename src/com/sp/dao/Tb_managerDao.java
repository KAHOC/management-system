package com.sp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sp.entity.Tb_manager;
import com.sp.util.DBHelper;

public class Tb_managerDao {
	/**
	 * 登录方法
	 * @param manName
	 * @param pwd
	 * @return
	 */
	public Tb_manager Login(String manName,String pwd){
		Tb_manager manager = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn=DBHelper.getConn(); //获取相关资源
			pstmt = conn.prepareStatement("select * from tb_manager where manName=? and pwd=?");
			//设置参数
			pstmt.setString(1, manName);
			pstmt.setString(2, pwd);
			rs=pstmt.executeQuery();//执行查询
			if(rs.next()){
				manager = new Tb_manager();
				manager.setId(rs.getInt("id"));
				manager.setManName(rs.getString("manName"));
				manager.setPwd(rs.getString("pwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBHelper.closeConn(rs, pstmt, conn);//关闭相关资源
		}
		
		return manager;
			
	}
	public List<Tb_manager> ManagerList(){
		List<Tb_manager> mlist = new ArrayList<Tb_manager>();
		Connection conn = null;  //获取连接对象
		PreparedStatement pstmt = null;
		try{
			conn = DBHelper.getConn();//获取连接对象
			pstmt = conn.prepareStatement("select * from tb_manager");			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Tb_manager man = new Tb_manager();
				man.setId(rs.getInt("id"));
				man.setManName(rs.getString("manName"));
				mlist.add(man);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			DBHelper.closeConn(null, pstmt, conn); //关闭资源
		}
		
		
		return mlist;
	}
	@SuppressWarnings("null")
	public Tb_manager getManForId(int id){
		Tb_manager man = null;
		Connection conn = null;  //获取连接对象
		PreparedStatement pstmt = null;
		try{
			conn = DBHelper.getConn();//获取连接对象
			pstmt = conn.prepareStatement("select * from tb_manager where id=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				man=new Tb_manager();
				man.setId(rs.getInt("id"));
				man.setManName(rs.getString("manName"));
				man.setPwd(rs.getString("pwd"));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			DBHelper.closeConn(null, pstmt, conn); //关闭资源
		}
		return man;
	}
	public boolean updateMan(int id,String manName,String pwd){
		boolean flag = false;
		Connection conn = null;  //获取连接对象
		PreparedStatement pstmt = null;
		try{
			conn = DBHelper.getConn();//获取连接对象
			pstmt = conn.prepareStatement("update tb_manager set manName=?,pwd=? where id=?");
			//设置参数的值
			pstmt.setString(1, manName);//第1个？的值
			pstmt.setString(2, pwd);
			pstmt.setInt(3,id);  //第3个?号的值
			int n = pstmt.executeUpdate();
			if(n>0){
				flag = true;
			}
		}catch(Exception ex){
			
		}
		finally{
			DBHelper.closeConn(null, pstmt, conn); //关闭资源
		}
		return flag;
	}
}
