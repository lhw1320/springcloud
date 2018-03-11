package com.qdfae.jdk.codec.sha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * SHA算法
 * 
 * @author hongwei.lian 
 * @date 2018年3月11日 下午2:48:17
 */
public class SHAUtil {
	
	/**
	 * 明文
	 */
	public static final String PLAINTEXT = "life is wonderful";
	
	/**
	 * 构造方法私有化
	 */
	private SHAUtil() {}
	
	/**
	 * SHA1加密方法
	 * 实现：JDK
	 * 
	 * @param plaintext 明文
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午2:50:04
	 */
	public static void sha1WithJDK(String plaintext) {
		String digestString = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			md.update(plaintext.getBytes());
			byte[] digestByte = md.digest();
			digestString = Hex.encodeHexString(digestByte);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(plaintext + "经过SHA1-JDK算法加密后为：" + digestString);
	}
	
	/**
	 * SHA1加密方法
	 * 实现：Bouncy Castle
	 * 
	 * @param plaintext 明文
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午3:01:22
	 */
	public static void sha1WithBC(String plaintext) {
		String digestString = null;
		Digest digest = new SHA1Digest();
		digest.update(plaintext.getBytes(), 0, plaintext.getBytes().length);
		byte[] digestByte = new byte[digest.getDigestSize()];
		digest.doFinal(digestByte, 0);
		digestString = org.bouncycastle.util.encoders.Hex.toHexString(digestByte);
		System.out.println(plaintext + "经过SHA1-BC算法加密后为：" + digestString);
	}
	
	/**
	 * SHA224加密方法
	 * 实现：Bouncy Castle
	 * 
	 * 直接使用
	 * 
	 * @param plaintext 明文
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午3:03:43
	 */
	public static void sha224WithBC(String plaintext) {
		String digestString = null;
		Digest digest = new SHA224Digest();
		digest.update(plaintext.getBytes(), 0, plaintext.getBytes().length);
		byte[] digestByte = new byte[digest.getDigestSize()];
		digest.doFinal(digestByte, 0);
		digestString = org.bouncycastle.util.encoders.Hex.toHexString(digestByte);
		System.out.println(plaintext + "经过SHA224-BC算法加密后为：" + digestString);
	}
	
	/**
	 * SHA224加密方法
	 * 实现：Bouncy Castle
	 * 
	 * 调用方式
	 * 
	 * @param plaintext 明文
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午3:07:33
	 */
	public static void sha224WithBCByCall(String plaintext) {
		Security.addProvider(new BouncyCastleProvider());
		String digestString = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA224");
			byte[] digestByte = md.digest(plaintext.getBytes());
			digestString = Hex.encodeHexString(digestByte);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(plaintext + "经过SHA224-BC算法加密后为：" + digestString);
	}
	
	/**
	 * SHA1加密方法
	 * 实现：CC只是对JDK实现SHA1算法进行了简单的封装
	 * 
	 * @param plaintext 明文
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午3:13:32
	 */
	public static void sha1WithCC(String plaintext) {
		String digestString = DigestUtils.sha1Hex(plaintext);
		System.out.println(plaintext + "经过SHA1-CC算法加密后为：" + digestString);
	}

}
