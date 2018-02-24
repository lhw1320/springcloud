package com.qdfae.jdk.test;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.qdfae.jdk.repayPlan.GenRepayStageParam;

/**
 * GenRepayStageParam测试
 * 
 * @author hongwei.lian
 * 2018年2月24日 下午5:41:21
 */
public class GenRepayStageParamTest {
	
	/**
	 * 获取到期日
	 * 
	 * @author hongwei.lian
	 * 2018年2月24日 下午5:42:13
	 */
	@Test
	public void testGetExpireDate() {
		//-- 设置时间
		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 1, 15);
		Date time = calendar.getTime();
		
		//-- 组装参数
		GenRepayStageParam param = new GenRepayStageParam(time, 10, 3, 1);
		Date expireDate = param.getExpireDate();
		System.out.println(expireDate);
	} 

}
