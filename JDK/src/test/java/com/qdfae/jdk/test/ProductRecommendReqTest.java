package com.qdfae.jdk.test;

import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.junit.Test;

import com.qdfae.jdk.domain.ProductRecommendReq;

/**
 *  测试对象空指针异常
 * 
 * @author hongwei.lian
 * 2018年2月7日 下午7:44:13
 */
public class ProductRecommendReqTest {
	
	/**
	 * 正常情况
	 * 对象的四个属性均赋值
	 * 
	 * @author hongwei.lian
	 * 2018年2月7日 下午7:50:12
	 */
	@Test
	public void test1() {
		List<Integer> companyIds = Arrays.asList(6002135, 6002136, 6002137, 6002138);
		ProductRecommendReq req = new ProductRecommendReq(3145, 6002135, companyIds, 325698);
		boolean flag = Objects.nonNull(req);
		System.out.println(flag);//true
	} 
	
	/**
	 * 正常情况
	 * 对象的三个属性（int类型默认值为0）均不赋值
	 * 只对companyIds（类型为List<Integer>）赋值
	 * 
	 * @author hongwei.lian
	 * 2018年2月7日 下午8:14:49
	 */
	@Test
	public void test2() {
		List<Integer> companyIds = Arrays.asList(6002135, 6002136, 6002137, 6002138);
		ProductRecommendReq req = new ProductRecommendReq(companyIds);
		boolean flag = Objects.nonNull(req);
		System.out.println(flag);//true
	} 
	
	@Test
	public void test3() {
		List<Integer> companyIds = null;
		ProductRecommendReq req = new ProductRecommendReq(companyIds);
		boolean flag = Objects.nonNull(req);
		System.out.println(flag);//true
		
//		if(Objects.isNull(req) || CollectionUtils.isEmpty(req.getCompanyIds())){
//			throw new EmptyParameterException();
//		}
	} 
	
	@Test
	public void test4() {
		List<Integer> companyIds = new ArrayList<>();;
		ProductRecommendReq req = new ProductRecommendReq(companyIds);
		boolean flag = Objects.nonNull(req);
		System.out.println(flag);//true
	} 

}
