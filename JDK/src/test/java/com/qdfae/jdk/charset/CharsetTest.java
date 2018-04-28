package com.qdfae.jdk.charset;

import java.nio.charset.Charset;

import org.junit.Test;

/**
 * 
 *
 * @author hongwei.lian
 * @date 2018年4月25日 上午11:51:38
 */
public class CharsetTest {
	
	/**
	 * public static Charset defaultCharset()
	 *
	 * @author hongwei.lian
	 * @date 2018年4月25日 上午11:52:23
	 */
	@Test
	public void testDefaultCharset() {
		String name = Charset.defaultCharset().name();
		System.out.println(name);//UTF-8
	}

}
