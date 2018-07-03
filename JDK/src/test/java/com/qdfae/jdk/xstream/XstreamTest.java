package com.qdfae.jdk.xstream;

import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

import com.qdfae.jdk.converters.CustomDateConverter;
import com.thoughtworks.xstream.converters.basic.DateConverter;

public class XstreamTest {
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年6月27日 下午5:32:31
	 */
	@Test
	public void testParse1() {
		DateConverter dateConverter = new DateConverter("yyyy-MM-dd HH:mm:ss"
				, new String[]{"yyyy-MM-dd","HH:mm:ss","yyyyMMdd","HHmmss","yyyyMMdd HHmmss","yyyyMMddHHmmss"}
				, TimeZone.getTimeZone("Asia/Shanghai"));
        Date date = (Date) dateConverter.fromString("");
        System.out.println(date);
	}
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年6月27日 下午5:32:35
	 */
	@Test
	public void testParse2() {
		DateConverter dateConverter = new CustomDateConverter("yyyy-MM-dd HH:mm:ss", 
		new String[]{"yyyy-MM-dd","HH:mm:ss","yyyyMMdd","HHmmss","yyyyMMdd HHmmss","yyyyMMddHHmmss"},
		TimeZone.getTimeZone("Asia/Shanghai"));
        Date date = (Date) dateConverter.fromString("");
        System.out.println(date);
	}

}
