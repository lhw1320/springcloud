package com.qdfae.jdk.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;


public class MapGroupbyTest {
	
	/**
	 * 
	 */
	private List<Map<String, Object>> list;
	
	@SuppressWarnings("deprecation")
	@Before
	public void Init() {
		list = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<>();
		map1.put("browerTime", new Date(2018, 5, 18));
		Map<String, Object> map2 = new HashMap<>();
		map2.put("browerTime", new Date(2018, 5, 6));
		Map<String, Object> map3 = new HashMap<>();
		map3.put("browerTime", new Date(2018, 5, 9));
		Map<String, Object> map4 = new HashMap<>();
		map4.put("browerTime", new Date(2018, 5, 8));
		list.add(map1);
		list.add(map2);
		list.add(map3);
		list.add(map4);
	}
	
	@After
	public void foreach() {
		//list.forEach(System.out::println);
	}
	
	@Test
	public void testMapGroupby1() {
		
		Stream<Stream<Object>> stream1 = list.stream().map(map -> map.values().stream());
		
		Stream<Object> date = stream1.map(stream -> stream.findFirst().get());
		
		date.sorted().forEach(System.out::println);
		
		
		
	}
	
	@Test
	public void testMapGroupby2() {
        //-- 将List转换为	
		Stream<Stream<Object>> stream1 = list.stream().map(map -> map.values().stream());
		
		Stream<Object> date = stream1.map(stream -> stream.findFirst().get());
		
		List<Object> collect = date.collect(Collectors.toList());
		
		
		
	}
	

}
