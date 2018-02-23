package com.qdfae.jdk.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	
	@Test
	public void test2(){
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		List<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(2);
		list1.removeAll(list2);
		list1.forEach(System.out::println);
	}
	
	@Test
	public void test3(){
		Integer id = 1;
		System.out.println(id == 1);
	}

}


