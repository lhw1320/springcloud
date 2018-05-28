package com.qdfae.jdk.code.array;

import java.lang.reflect.Array;

import org.apache.ibatis.javassist.expr.NewArray;
import org.junit.Test;

import com.qdfae.jdk.domain.Person;

import cn.hutool.core.util.ArrayUtil;

/**
 * 数组测试类
 * 
 * @author hongwei.lian 
 * @date 2018年5月27日 下午2:24:22
 */
public class ArrayTest {
	
	/**
	 * ArrayUtil工具类创建数组
	 *  
	 * @author hongwei.lian  
	 * @date 2018年5月27日 下午4:03:45
	 */
	@Test
	public void testCreatArray() {
		Object[] array1 = ArrayUtil.newArray(5);
		array1[0] = true;
		array1[1] = new Person();;
		String[] array4 = ArrayUtil.newArray(5);
		array4[0] = "test";
		
		Object[] array2 = ArrayUtil.newArray(String.class, 5);
		array2[0] = new Person();
		String[] array3 = ArrayUtil.newArray(String.class, 5);
		array3[0] = "test";
		
	}
	
	/**
	 * 
	 *  
	 * @author hongwei.lian  
	 * @date 2018年5月27日 下午2:25:17
	 */
	@Test
	public void testCreatArray1() {
		//-- 创建数组
		int[] intArray = (int[]) Array.newInstance(int.class, 5);
		//- 设值
		Array.set(intArray, 0, 1);
		//-- 获取
		Object object = Array.get(intArray, 0);
		System.out.println(object);
		System.out.println("============");
		
		
		Array.setInt(intArray, 1, 2);
		int int1 = Array.getInt(intArray, 1);
		System.out.println(int1);
		System.out.println("============");
//		Object newInstance2 = Array.newInstance(Integer.TYPE, 5);
//		Object newInstance3 = Array.newInstance(Integer.class, 5);
//		
//		Object newInstance4 = Array.newInstance(int.class, 5);
		
	}
	
	@Test
	public void testCreatArray2() {
		Object[] objectArray = ArrayUtil.newArray(5);
		
		Object[] intArray = ArrayUtil.newArray(int.class, 5);
		
		Object[] newArray = ArrayUtil.newArray(String.class, 5);
		
		
		
		
		
		
		
		
		
		String[] stringArray1 = (String[]) Array.newInstance(String.class, 5);
		
		
		
		
		String[] newArray2 = ArrayTest.newArray(String.class, 5);
		Person[] newArray11 = ArrayTest.newArray(Person.class, 5);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[] newArray(Class<T> componentType, int newSize) {
		return (T[]) Array.newInstance(componentType, newSize);
	}

}
