package com.qdfae.jdk.codec.pbe;

import java.security.Key;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * PBE算法工具类
 * 
 * @author hongwei.lian 
 * @date 2018年3月17日 下午10:14:43
 */
public class PBEUtil {
	
	/**
	 * 明文
	 */
	public static final String PLAINTEXT = "life is wonderful";
	
	/**
	 * PBE加密算法
	 */
	public static final String KEY_ALGORITHM = "PBEWITHMD5andDES";
	
	/**
	 * 加密/解密算法/工作模式/填充方式
	 */
	public static final String CIPHER_ALGORITHM = "PBEWITHMD5andDES/CBC/PKCS5Padding";
	
	/**
	 * 迭代次数
	 */
	public static final int ITERATION_COUNT = 100;
	
	/**
	 * 密码
	 */
	public static final String PASSWORD = "hongwei.lian@qdfae.com";
	
	/**
	 * 构造方法私有化
	 */
	private PBEUtil() {}
	
	/**
	 * 初始化盐
	 * 
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年3月17日 下午10:21:53
	 */
	public static byte[] initSalt() {
		//-- 实例化安全随机数
		SecureRandom random = new SecureRandom();
		//-- 产生盐
		byte[] saltByte = random.generateSeed(8);
		return saltByte;
	}
	
	/**
	 * 转换密钥
	 * 实现：JDK
	 * 
	 * @param password 密码
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年3月17日 下午10:23:26
	 */
	public static Key toKeyByJDK(String password) {
		Key secretKey = null;
	    try {
	    	//-- 初始化密钥材料
		    PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
		    //-- 实例化密钥工厂
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
			//-- PBE算法提供商
			System.out.println("PBE算法提供商：" + keyFactory.getProvider());
			//-- 产生密钥
			secretKey = keyFactory.generateSecret(keySpec);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return secretKey;
	}
	
	/**
	 * 转换密钥
	 * 实现：BC
	 * 
	 * @param password 密码
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年3月17日 下午11:09:59
	 */
	public static Key toKeyByBC(String password) {
		Key secretKey = null;
	    try {
	    	//-- 提供商
	    	Security.addProvider(new BouncyCastleProvider());
	    	//-- 初始化密钥材料
		    PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
		    //-- 实例化密钥工厂
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM, "BC");
			//-- PBE算法提供商
			System.out.println("PBE算法提供商：" + keyFactory.getProvider());
			//-- 产生密钥
			secretKey = keyFactory.generateSecret(keySpec);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return secretKey;
	}
	
	/**
	 * 加密方法
	 * 
	 * @param data 待加密数据
	 * @param Key 通过密码转换的密钥
	 * @param salt 盐
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年3月17日 下午10:31:56
	 */
	public static byte[] pbeEncrypt(byte[] data, Key key, byte[] salt) {
		byte[] encryptByte = null;
		try {
			//-- 实例化PBE参数
			PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, ITERATION_COUNT);
			//-- 实例化
			Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
			//-- 初始化
			cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);
			//-- 执行加密操作
			encryptByte = cipher.doFinal(data);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return encryptByte;
	}
	
	/**
	 * 解密方法
	 * 
	 * @param data 待解密数据
	 * @param key 通过密码转换的密钥
	 * @param salt 盐
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年3月17日 下午10:37:54
	 */
	public static byte[] pbeDecrypt(byte[] data, Key key, byte[] salt) {
		byte[] decryptByte = null;
		try {
			//-- 实例化PBE参数
			PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, ITERATION_COUNT);
			//-- 实例化
			Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
			//-- 初始化
			cipher.init(Cipher.DECRYPT_MODE, key, parameterSpec);
			//-- 执行解密操作
			decryptByte = cipher.doFinal(data);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return decryptByte;
	}
	
	/**
	 * 加密方法
	 * 实现：BC
	 * 
	 * @param data 待加密数据
	 * @param password 密码
	 * @param salt 盐
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年3月17日 下午11:01:08
	 */
	public static byte[] pbeEncryptWithBC(byte[] data, String password, byte[] salt) {
		byte[] encryptByte = null;
		try {
			//-- 转换密钥
			Key key = toKeyByBC(password);
			//-- 实例化PBE参数
			PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, ITERATION_COUNT);
			//-- 实例化
			Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
			//-- 初始化
			cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);
			//-- 执行加密操作
			encryptByte = cipher.doFinal(data);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return encryptByte;
	}
	
	/**
	 * 解密方法
	 * 实现：BC
	 * 
	 * @param data 待解密数据
	 * @param password 密码
	 * @param salt 盐
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年3月17日 下午11:00:39
	 */
	public static byte[] pbeDecryptWithBC(byte[] data, String password, byte[] salt) {
		byte[] decryptByte = null;
		try {
			//-- 转换密钥
			Key key = toKeyByBC(password);
			//-- 实例化PBE参数
			PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, ITERATION_COUNT);
			//-- 实例化
			Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
			//-- 初始化
			cipher.init(Cipher.DECRYPT_MODE, key, parameterSpec);
			//-- 执行解密操作
			decryptByte = cipher.doFinal(data);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return decryptByte;
	}

}
