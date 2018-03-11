package com.qdfae.jdk.codec.md;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * MD算法
 * 
 * @author hongwei.lian 
 * @date 2018年3月11日 上午11:39:59
 */
public class MDUtil {
	
	/**
	 * 明文
	 */
	public static final String PLAINTEXT = "life is wonderful";
	
	/**
	 * 构造方法私有化
	 */
	private MDUtil() {}
	
	/**
	 * MD5加密方法
	 * 实现：JDK
	 * 
	 * @param plaintext 明文
	 * @author hongwei.lian  
	 * @date 2018年3月11日 上午11:43:19
	 */
	public static void md5WithJDK(String plaintext) {
		String digestString = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] digestByte = md.digest(plaintext.getBytes());
			digestString = Hex.encodeHexString(digestByte);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(plaintext + "经过MD5-JDK算法加密后为：" + digestString);
	}
	
	/**
	 * MD2加密方法
	 * 实现：JDK
	 * 
	 * @param plaintext 
	 * @author hongwei.lian  
	 * @date 2018年3月11日 上午11:50:19
	 */
	public static void md2WithJDK(String plaintext) {
		String digestString = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD2");
			byte[] digestByte = md.digest(plaintext.getBytes());
			digestString = Hex.encodeHexString(digestByte);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(plaintext + "经过MD2-JDK算法加密后为：" + digestString);
	}
	
	/**
	 * MD5加密方法
	 * 实现：Bouncy Castle
	 * 
	 * @param plaintext 
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午12:08:32
	 */
	public static void md5WithBC(String plaintext) {
		Digest digest = new MD5Digest();
		digest.update(plaintext.getBytes(), 0, plaintext.getBytes().length);
		byte[] digestByte = new byte[digest.getDigestSize()];
		digest.doFinal(digestByte, 0);
		String digestString = org.bouncycastle.util.encoders.Hex.toHexString(digestByte);		
		System.out.println(plaintext + "经过MD5-BC算法加密后为：" + digestString);
	}
	
	/**
	 * MD2加密方法
	 * 实现：Bouncy Castle
	 * 
	 * @param plaintext 
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午12:08:12
	 */
	public static void md2WithBC(String plaintext) {
		Digest digest = new MD2Digest();
		digest.update(plaintext.getBytes(), 0, plaintext.getBytes().length);
		byte[] digestByte = new byte[digest.getDigestSize()];
		digest.doFinal(digestByte, 0);
		String digestString = org.bouncycastle.util.encoders.Hex.toHexString(digestByte);		
		System.out.println(plaintext + "经过MD2-BC算法加密后为：" + digestString);
	}
	
	/**
	 * MD4加密方法
	 * 实现：Bouncy Castle
	 * 
	 * 直接使用
	 * 
	 * @param plaintext 
	 * @author hongwei.lian  
	 * @date 2018年3月11日 上午11:50:58
	 */
	public static void md4WithBC(String plaintext) {
		Digest digest = new MD4Digest();
		digest.update(plaintext.getBytes(), 0, plaintext.getBytes().length);
		byte[] digestByte = new byte[digest.getDigestSize()];
		digest.doFinal(digestByte, 0);
		String digestString = org.bouncycastle.util.encoders.Hex.toHexString(digestByte);		
		System.out.println(plaintext + "经过MD4-BC算法加密后为：" + digestString);
	}
	
	/**
	 * MD4加密方法
	 * 实现：Bouncy Castle
	 * 
	 * 调用方式
	 * 
	 * @param plaintext 
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午12:14:35
	 */
	public static void md4WithBCByCall(String plaintext) {
		Security.addProvider(new BouncyCastleProvider());
		String digestString = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD4");
			//MessageDigest md = MessageDigest.getInstance("MD4", "BC");
			System.out.println("MessageDigest提供商为：" + md.getProvider());//上述两者的提供商都为Bouncy Castle
			byte[] digestByte = md.digest(plaintext.getBytes());
			digestString = org.bouncycastle.util.encoders.Hex.toHexString(digestByte);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(plaintext + "经过MD4-BC算法加密后为：" + digestString);
	}
	
	/**
	 * MD5加密方法
	 * 实现：Commons Codec
	 * 
	 * @param plaintext 明文
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午12:54:12
	 */
	public static void md5WithCC(String plaintext) {
		String digestString = DigestUtils.md5Hex(plaintext);
		System.out.println(plaintext + "经过MD5-CC算法加密后为：" + digestString);
	}
	

    /**
     * MD5加密方法
	 * 实现：Commons Codec
	 * 
     * @param plaintext 明文
     * @author hongwei.lian  
     * @date 2018年3月11日 下午12:55:45
     */
    public static void md2WithCC(String plaintext) {
    	String digestString = DigestUtils.md2Hex(plaintext);
		System.out.println(plaintext + "经过MD2-CC算法加密后为：" + digestString);
	}
	
}
