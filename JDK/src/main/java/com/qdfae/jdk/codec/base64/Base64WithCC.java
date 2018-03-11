package com.qdfae.jdk.codec.base64;

import org.apache.commons.codec.binary.Base64;

/**
 * Base64算法
 * 实现方式：Commons Codec
 * 
 * @author hongwei.lian 
 * @date 2018年3月11日 上午12:35:32
 */
public class Base64WithCC {
	
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
	 * @date 2018年3月11日 上午12:39:11
	 */
	public void encode(String plaintext) {
		byte[] encodeByte = Base64.encodeBase64(plaintext.getBytes());
		String encode = new String(encodeByte);
		System.out.println(plaintext + "经过Base64算法加密后为：" + encode);
	}
	
    /**
     * * 解密方法
	 * 
	 * @param ciphertext 密文
     * @author hongwei.lian  
     * @date 2018年3月11日 上午12:39:47
     */
	public void decode(String ciphertext) {
		byte[] decodeByte = Base64.decodeBase64(ciphertext);
		String decode = new String(decodeByte);
		System.out.println(ciphertext + "经过Base64算法解密后为：" + decode);
	}

}
