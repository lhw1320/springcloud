package com.qdfae.jdk.codec.aes;

import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * AES加密算法工具类
 * 
 * @author hongwei.lian 
 * @date 2018年3月17日 下午6:51:29
 */
public class AESUtil {
	
	/**
	 * 明文
	 */
	public static final String PLAINTEXT = "life is wonderful";
	
	/**
	 * AES加密算法
	 */
	public static final String KEY_ALGORITHM = "AES";
	
	/**
	 * 加密/解密算法/工作模式/填充方式
	 */
	public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
	
	/**
	 * 构造方法私有化
	 */
	private AESUtil() {}
	
	/**
	 * 生成二进制密钥
	 * 实现：JDK
	 * 
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年3月17日 下午6:54:24
	 */
	public static byte[] initKeyByJDK() {
		byte[] key = null;
		try {
			//-- 实例化密钥生成器
			KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
			System.out.println("AES算法提供商：" + keyGenerator.getProvider());
			//-- 初始化密钥生成器
			keyGenerator.init(256);
			//-- 生成密钥
			SecretKey secretKey = keyGenerator.generateKey();
			//-- 获取密钥的二进制编码形式
			key = secretKey.getEncoded();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key; 
	}
	
	/**
	 * 生成二进制密钥
	 * 实现：BC
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年3月17日 下午6:55:22
	 */
	public static byte[] initKeyByBC() {
		byte[] key = null;
		try {
			//-- 添加BC提供商
			Security.addProvider(new BouncyCastleProvider());
			//-- 实例化密钥生成器
			KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM, "BC");
			System.out.println("AES算法提供商：" + keyGenerator.getProvider());
			//-- 初始化密钥生成器
			//-- 根据不同的加密算法生成默认长度的密钥
			//keyGenerator.init(new SecureRandom());
			keyGenerator.init(256);
			//-- 生成密钥
			SecretKey secretKey = keyGenerator.generateKey();
			//-- 获取密钥的二进制编码形式
			key = secretKey.getEncoded();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key; 
	}
	
    /**
     * 转换密钥
     * 
     * @param key 二进制密钥
     * @return 
     * @author hongwei.lian  
     * @date 2018年3月17日 下午6:56:17
     */
	public static Key toKey(byte[] key) {
		Key secretKey = null;
		try {
			secretKey = new SecretKeySpec(key, KEY_ALGORITHM);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return secretKey;
	}
	
	/**
	 * 加密方法
	 * 
	 * @param data 待加密数据
	 * @param key 密钥
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年3月17日 下午6:33:27
	 */
	public static byte[] aesEncrypt(byte[] data, byte[] key) {
		byte[] encryptData = null;
	    try {
	    	//-- 还原密钥
			Key k = toKey(key);
	    	//-- 实例化
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			//-- 初始化，设置加密模式
			cipher.init(Cipher.ENCRYPT_MODE, k);
			//-- 执行加密操作
			encryptData = cipher.doFinal(data);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return encryptData;
	}
	
	/**
	 * 解密方法
	 * 
	 * @param data 待解密数据
	 * @param key 密钥
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年3月17日 下午6:33:51
	 */
	public static byte[] aesDecrypt(byte[] data, byte[] key) {
		byte[] decryptData = null;
	    try {
	    	//-- 还原密钥
			Key k = toKey(key);
	    	//-- 实例化
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			//-- 初始化，设置解密模式
			cipher.init(Cipher.DECRYPT_MODE, k);
			//-- 执行解密操作
			decryptData = cipher.doFinal(data);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return decryptData;
	}

}
