package com.qdfae.jdk.codec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;

import com.qdfae.jdk.codec.md.MDUtil;

/**
 * MD算法测试类
 * 
 * @author hongwei.lian 
 * @date 2018年3月11日 上午11:54:04
 */
public class MDTest {
	
	/**
	 * MD5加密方法
	 * 实现：JDK
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月11日 上午11:54:46
	 */
	@Test
	public void testMd5WithJDK() {
		MDUtil.md5WithJDK(MDUtil.PLAINTEXT);
	}
	
	/**
	 * MD2加密方法
	 * 实现：JDK
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月11日 上午11:56:45
	 */
	@Test
	public void testMd2WithJDK() {
		MDUtil.md2WithJDK(MDUtil.PLAINTEXT);
	}
	
	/**
	 * MD5加密方法
	 * 实现：Bouncy Castle
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午12:11:54
	 */
	@Test
	public void testMd5WithBC() {
		MDUtil.md5WithBC(MDUtil.PLAINTEXT);
	}
	
	/**
	 * MD2加密方法
	 * 实现：Bouncy Castle
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午12:11:58
	 */
	@Test
	public void testMd2WithBC() {
		MDUtil.md2WithBC(MDUtil.PLAINTEXT);
	}
	
	/**
	 * MD4加密方法
	 * 实现：Bouncy Castle
	 * 
	 * 直接使用
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月11日 上午11:56:59
	 */
	@Test
	public void testMd4WithBC() {
		MDUtil.md4WithBC(MDUtil.PLAINTEXT);
	}
	
	/**
	 * MD4加密方法
	 * 实现：Bouncy Castle
	 * 
	 * 调用方式
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午12:22:18
	 */
	@Test
	public void testMd4WithBCByCall() {
		MDUtil.md4WithBCByCall(MDUtil.PLAINTEXT);
	}
	
	/**
	 * 提供商
	 * 
	 * 如果是JDK实现过的MD算法，即使添加了第三方提供商
	 * 但是无显式指出使用哪一种提供商，那么提供商是SUN version 1.8
	 * 比如：MD5、MD2
	 * MessageDigest.getInstance("MD5")
	 * 如果显式指出使用提供商，那么提供商就是它
	 * MessageDigest.getInstance("MD5", "BC")
	 * 
	 * 如果是JDK没有实现的MD算法，并且添加了第三方提供商
	 * 没有显式指出使用哪一种提供商，那么提供商是第三方提供商比如：BC version 1.54
	 * 比如：MD4
	 * MessageDigest.getInstance("MD4")
	 * 如果显式指出使用提供商，那么提供商是就是它。
	 * MessageDigest.getInstance("MD4", "BC")
	 * 
	 * 结论：不指定提供商的情况下，提供商添加的先后顺序会决定使用哪一种实现方式
	 *           即后面添加的不会生效。
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午12:30:28
	 */
	@Test
	public void testProvider() {
		Security.addProvider(new BouncyCastleProvider());
		Provider provider = null;
		try {
			//MessageDigest md = MessageDigest.getInstance("MD5");
			MessageDigest md = MessageDigest.getInstance("MD5", "BC");
			provider = md.getProvider();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}
		System.out.println(provider);
	}
	
	/**
	 * MD5加密方法
	 *  实现：Commons Codec封装JDK的实现
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午12:56:48
	 */
	@Test
	public void testMd5WithCC() {
		MDUtil.md5WithCC(MDUtil.PLAINTEXT);
	}
	
	/**
	 * MD2加密方法
	 * 实现：Commons Codec封装JDK的实现
	 * 
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午12:56:52
	 */
	@Test
	public void testMd2WithCC() {
		MDUtil.md2WithCC(MDUtil.PLAINTEXT);
	}

}
