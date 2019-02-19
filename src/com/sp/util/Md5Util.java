package com.sp.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 此类用于对字符串进行MD5加密
 * @author Administrator
 *
 */
public class Md5Util {
	
	
	
	/*得到指定字符串的MD5加密后的字符串*/
	public String getMd5(String pwd){
		
		
		MessageDigest md=null;
		try {
			md = MessageDigest.getInstance("md5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}//获取一个指定加密算法为md5的 MessageDigest 对象
		byte[] pwdBytes = pwd.getBytes(); //获取密码的byte[]数组表现形式
		md.update(pwdBytes); //更新密码
		byte[] newPwdBytes= md.digest();  //生成摘要		
		
		return byteArrayToHex(newPwdBytes);   //将生成的新的字节数组转换为String类型返回
	}
	
	
	/**
	 * 下面方法用于将byte[]数组转换为字符串
	 * @param byteArray
	 * @return
	 */
	public String byteArrayToHex(byte[] byteArray) {
		 
	      // 首先初始化一个字符数组，用来存放每个16进制字符
	 
	      char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };	 
	 
	      // new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
	 
	      char[] resultCharArray =new char[byteArray.length * 2];
	 
	 
	      // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
	 
	      int index = 0;
	 
	      for (byte b : byteArray) {
	 
	         resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];
	 
	         resultCharArray[index++] = hexDigits[b& 0xf];
	 
	      }
	 
	      // 字符数组组合成字符串返回	 
	      return new String(resultCharArray);
	}
}
