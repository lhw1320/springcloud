package com.qdfae.jdk.codec.base64;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

/**
 * Base64算法
 * 实现方式：Oracle JDK Util
 * 
 * @author hongwei.lian 
 * @date 2018年3月11日 上午1:03:03
 */
public class Base64WithJDK8Util {
	
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
	 * @date 2018年3月11日 上午1:06:06
	 */
	public void encode(String plaintext) {
		Encoder encoder = Base64.getEncoder();
		byte[] encodeByte = encoder.encode(plaintext.getBytes());
		String encode = new String(encodeByte);
		System.out.println(plaintext + "经过Base64算法加密后为：" + encode);
	}
	
    /**
     * * 解密方法
	 * 
	 * @param ciphertext 密文
     * @author hongwei.lian  
     * @date 2018年3月11日 上午1:07:43
     */
	public void decode(String ciphertext) {
		Decoder decoder = Base64.getDecoder();
		byte[] decodeByte = decoder.decode(ciphertext);
		String decode = new String(decodeByte);
		System.out.println(ciphertext + "经过Base64算法解密后为：" + decode);
	}

}
