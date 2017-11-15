package com.qdfae.jdk.functioninterface;

import java.util.Objects;

/**
 * String封装类
 * @author hongwei.lian 
 * @date 2017年11月15日 下午11:57:33
 */
public class StringUtil {
	
	/**
	 * 获取第字符串首位置子字符串
	 * @param string
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年11月15日 下午11:56:49
	 */
	public String startsWith(String string) {
		if (Objects.isNull(string)) {
			throw new RuntimeException("传入字符串不能为空");
		}
		return string.substring(0, 1);
	}
	
}
