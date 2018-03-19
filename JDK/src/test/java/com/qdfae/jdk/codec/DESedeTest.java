package com.qdfae.jdk.codec;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import com.qdfae.jdk.codec.des.DESedeUtil;

/**
 * DESede算法测试类
 * 
 * @author hongwei.lian 
 * @date 2018年3月17日 下午6:36:43
 */
public class DESedeTest {
	
	/**
	 * DES加密算法
	 * 实现：JDK
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月17日 下午6:37:26
	 */
	@Test
	public void testDesedeWithJDK() {
		byte[] keyByte = DESedeUtil.initKeyByJDK();
		String keyString = Base64.encodeBase64String(keyByte);
		System.out.println("密钥：" + keyString);
		byte[] encryptDataByte = DESedeUtil.desedeEncryptWithJDK(DESedeUtil.PLAINTEXT.getBytes(), keyByte);
		String encryptDataString = Base64.encodeBase64String(encryptDataByte);
		System.out.println("经过DESede-JDK算法加密后为：" + encryptDataString);
		byte[] decryptDataByte = DESedeUtil.desedeDecryptWithJDK(encryptDataByte, keyByte);
		String decryptDataString = new String(decryptDataByte);
		System.out.println("经过DESede-JDK算法解密后为：" + decryptDataString);
	}
	
	/**
	 * DES加密算法
	 * 实现：BC
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月17日 下午6:37:16
	 */
	@Test
	public void testDesedeWithBC() {
		byte[] keyByte = DESedeUtil.initKeyByBC();
		String keyString = Base64.encodeBase64String(keyByte);
		System.out.println("密钥：" + keyString);
		byte[] encryptDataByte = DESedeUtil.desedeEncryptWithJDK(DESedeUtil.PLAINTEXT.getBytes(), keyByte);
		String encryptDataString = Base64.encodeBase64String(encryptDataByte);
		System.out.println("经过DESede-BC算法加密后为：" + encryptDataString);
		byte[] decryptDataByte = DESedeUtil.desedeDecryptWithJDK(encryptDataByte, keyByte);
		String decryptDataString = new String(decryptDataByte);
		System.out.println("经过DESede-BC算法解密后为：" + decryptDataString);
	}

}
