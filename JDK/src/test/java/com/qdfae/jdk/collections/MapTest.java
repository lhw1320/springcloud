package com.qdfae.jdk.collections;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * 
 *
 * @author hongwei.lian
 * @date 2018年4月9日 下午1:44:44
 */
public class MapTest {
	
	@Test
	public void testMap1() {
		Map<String, Object> map = new HashMap<>(2);
		map.put("source", 3);
		map.put("needGather", 1);
		map.put("gatherStatusDesc", new Integer[]{1, 4});
		map.forEach((key, value) -> {
			System.out.println(key + ":" + value);
		});
	}

}
