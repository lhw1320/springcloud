package com.qdfae.jdk.array;

import java.math.BigDecimal;

import org.junit.Test;

public class ArrayTest {
	
	@Test
	public void test1() {
		//-- 存储0个元素
		//BigDecimal[] principals = new BigDecimal[]{};
		//-- 存储2个元素
		BigDecimal[] principals = new BigDecimal[2];
		principals[0] = new BigDecimal("1");
		principals[1] = new BigDecimal("2");
		//principals[2] = new BigDecimal("3");
		for (BigDecimal bigDecimal : principals) {
			System.out.println(bigDecimal);
		}
	}

}
