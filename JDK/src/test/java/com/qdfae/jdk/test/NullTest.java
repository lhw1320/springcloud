package com.qdfae.jdk.test;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

import com.qdfae.jdk.domain.ListingInfoVo;
import com.qdfae.jdk.domain.ListingTradePo;

/**
 * 测试空指针
 *
 * @author hongwei.lian
 * @date 2018年3月26日 下午5:33:47
 */
public class NullTest {
	
	@Test
	public void testNull1() {
		//-- Java八种基本数据类型不能直接与null做==比较
		//-- 如果做比较，编译不通过
		//System.out.println(1 == null);
		//System.out.println(true == null);
		
		//-- 如果将实体类中的属性字段定义为八种基本类型对应的包装类型
		//-- 编译通过
		//-- 潜在问题：如果实体类中的属性字段为null值，那么与基本数据类型做==比较
		//-- 会抛出空指针异常
		//-- 原因：实际上基本数据类型与各自对应的包装类型做==比较使用的是
		//-- 包装类型对应的xxxValue()方法转换为基本数据类型再做比较，这就解释了
		//-- 如果实体类中的属性字段为null值，然后再null.xxxValue()方法必然抛出空指针异常
		ListingTradePo tradePo = new ListingTradePo();
		System.out.println(1 == tradePo.getTransferType());
		//-- 等价于
		System.out.println(1 == tradePo.getTransferType().intValue());
		System.out.println(true == tradePo.getFlag());
		//-- 等价于
		System.out.println(true == tradePo.getFlag().booleanValue());
	}
	
	@Test
	public void testNull2() {
		ListingTradePo tradePo = new ListingTradePo();
		ListingInfoVo infoVo = new ListingInfoVo();
		infoVo.setTransferType(2);
		//-- 拷贝
		BeanUtils.copyProperties(infoVo, tradePo);
		System.out.println(tradePo.getTransferType());
	}

}
