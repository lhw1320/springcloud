package com.qdfae.jdk.collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.qdfae.jdk.enums.ProductTypeDesc;

/**
 * 
 *
 * @author hongwei.lian
 * @date 2018年4月17日 下午1:29:23
 */
public class ArrayTest {

	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年4月19日 下午7:08:56
	 */
	@Test
	public void testArray1() {
		ProductTypeDesc[] productTypeArray = ProductTypeDesc.values();
		List<ProductTypeDesc> productTypeList = 
				Arrays.stream(productTypeArray)
		                   .filter(productType -> productType != ProductTypeDesc.金融资产转让)
		                   .collect(Collectors.toList());
		productTypeList.forEach(System.out::println);
	}
	
}
