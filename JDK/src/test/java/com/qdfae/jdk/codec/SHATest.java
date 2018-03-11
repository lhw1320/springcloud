package com.qdfae.jdk.codec;

import org.junit.Test;

import com.qdfae.jdk.codec.sha.SHAUtil;

/**
 * SHA算法测试类
 * 
 * @author hongwei.lian 
 * @date 2018年3月11日 下午2:54:30
 */
public class SHATest {
	
	/**
	 * SHA1加密方法
	 * 实现：JDK
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午2:55:07
	 */
	@Test
	public void testSha1WithJDK() {
		SHAUtil.sha1WithJDK(SHAUtil.PLAINTEXT);
	}
	
	/**
	 * SHA1加密方法
	 * 实现：Bouncy Castle
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午3:04:33
	 */
	@Test
	public void testSha1WithBC() {
		SHAUtil.sha1WithBC(SHAUtil.PLAINTEXT);
	}
	
	/**
	 * SHA224加密方法
	 * 实现：Bouncy Castle
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午3:05:26
	 */
	@Test
	public void testSha224WithBC() {
		SHAUtil.sha224WithBC(SHAUtil.PLAINTEXT);
	}
	
	/**
	 * SHA224加密方法
	 * 实现：Bouncy Castle
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午3:05:26
	 */
	@Test
	public void testSha224WithBCByCall() {
		SHAUtil.sha224WithBCByCall(SHAUtil.PLAINTEXT);
	}
	
	/**
	 * SHA1加密方法
	 * 实现：CC只是对JDK实现SHA1算法做了简单的封装
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午3:16:36
	 */
	@Test
	public void testSha1WithCC() {
		SHAUtil.sha1WithCC(SHAUtil.PLAINTEXT);
	}

}
