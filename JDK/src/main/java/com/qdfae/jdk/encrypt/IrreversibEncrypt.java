package com.qdfae.jdk.encrypt;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import com.springcryptoutils.core.digest.Digester;
import com.springcryptoutils.core.digest.DigesterImpl;

/**
 * 不可逆加密
 *
 * @author hongwei.lian
 * @date 2018年6月19日 下午7:51:01
 */
public class IrreversibEncrypt {

	public enum AlgorithmType{
		MD5,SHA;
	}
	
	public static Digester getInstance(AlgorithmType algorithmType,DigesterImpl.OutputMode outputMode){
		DigesterImpl digesterImpl = new DigesterImpl();
		if(algorithmType != null)
			digesterImpl.setAlgorithm(algorithmType.name());
		if(outputMode != null)
			digesterImpl.setOutputMode(outputMode);
		try {
			digesterImpl.afterPropertiesSet();
			return digesterImpl;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 
	 * md5加密
	 * @return String
	 * @author wenqiang
	 * 2015年5月21日 下午2:58:45
	 */
	public static String MD5Encrypt(String message){
		Digester md5Digester = getInstance(AlgorithmType.MD5, DigesterImpl.OutputMode.HEX);
		if(md5Digester == null)
			return null;
		return md5Digester.digest(message);
	}
	
	/**
	 * md5加密
	 * @return byte[]
	 * @author wenqiang
	 * 2015年5月21日 下午3:03:39
	 */
	public static byte[] MD5Encrypt(byte[] message){
		Digester md5Digester = getInstance(AlgorithmType.MD5, DigesterImpl.OutputMode.HEX);
		if(md5Digester == null)
			return null;
		return md5Digester.digest(message);
	}
	
	/**
	 * 获取通过md5加密后的16位信息
	 * @param str
	 * @return
	 */
	public static String get16MD5String(String str) {
		String s = MD5Encrypt(str);
		if(s!=null && s.length()==32){
			return s.substring(8, 24);
		}else{
			return null;
		}
	}
	
	/**
	 * sha加密
	 * @return String
	 * @author wenqiang
	 * 2015年5月21日 下午3:06:09
	 */
	public static String SHAEncrypt(String message){
		Digester shaDigester = getInstance(AlgorithmType.SHA, DigesterImpl.OutputMode.HEX);
		if(shaDigester == null)
			return null;
		return shaDigester.digest(message);
	}
	
	/**
	 * sha加密
	 * @return byte[]
	 * @author wenqiang
	 * 2015年5月21日 下午3:06:28
	 */
	public static byte[] SHAEncrypt(byte[] message){
		Digester shaDigester = getInstance(AlgorithmType.SHA, DigesterImpl.OutputMode.HEX);
		if(shaDigester == null)
			return null;
		return shaDigester.digest(message);
	}
	
	public static void main(String[] args) {
		String str = "wenqiang";
		System.out.println(">>>>>>>MD5:"+MD5Encrypt(str));
		System.out.println(">>>>>>>SHA:"+SHAEncrypt(str));
	}
	
}
