package com.qdfae.jdk.codec.base64;

import org.bouncycastle.util.encoders.Base64;

/**
 * Base64算法
 * 实现方式：Bouncy Castle
 * 
 * @author hongwei.lian 
 * @date 2018年3月11日 上午12:43:09
 */
public class Base64WithBC {
	
	/**
	 * 明文
	 */
	public static final String PLAINTEXT = "life is wonderful";
	
	/**
	 * 密文（与明文对应）
	 */
	public static final String CIPHERTEXT = "bGlmZSBpcyB3b25kZXJmdWw=";
	
	/**
	 * 加密方法
	 * 
	 * @param plaintext 明文
	 * @author hongwei.lian  
	 * @date 2018年3月11日 上午12:46:27
	 */
	public void encode(String plaintext) {
		byte[] encodeByte = Base64.encode(plaintext.getBytes());
		String encode = new String(encodeByte);
		System.out.println(plaintext + "经过Base64算法加密后为：" + encode);
	}
	
    /**
     * * 解密方法
	 * 
	 * @param ciphertext 密文
     * @author hongwei.lian  
     * @date 2018年3月11日 上午12:46:54
     */
	public void decode(String ciphertext) {
		byte[] decodeByte = Base64.decode(ciphertext);
		String decode = new String(decodeByte);
		System.out.println(ciphertext + "经过Base64算法解密后为：" + decode);
	}

}
