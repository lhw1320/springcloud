package com.qdfae.jdk.codec;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import com.qdfae.jdk.codec.aes.AESUtil;

/**
 * AES算法测试类
 * 
 * @author hongwei.lian 
 * @date 2018年3月17日 下午6:59:05
 */
public class AESTest {
	
	/**
	 * AES加密算法
	 * 实现：JDK
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月17日 下午6:59:55
	 */
	@Test
	public void testAesWithJDK() {
		byte[] keyByte = AESUtil.initKeyByJDK();
		String keyString = Base64.encodeBase64String(keyByte);
		System.out.println("密钥：" + keyString);
		byte[] encryptDataByte = AESUtil.aesEncrypt(AESUtil.PLAINTEXT.getBytes(), keyByte);
		String encryptDataString = Base64.encodeBase64String(encryptDataByte);
		System.out.println("经过AES-JDK算法加密后为：" + encryptDataString);
		byte[] decryptDataByte = AESUtil.aesDecrypt(encryptDataByte, keyByte);
		String decryptDataString = new String(decryptDataByte);
		System.out.println("经过AES-JDK算法解密后为：" + decryptDataString);
	}
	
    /**
     * AES加密算法
	 * 实现：BC
     *  
     * @author hongwei.lian  
     * @date 2018年3月17日 下午6:59:42
     */
	@Test
	public void testAesWithBC() {
		byte[] keyByte = AESUtil.initKeyByBC();
		String keyString = Base64.encodeBase64String(keyByte);
		System.out.println("密钥：" + keyString);
		byte[] encryptDataByte = AESUtil.aesEncrypt(AESUtil.PLAINTEXT.getBytes(), keyByte);
		String encryptDataString = Base64.encodeBase64String(encryptDataByte);
		System.out.println("经过AES-BC算法加密后为：" + encryptDataString);
		byte[] decryptDataByte = AESUtil.aesDecrypt(encryptDataByte, keyByte);
		String decryptDataString = new String(decryptDataByte);
		System.out.println("经过AES-BC算法解密后为：" + decryptDataString);
	}

}
