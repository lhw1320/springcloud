package com.qdfae.jdk.codec;

import org.junit.Test;

import com.qdfae.jdk.codec.base64.Base64WithBC;
import com.qdfae.jdk.codec.base64.Base64WithCC;
import com.qdfae.jdk.codec.base64.Base64WithJDK;
import com.qdfae.jdk.codec.base64.Base64WithJDK8Util;

/**
 * Base64算法测试类
 * 
 * @author hongwei.lian 
 * @date 2018年3月11日 上午12:29:24
 */
public class Base64Test {
	
	/**
	 * 测试Base64WithJDK类的encode()方法和decode()方法
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月11日 上午12:32:08
	 */
	@Test
	public void testBase64WithJDK() {
		Base64WithJDK jdk = new Base64WithJDK();
		jdk.encode(Base64WithJDK.PLAINTEXT);//bGlmZSBpcyB3b25kZXJmdWw=
		jdk.decode(Base64WithJDK.CIPHERTEXT);//life is wonderful
	}
	
	/**
	 * 测试Base64WithCC类的encode()方法和decode()方法
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月11日 上午12:42:05
	 */
	@Test
	public void testBase64WithCC() {
		Base64WithCC cc = new Base64WithCC();
		cc.encode(Base64WithCC.PLAINTEXT);//bGlmZSBpcyB3b25kZXJmdWw=
		cc.decode(Base64WithCC.CIPHERTEXT);//life is wonderful
	}
	
	/**
	 * 测试Base64WithBC类的encode()方法和decode()方法
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月11日 上午12:48:02
	 */
	@Test
	public void testBase64WithBC() {
		Base64WithBC cc = new Base64WithBC();
		cc.encode(Base64WithCC.PLAINTEXT);//bGlmZSBpcyB3b25kZXJmdWw=
		cc.decode(Base64WithCC.CIPHERTEXT);//life is wonderful
	}
	
	/**
	 * 测试Base64WithJDKUtil类的encode()方法和decode()方法
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月11日 上午1:08:49
	 */
	@Test
	public void testBase64WithJDK8Util() {
		Base64WithJDK8Util jdkUtil = new Base64WithJDK8Util();
		jdkUtil.encode(Base64WithCC.PLAINTEXT);//bGlmZSBpcyB3b25kZXJmdWw=
		jdkUtil.decode(Base64WithCC.CIPHERTEXT);//life is wonderful
	}

}
