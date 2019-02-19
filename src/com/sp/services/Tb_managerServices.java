package com.sp.services;

import java.security.NoSuchAlgorithmException;

import com.sp.dao.Tb_managerDao;
import com.sp.entity.Tb_manager;
import com.sp.util.Md5Util;

public class Tb_managerServices {
	/**
	 * 登录方法
	 * @param manName
	 * @param pwd
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public Tb_manager Login(String manName,String pwd) {
		//先调用util包中的MD5Util类对密码进行加密
		Md5Util mu = new Md5Util();
		String newPwd = mu.getMd5(pwd);
		//调用dao层的方法登录
		Tb_managerDao dao = new Tb_managerDao();
		return dao.Login(manName, newPwd);
		
	}
}
