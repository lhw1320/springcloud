package com.qdfae.jdk.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 集合转换为数组
 *
 * @author hongwei.lian
 * @date 2018年3月27日 下午7:59:07
 */
public class CollectionToArrayTest {
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年3月27日 下午8:02:32
	 */
	@Test
	public void testListToArray() {
		List<Long> list = new ArrayList<>();
		list.add(2L);
		list.add(6L);
		long[] array = list.stream()
		                             .mapToLong(t -> t.longValue())
		                             .toArray();
		System.out.println(Arrays.toString(array));
	}

}
