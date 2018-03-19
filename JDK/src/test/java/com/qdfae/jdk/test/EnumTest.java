package com.qdfae.jdk.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;import java.util.TooManyListenersException;
import java.util.jar.Attributes.Name;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

public class EnumTest {
	
	/**
	 * 操作类型内部枚举
	 * @author hongwei.lian
	 * 2017年11月21日 下午7:29:43
	 */
	private enum OperateType {
		UPDATE_OPERATE(1), INSERT_OPERATE(2);
		
		private int value;
		 
	    private OperateType(int value) {
	        this.value = value;
	    }
	    
	    public static OperateType getOperateType(int value){
	    	OperateType operateType  = null;
			for(OperateType type : OperateType.values()){
				if(type.value == value){
					operateType = type;
				}
			}
			return operateType;
		}
	 
	    public int getValue() {
	        return value;
	    }
		
	}
	
	@Test
	public void testEnum(){
		OperateType[] operateTypes = OperateType.values();
		for (OperateType operateType : operateTypes) {
			System.out.println(operateType.getValue());
			System.out.println(OperateType.getOperateType(operateType.getValue()));
		}
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
		List<String> list4 = null;
		
		Map<Integer, List<String>> map = new HashMap<>();
		map.put(1, list1);
		map.put(2, list2);
		map.put(3, list3);
		map.put(4, list4);
		
		//增强for循环
//		for (Entry<Integer, List<String>> entry : map.entrySet()) {
//			System.out.println(entry.getKey() + ":" + entry.getValue());
//		}
		
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
		
//		map.values().stream()
//		                    .flatMap(toList -> toList.stream().filter(name -> Objects.nonNull(name)))
//		                    .forEach(name -> {
//		                    	if (name.equals("Jack")) {
//		                    		System.out.println(name);
//		   		        	    }
//		                    });
		
		
		map.values().stream()
						    .filter(CollectionUtils::isNotEmpty)
						    .flatMap(toList -> toList.stream().filter(name -> Objects.nonNull(name)))
						    .forEach(name -> {
						    	if (name.equals("Jack")) {
						    		System.out.println(name);
						   	    }
						    });
		
		
		//Lambda表达式
//		list4.stream()
//		       .filter(name -> Objects.nonNull(name))
//		       .forEach(name -> System.out.println(name));
		
		//方法引用
//		list1.stream()
//	           .filter(Objects::nonNull)
//	           .forEach(System.out::println);
		
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
