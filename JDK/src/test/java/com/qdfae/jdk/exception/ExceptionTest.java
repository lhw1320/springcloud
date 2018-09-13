package com.qdfae.jdk.exception;

import org.junit.Test;

import com.qdfae.jdk.support.ResponseCodeBase;

/**
 * ExceptionTest
 *
 * @author hongwei.lian
 * @date 2018年6月4日 下午3:57:39
 */
public class ExceptionTest {
	
	public void init() {
		int sum = 1;
		if (sum == 1) {
			throw new BayMaxBaseException(ResponseCodeBase.SYSTEM_ERROR, null, "提前部分还款金额不能大于当前应还总额");
		}
	}
	
	@Test
	public void test1() {
		try {
			init();
		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
	}
	
}
