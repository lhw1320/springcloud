package com.qdfae.jdk.functioninterface;

import org.junit.Test;

/**
 * 测试函数式接口
 * @author hongwei.lian 
 * @date 2017年11月15日 下午11:44:30
 */
public class ConverterTest {
	
	/**
	 * 匿名对象方式
	 * @author hongwei.lian  
	 * @date 2017年11月15日 下午11:46:09
	 */
	@Test
	public void testConverter1() {
		Converter<String, Integer> converter = new Converter<String, Integer>() {
			
			@Override
			public Integer convert(String from) {
				return Integer.valueOf(from);
			}
			
		};
		Integer result = converter.convert("123");
		System.out.println(result);//123
	}
	
	/**
	 * 静态方法引用
	 * @author hongwei.lian  
	 * @date 2017年11月15日 下午11:46:09
	 */
	@Test
	public void testConverter2() {
		Converter<String, Integer> converter = Integer::valueOf;
		Integer result = converter.convert("123");
		System.out.println(result);//123
	}
	
	/**
	 * 非静态方法引用
	 * @author hongwei.lian  
	 * @date 2017年11月15日 下午11:46:09
	 */
	@Test
	public void testConverter3() {
		StringUtil stringUtil = new StringUtil();
		Converter<String, String> converter = stringUtil::startsWith;
		String result = converter.convert("123");
		System.out.println(result);//1
	}
	
	/**
	 * 构造方法引用
	 * @author hongwei.lian  
	 * @date 2017年11月15日 下午11:46:09
	 */
	@Test
	public void testConverter4() {
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("Peter", "Parker");
		System.out.println(person);//Peter Parker
	}

}
