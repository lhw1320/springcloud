package com.qdfae.jdk.codec;

import org.junit.Test;

import com.qdfae.jdk.codec.mac.MACUtil;

/**
 * MAC算法测试类
 * 
 * @author hongwei.lian 
 * @date 2018年3月11日 下午4:10:58
 */
public class MACTest {
	
	/**
	 * HmacMD5算法加密方法
	 * 实现：JDK
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午4:21:33
	 */
	@Test
	public void testHmacMD5WithJDK() {
		MACUtil.hmacMD5WithJDK(MACUtil.PLAINTEXT);
	}
	
	/**
	 * HmacMD5算法加密方法
	 * 实现：Bouncy Castle
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午4:22:27
	 */
	@Test
	public void testHmacMD5WithBC() {
		MACUtil.hmacMD5WithBC(MACUtil.PLAINTEXT);
	}

}
