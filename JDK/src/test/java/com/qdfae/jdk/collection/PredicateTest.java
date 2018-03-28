package com.qdfae.jdk.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

import com.qdfae.jdk.domain.SystypeBaseVo;

/**
 * Predicate接口测试
 *
 * @author hongwei.lian
 * @date 2018年3月28日 下午6:55:24
 */
public class PredicateTest {
	
	private List<SystypeBaseVo> list;
	
    /**
     * 初始化列表
     *
     * @author hongwei.lian
     * @date 2018年3月28日 下午6:57:13
     */
	@Before
	public void initList() {
		list = new ArrayList<>();
		list.add(new SystypeBaseVo(1, 8, 1, "次"));
		list.add(new SystypeBaseVo(2, 8, 2, "年化"));
		list.add(new SystypeBaseVo(3, 8, 3, "每期"));
	}
	
	@Test
	public void test1() {
		Predicate<SystypeBaseVo> filter = vo -> vo.getTypeId() == 3;
		
		//-- 取反运算
		filter.negate();
		
		//-- 与运算
		filter.and(vo -> vo.getTypeId() == 2);
		
		//-- 或运算
		filter.or(vo -> vo.getTypeId() == 2);
		
		//-- 比较方法
		Predicate<SystypeBaseVo> filter1 = Predicate.isEqual(list.get(2));
		
		list.removeIf(filter1);
		list.forEach(System.out::println);
		
	}

}
