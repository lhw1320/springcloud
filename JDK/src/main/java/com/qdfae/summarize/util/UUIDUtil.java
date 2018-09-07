package com.qdfae.summarize.util;

import java.util.UUID;

/**
 * UUID工具类
 *
 * @author hongwei.lian
 * @date 2018年9月7日 下午6:14:15
 */
public class UUIDUtil {
	
	/**
	 * UUID
	 *
	 * @return
	 * @author hongwei.lian
	 * @date 2018年9月7日 下午6:14:06
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
