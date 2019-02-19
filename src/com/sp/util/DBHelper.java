package com.sp.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



public class DBHelper {
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;
	
	//从资源文件properties中获取驱动、连接字符串、用户名和密码
	static{
		Properties pro = new Properties();
		InputStream is = DBHelper.class.getClassLoader().getResourceAsStream("mysqljdbc.properties");//获取一个流对象
		try {
			pro.load(is);  //加载流对象
			driverClass = pro.getProperty("driverClass");//获取资源文件中的driverClass
			url = pro.getProperty("url");
			username = pro.getProperty("username");
			password = pro.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//获取连接对象
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName(driverClass);      //1.加载驱动
			conn = DriverManager.getConnection(url, username, password);  //获取连接对象
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//关闭连接对象
	public static void closeConn(ResultSet rs,PreparedStatement pstmt,Connection conn){
		try{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
}
