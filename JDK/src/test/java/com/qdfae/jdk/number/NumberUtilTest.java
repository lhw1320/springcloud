package com.qdfae.jdk.number;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import com.qdfae.jdk.domain.Person;
import com.qdfae.jdk.utils.NumberUtil;

/**
 * NumberUtil测试类
 *
 * @author hongwei.lian
 * @date 2018年5月28日 下午7:10:23
 */
public class NumberUtilTest {
	
	@Test
	public void test1() {
		BigDecimal money = new BigDecimal("10000.00");
		String chineseMoney = NumberUtil.formatToChineseMoney(money);
		System.out.println(chineseMoney);
	}
	
	@Test
	public void test2() {
		List<Person> list = new ArrayList<>();
		
		
		list.forEach(person -> {
			System.out.println(person.getId());
		});
		
		
		
		
		if (CollectionUtils.isNotEmpty(list)) {
			System.out.println(list.get(0));
		}
	}
	
	@Test
	public void test3() {
		Integer flag = new Integer(1);
		
		switch (flag) {
		case 1:
			System.out.println("1");
			break;

		default:
			break;
		}
		
	}
	
	@Test
	public void test4() {
		String detailIds = "111";
		String[] split = detailIds.split(",");
		System.out.println(split.length);
		System.out.println(split[0]);
	}

}
