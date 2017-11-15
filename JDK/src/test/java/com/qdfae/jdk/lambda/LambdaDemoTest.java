package com.qdfae.jdk.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

/**
 * 测试Lambda表达式
 * @author hongwei.lian 
 * @date 2017年11月15日 下午10:25:19
 */
public class LambdaDemoTest {
	
	/**
	 * 测试Lambda表达式1：匿名对象方式
	 * @author hongwei.lian  
	 * @date 2017年11月15日 下午10:29:56
	 */
	@Test
	public void testLambda1() {
		List<String> names = Arrays.asList("peter", "any", "jack", "rose");
		Collections.sort(names, new Comparator<String>() {
			
		    @Override
		    public int compare(String name1, String name2) {
		        return name1.compareTo(name2);
		    }
		    
		});
		System.out.println(names);//[any, jack, peter, rose]
	}
	
	/**
	 * 测试Lambda表达式2：Lambda表达式方式（普通规范）
	 * @author hongwei.lian  
	 * @date 2017年11月15日 下午10:29:56
	 */
	@Test
	public void testLambda2() {
		List<String> names = Arrays.asList("peter", "any", "jack", "rose");
		Collections.sort(names, (String name1, String name2) -> {
		    return name1.compareTo(name2);
		});
		System.out.println(names);//[any, jack, peter, rose]
	}
	
	/**
	 * 测试Lambda表达式3：Lambda表达式方式（省略return关键字以及{}、;）
	 * @author hongwei.lian  
	 * @date 2017年11月15日 下午10:29:56
	 */
	@Test
	public void testLambda3() {
		List<String> names = Arrays.asList("peter", "any", "jack", "rose");
		Collections.sort(names, (String name1, String name2) -> name1.compareTo(name2));
		System.out.println(names);//[any, jack, peter, rose]
	}
	
	/**
	 * 测试Lambda表达式4：Lambda表达式方式（省略数据类型和return关键字以及{}、;）
	 * @author hongwei.lian  
	 * @date 2017年11月15日 下午10:29:56
	 */
	@Test
	public void testLambda4() {
		List<String> names = Arrays.asList("peter", "any", "jack", "rose");
		Collections.sort(names, (name1, name2) -> name1.compareTo(name2));
		System.out.println(names);//[any, jack, peter, rose]
	}
	
}
