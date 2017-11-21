package com.qdfae.jdk.test;

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

}
