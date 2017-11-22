package com.qdfae.jdk.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;import java.util.TooManyListenersException;
import java.util.jar.Attributes.Name;
import java.util.stream.Collectors;

import org.junit.Test;

public class EnumTest {
	
	/**
	 * 操作类型内部枚举
	 * @author hongwei.lian
	 * 2017年11月21日 下午7:29:43
	 */
	private enum operateType {
		UPDATE_OPERATE(1), INSERT_OPERATE(2);
		
		private int value;
		 
	    private operateType(int value) {
	        this.value = value;
	    }
	 
	    public int getValue() {
	        return value;
	    }
		
	}
	
	@Test
	public void testEnum(){
		//EnumTest.operateType = 
	}
	
	@Test
	public void testMap(){
		List<String> list1 = new ArrayList<>();
		list1.add("Tom");
		list1.add("Amy");
		list1.add("Jack");
		list1.add(null);
		List<String> list2 = new ArrayList<>();
		list2.add("Tom");
		list2.add("Amy");
		list2.add("Jack");
		List<String> list3 = new ArrayList<>();
		list3.add("Tom");
		list3.add("Amy");
		list3.add("Jack");
		list3.add(null);
		Map<Integer, List<String>> map = new HashMap<>();
		map.put(1, list1);
		map.put(2, list2);
		map.put(3, list3);
		
//		map.forEach((key, value) -> {
//			value.stream()
//			         .filter(name -> Objects.nonNull(name))
//			         .forEach(name -> {
//			        	 if (name.equals("Jack")) {
//			        		 System.out.println(name);
//			        	 }
//			         });
//		});
		
//		map.values().forEach(list -> {
//			list.stream()
//	            .filter(name -> Objects.nonNull(name))
//		        .forEach(name -> {
//		        	 if (name.equals("Jack")) {
//		        		 System.out.println(name);
//		        	 }
//		         });
//		});
		
		map.values().stream()
		                    .flatMap(toList -> toList.stream().filter(name -> Objects.nonNull(name)))
		                    .forEach(name -> {
		                    	if (name.equals("Jack")) {
		                    		System.out.println(name);
		   		        	    }
		                    });
		
		
		
		
	}
	
	
	@Test
	public void testList(){
		List<String> list = new ArrayList<>();
		list.add("Tom");
		list.add("Amy");
		list.add("Jack");
		
		list.stream()
		    .filter(name -> name.equals("m"))
		    .filter(name -> name.equals("a"))
		    .forEach(name -> System.out.println(name));
		
		
	}
		
	

}
