package com.qdfae.jdk.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.qdfae.jdk.domain.SystypeBaseVo;

/**
 * Function接口测试
 * 功能：映射
 *
 * @author hongwei.lian
 * @date 2018年3月28日 下午7:29:26
 */
public class FunctionTest {
	
	private List<SystypeBaseVo> list;
	
    /**
     * 初始化列表
     *
     * @author hongwei.lian
     * @date 2018年3月28日 下午7:55:56
     */
	@Before
	public void initList() {
		list = new ArrayList<>();
		list.add(new SystypeBaseVo(1, 8, 1, "次"));
		list.add(new SystypeBaseVo(2, 8, 2, "年化"));
		list.add(new SystypeBaseVo(3, 8, 3, "每期"));
	}
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年3月28日 下午7:56:06
	 */
	@Test
	public void test1() {
		List<String> typeNameList = list.stream().map(vo -> vo.getTypeName()).collect(Collectors.toList());
		typeNameList.forEach(System.out::println);
	}
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年3月28日 下午8:00:04
	 */
	@Test
	public void test2() {
		Map<Integer, SystypeBaseVo> map = list.stream()
				.collect(Collectors
						.toMap(
								vo -> vo.getTypeId(), 
								vo -> vo));
		map.forEach((key, value) -> System.out.println(key + ":" + value));
	}	

}
