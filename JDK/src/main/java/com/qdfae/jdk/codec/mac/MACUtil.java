package com.qdfae.jdk.codec.mac;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

/**
 * MAC算法
 * 
 * @author hongwei.lian 
 * @date 2018年3月11日 下午3:41:21
 */
public class MACUtil {
	
	/**
	 * 明文
	 */
	public static final String PLAINTEXT = "life is wonderful";
	
	/**
	 * 构造方法私有化
	 */
	private MACUtil() {}
	
	/**
	 * HmacMD5算法加密方法
	 * 实现：JDK
	 * 
	 * @param plaintext 明文
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午3:42:44
	 */
	public static void hmacMD5WithJDK(String plaintext) {
		String digestString = null;
		try {
			//-- 使用HmacMD5初始化密钥生成器
			KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
		    //-- 产生密钥
			SecretKey secretKey = keyGenerator.generateKey();
		    //-- 获取密钥
		    byte[] key = secretKey.getEncoded();
		    System.out.println(key);
		    
		    //-- 还原密钥
		    SecretKey restoreSecretKey = new SecretKeySpec("aaaaaaaaaa".getBytes(), "HmacMD5");
		    
		    //-- 实例化MAC
		    Mac mac = Mac.getInstance(restoreSecretKey.getAlgorithm());
		    //-- 初始化MAC
		    mac.init(restoreSecretKey);
			//-- 进行消息摘要
		    byte[] digestByte = mac.doFinal(plaintext.getBytes());
		    digestString = Hex.encodeHexString(digestByte);
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (InvalidKeyException e2) {
			e2.printStackTrace();
		}
		System.out.println(plaintext + "经过HmacMD5-JDK算法加密后为：" + digestString);
	}
	
	/**
	 * HmacMD5算法加密方法
	 * 实现：Bouncy Castle
	 * 
	 * @param plaintext 明文
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午4:03:12
	 */
	public static void hmacMD5WithBC(String plaintext) { 
		HMac mac = new HMac(new MD5Digest());
		mac.init(new KeyParameter("aaaaaaaaaa".getBytes()));
		mac.update(plaintext.getBytes(), 0, plaintext.getBytes().length);
		byte[] digestByte = new byte[mac.getMacSize()];
		mac.doFinal(digestByte, 0);
		String digestString = org.bouncycastle.util.encoders.Hex.toHexString(digestByte);
		System.out.println(plaintext + "经过HmacMD5-BC算法加密后为：" + digestString);
	}

}
