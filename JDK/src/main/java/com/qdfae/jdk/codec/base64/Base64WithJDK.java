//package com.qdfae.jdk.codec.base64;
//
//import java.io.IOException;
//
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
//
///**
// * Base64算法
// * 实现方式：Oracle JDK
// * 
// * @author hongwei.lian 
// * @date 2018年3月10日 下午10:36:49
// */
//public class Base64WithJDK {
//	
//	/**
//	 * 明文
//	 */
//	public static final String PLAINTEXT = "life is wonderful";
//	
//	/**
//	 * 密文（与明文对应）
//	 */
//	public static final String CIPHERTEXT = "bGlmZSBpcyB3b25kZXJmdWw=";
//	
//	/**
//	 * 加密方法
//	 * 
//	 * @param plaintext 明文
//	 * @author hongwei.lian  
//	 * @date 2018年3月11日 上午12:25:16
//	 */
//	public void encode(String plaintext) {
//		BASE64Encoder encoder = new BASE64Encoder();
//		String encode = encoder.encode(plaintext.getBytes());
//		System.out.println(plaintext + "经过Base64算法加密后为：" + encode);
//	}
//	
//	/**
//	 * 解密方法
//	 * 
//	 * @param ciphertext 密文
//	 * @author hongwei.lian  
//	 * @date 2018年3月11日 上午12:25:07
//	 */
//	public void decode(String ciphertext) {
//		BASE64Decoder decoder = new BASE64Decoder();
//		String decode = null;
//		try {
//			byte[] decodeByte = decoder.decodeBuffer(ciphertext);
//			decode = new String(decodeByte);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println(ciphertext + "经过Base64算法解密后为：" + decode);
//	}
//	
//}
