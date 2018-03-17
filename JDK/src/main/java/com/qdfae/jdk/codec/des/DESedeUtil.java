package com.qdfae.jdk.codec.des;

import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * DESede加密算法工具类
 * 
 * @author hongwei.lian 
 * @date 2018年3月17日 下午6:25:52
 */
public class DESedeUtil {
	
	/**
	 * 明文
	 */
	public static final String PLAINTEXT = "life is wonderful";
	
	/**
	 * DESede加密算法
	 * Java只支持112位和168位位密钥
	 * BC支持128位和192位密钥
	 */
	public static final String KEY_ALGORITHM = "DESede";
	
	/**
	 * 加密/解密算法/工作模式/填充方式
	 */
	public static final String CIPHER_ALGORITHM = "DESede/ECB/PKCS5Padding";
	
	/**
	 * 构造方法私有化
	 */
	private DESedeUtil() {}
	
	/**
	 * 生成二进制密钥
	 * 实现：JDK
	 * 
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年3月17日 下午6:33:07
	 */
	public static byte[] initKeyByJDK() {
		byte[] key = null;
		try {
			//-- 实例化密钥生成器
			KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
			System.out.println("DESede算法提供商：" + keyGenerator.getProvider());
			//-- 初始化密钥生成器
			keyGenerator.init(168);
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
	 * 
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年3月17日 下午6:32:50
	 */
	public static byte[] initKeyByBC() {
		byte[] key = null;
		try {
			//-- 添加BC提供商
			Security.addProvider(new BouncyCastleProvider());
			//-- 实例化密钥生成器
			KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM, "BC");
			System.out.println("DESede算法提供商：" + keyGenerator.getProvider());
			//-- 初始化密钥生成器
			//-- 根据不同的加密算法生成默认长度的密钥
			//keyGenerator.init(new SecureRandom());
			keyGenerator.init(192);
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
     * @date 2018年3月17日 下午6:32:27
     */
	public static Key toKey(byte[] key) {
		Key secretKey = null;
		try {
			//-- 实例化DESede密钥材料
			DESedeKeySpec dks = new DESedeKeySpec(key);
			//-- 实例化密钥工厂
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
			//-- 生成密钥对象
			secretKey = keyFactory.generateSecret(dks);
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
	public static byte[] desedeEncryptWithJDK(byte[] data, byte[] key) {
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
	public static byte[] desedeDecryptWithJDK(byte[] data, byte[] key) {
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
