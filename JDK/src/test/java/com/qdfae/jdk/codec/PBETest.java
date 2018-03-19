package com.qdfae.jdk.codec;

import java.security.Key;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import com.qdfae.jdk.codec.pbe.PBEUtil;

/**
 * PBE加密算法测试类
 * 
 * @author hongwei.lian 
 * @date 2018年3月17日 下午10:39:42
 */
public class PBETest {
	
    /**
     * PBE加密算法
     * 实现：JDK
     *  
     * @author hongwei.lian  
     * @date 2018年3月17日 下午10:42:14
     */
	@Test
	public void testPbeWithJDK() {
		byte[] saltByte = PBEUtil.initSalt();
		String saltString = Base64.encodeBase64String(saltByte);
		System.out.println("盐：" + saltString);
		String password = PBEUtil.PASSWORD;
		System.out.println("密码：" + password);
		Key key = PBEUtil.toKeyByJDK(password);
		byte[] keyByte = key.getEncoded();
		String keyString = Base64.encodeBase64String(keyByte);
		System.out.println("通过密码转换后的密钥：" + keyString);
		byte[] encryptDataByte = PBEUtil.pbeEncrypt(PBEUtil.PLAINTEXT.getBytes(), key, saltByte);
		String encryptDataString = Base64.encodeBase64String(encryptDataByte);
		System.out.println("经过PBE-JDK算法加密后为：" + encryptDataString);
		byte[] decryptDataByte = PBEUtil.pbeDecrypt(encryptDataByte, key, saltByte);
		String decryptDataString = new String(decryptDataByte);
		System.out.println("经过PBE-JDK算法解密后为：" + decryptDataString);
	}
	
	/**
	 * PBE加密算法
     * 实现：BC
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月17日 下午11:13:14
	 */
	@Test
	public void testPbeWithBC() {
		byte[] saltByte = PBEUtil.initSalt();
		String saltString = Base64.encodeBase64String(saltByte);
		System.out.println("盐：" + saltString);
		String password = PBEUtil.PASSWORD;
		System.out.println("密码：" + password);
		Key key = PBEUtil.toKeyByBC(password);
		byte[] keyByte = key.getEncoded();
		String keyString = Base64.encodeBase64String(keyByte);
		System.out.println("通过密码转换后的密钥：" + keyString);
		byte[] encryptDataByte = PBEUtil.pbeEncrypt(PBEUtil.PLAINTEXT.getBytes(), key, saltByte);
		String encryptDataString = Base64.encodeBase64String(encryptDataByte);
		System.out.println("经过PBE-BC算法加密后为：" + encryptDataString);
		byte[] decryptDataByte = PBEUtil.pbeDecrypt(encryptDataByte, key, saltByte);
		String decryptDataString = new String(decryptDataByte);
		System.out.println("经过PBE-BC算法解密后为：" + decryptDataString);
	}
	
}
