package com.qdfae.jdk.codec;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import com.qdfae.jdk.codec.des.DESUtil;

/**
 * DES加密算法测试类
 * 
 * @author hongwei.lian 
 * @date 2018年3月17日 下午5:22:54
 */
public class DESTest {
	
	/**
	 * DES加密算法
	 * 实现：JDK
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月17日 下午5:24:02
	 */
	@Test
	public void testDesWithJDK() {
		byte[] keyByte = DESUtil.initKeyByJDK();
		String keyString = Base64.encodeBase64String(keyByte);
		System.out.println("密钥：" + keyString);
		byte[] encryptDataByte = DESUtil.desEncryptWithJDK(DESUtil.PLAINTEXT.getBytes(), keyByte);
		String encryptDataString = Base64.encodeBase64String(encryptDataByte);
		System.out.println("经过DES-JDK算法加密后为：" + encryptDataString);
		byte[] decryptDataByte = DESUtil.desDecryptWithJDK(encryptDataByte, keyByte);
		String decryptDataString = new String(decryptDataByte);
		System.out.println("经过DES-JDK算法解密后为：" + decryptDataString);
	}
	
	/**
	 * DES加密算法
	 * 实现：BC
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月17日 下午5:24:15
	 */
	@Test
	public void testDesWithBC() {
		byte[] keyByte = DESUtil.initKeyByBC();
		String keyString = Base64.encodeBase64String(keyByte);
		System.out.println("密钥：" + keyString);
		byte[] encryptDataByte = DESUtil.desEncryptWithJDK(DESUtil.PLAINTEXT.getBytes(), keyByte);
		String encryptDataString = Base64.encodeBase64String(encryptDataByte);
		System.out.println("经过DES-JDK算法加密后为：" + encryptDataString);
		byte[] decryptDataByte = DESUtil.desDecryptWithJDK(encryptDataByte, keyByte);
		String decryptDataString = new String(decryptDataByte);
		System.out.println("经过DES-JDK算法解密后为：" + decryptDataString);
	}

}
