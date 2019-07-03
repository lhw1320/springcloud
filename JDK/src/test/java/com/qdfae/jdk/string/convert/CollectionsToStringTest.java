package com.qdfae.jdk.string.convert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Joiner;

/**
 * Java集合转换为字符串
 * 
 * 百度搜索：List列表转换为字符串
 *
 * @author hongwei.lian
 * @date 2019年7月2日 上午9:22:31
 */
public class CollectionsToStringTest {
	
	//-- Array
	private Integer[] idArray = new Integer[] {};
	
	//-- List
	private List<Integer> idList = new ArrayList<>();
	
	//-- Set
	private Set<Integer> idSet = new HashSet<>();
	
	//-- String
	private String idString = "";
	
	/**
	 * 初始化
	 *
	 * @author hongwei.lian
	 * @date 2019年7月2日 下午12:10:25
	 */
	@Before
	public void init() {
		idArray = new Integer[] {1, 2, 3, 4};
		idList = Arrays.asList(idArray);
		idSet = new HashSet<>(idList);
	}
	
	@After
	public void print() {
		System.out.println("===转换String字符串===" + idString);
	}
	
	/**
	 * 一般方法
	 *
	 * @author hongwei.lian
	 * @date 2019年7月2日 下午12:17:02
	 */
	@Test
	public void testListToString1() {
		StringBuilder idStringBuilder = new StringBuilder();
		for (int i = 0; i < idList.size(); i++) {
			if (Objects.equals(i, idList.size() - 1)) {
				idStringBuilder.append(idList.get(i));
			} else {
				idStringBuilder.append(idList.get(i)).append(",");
			}
		}
		idString = idStringBuilder.toString();
	}
	
	/**
	 * StringUtils的join()方法
	 *
	 * @author hongwei.lian
	 * @date 2019年7月2日 下午12:20:44
	 */
	@Test
	public void testListToString2() {
		idString = StringUtils.join(idList, ",");
	}
	
	/**
	 * Joiner的join()方法
	 *
	 * @author hongwei.lian
	 * @date 2019年7月2日 下午12:22:16
	 */
	@Test
	public void testListToString3() {
		idString = Joiner.on(",").join(idList);
	}
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2019年7月2日 下午1:35:07
	 */
	@Test
	public void testSetToString1() {
		idString = StringUtils.join(idSet, ",");
	}
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2019年7月2日 下午1:35:12
	 */
	@Test
	public void testLSetToString2() {
		idString = Joiner.on(",").join(idSet);
	}

}
