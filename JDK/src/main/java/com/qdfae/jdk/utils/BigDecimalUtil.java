package com.qdfae.jdk.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BigDecimalUtil {
	
	private BigDecimalUtil() {}
	
	/**
	 * 转换,，默认值为0
	 * @param value
	 * @return BigDecimal
	 * @author zhiya.chai
	 * 2016年12月20日 下午1:55:58
	 */
	public static BigDecimal convertDefaultZero(String value) {
		try {
			return new BigDecimal(value);
		} catch (Exception e) {
		}
		return BigDecimal.ZERO;
	}
	
	/**
	 * 转换有默认值
	 * @param value
	 * @return BigDecimal
	 * @author zhiya.chai
	 * 2016年12月20日 下午1:55:58
	 */
	public static BigDecimal convertAutoDefaultValue(String value,BigDecimal defaultValue){
		try {
			return new BigDecimal(value);
		} catch (Exception e) {
		}
		return defaultValue;
	}
	
	public static String format(BigDecimal bg, String format) {
		try {
			DecimalFormat df = new DecimalFormat(format);
			return df.format(bg);
		} catch (Exception e) {
			return "";
		}
	}
	
	public static String formatMoney(BigDecimal bg) {
		return format(bg, "#,##0.00");
	}

}
