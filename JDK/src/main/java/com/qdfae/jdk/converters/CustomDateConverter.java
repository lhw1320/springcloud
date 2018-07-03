package com.qdfae.jdk.converters;

import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.converters.basic.DateConverter;

/**
 * 自定义Xstream时间日期转换工具类
 *
 * @author hongwei.lian
 * @date 2018年6月27日 下午5:29:52
 */
public class CustomDateConverter extends DateConverter {
	
	public CustomDateConverter() {};
	
	/**
	 * 构造方法
	 * 
	 * @param string
	 * @param strings
	 * @param timeZone
	 */
	public CustomDateConverter(String string, String[] strings, TimeZone timeZone) {
		super(string, strings, timeZone);
	}

	/**
	 * 时间日期转换
	 */
	@Override
	public Object fromString(String str) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		return super.fromString(str);
    }

}
