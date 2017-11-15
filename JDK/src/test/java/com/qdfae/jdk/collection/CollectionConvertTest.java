package com.qdfae.jdk.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * 集合相互转换
 * @author hongwei.lian 
 * @date 2017年11月15日 下午10:52:53
 */
public class CollectionConvertTest {
	
	/**
	 * Set集合转换为List集合方法1
	 * ArrayList的构造方法：ArrayList(Collection<? extends E> c)
	 * @author hongwei.lian  
	 * @date 2017年11月15日 下午10:36:41
	 */
	@Test
	public void testSetToList1() {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(2);
		set.add(4);
		List<Integer> list = new ArrayList<>(set);
		System.out.println(list);
	}
	
	/**
	 * Set集合转换为List集合方法2
	 * 步骤1：先将Set集合转为数组
	 * 步骤2：使用Arrays工具类的asList方法：<T> List<T> asList(T... a)
	 * @author hongwei.lian  
	 * @date 2017年11月15日 下午10:36:41
	 */
	@Test
	public void testSetToList2() {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(2);
		set.add(4);
		List<Object> list = Arrays.asList(set.toArray());//注意此处转换最终为Object类型
		System.out.println(list);
	}

}
