package com.qdfae.jdk.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MapTest {
	
	@Test
	public void testPutMap(){
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "lian");
		map.put(1, "lian1");//更新数据
		String name = map.get(1);
		System.out.println(map.size());
		System.out.println(name);
	}
	
	@Test
	public void test1(){
		Integer id = 1;
		System.out.println(1 == id);
	}

}
