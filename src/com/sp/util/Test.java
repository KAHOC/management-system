package com.sp.util;

import java.security.NoSuchAlgorithmException;

public class Test {

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException {
		/*测试md5Util加密是否正确*/
		Md5Util mu=new Md5Util();
		String newPwd =mu.getMd5("666666");
		System.out.println(newPwd);
	}

}
