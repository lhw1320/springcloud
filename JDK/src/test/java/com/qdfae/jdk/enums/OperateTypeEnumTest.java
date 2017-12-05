package com.qdfae.jdk.enums;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import com.qdfae.jdk.domain.Person;
import com.qdfae.jdk.domain.Student;

/**
 * OperateTypeEnum测试
 * 
 * @author hongwei.lian
 * 2017年12月5日 上午11:17:31
 */
public class OperateTypeEnumTest {
	
	/**
	 * 
	 * 
	 * @author hongwei.lian
	 * 2017年12月5日 上午11:28:53
	 */
	@Test
	public void testValues1() {
		//
		OperateTypeEnum[] values = OperateTypeEnum.values();
		//
		Arrays.stream(values).forEach(System.out::println);
	} 
	
	@Test
	public void testValues2() {
		//
		OperateTypeEnum[] values = OperateTypeEnum.values();
		//
		Arrays.stream(values).forEach(value -> {
			System.out.println("value元素的code为：" + value.getCode() + "，desc为：" + value.getDesc());
		});
	} 
	
	/**
	 * 
	 * 
	 * @author hongwei.lian
	 * 2017年12月5日 上午11:40:25
	 */
	@Test
	public void testFindFirst() {
		//
		OperateTypeEnum[] values = OperateTypeEnum.values();
		//
		Optional<OperateTypeEnum> optional = Arrays.stream(values).findFirst();
		System.out.println(optional);
		OperateTypeEnum operateType = optional.get();
		System.out.println(operateType);
		System.out.println("operateType元素的code为：" + operateType.getCode() + "，desc为：" + operateType.getDesc());
	} 
	
	/**
	 * Optional<T>接口的orElse()方法
	 * 
	 * @author hongwei.lian
	 * 2017年12月5日 上午11:40:49
	 */
	@Test
	public void testOrElse() {
		//设置为正常数据
		//OperateTypeEnum[] values = OperateTypeEnum.values();
		//设置空数组
		//OperateTypeEnum[] values = {};
		//设置null值
		OperateTypeEnum[] values = null;
		Optional<OperateTypeEnum> optional = 
				Arrays.stream(values)
				          .filter(value -> Objects.equals(value.getCode(), OperateTypeEnum.UPDATE_OPERATE.getCode()))
                          .findFirst();
		OperateTypeEnum operateType = optional.orElse(OperateTypeEnum.UPDATE_OPERATE);
		System.out.println("operateType元素的code为：" + operateType.getCode() + "，desc为：" + operateType.getDesc());
	} 
	
	
	/**
	 * 推荐使用方式
	 * 
	 * @author hongwei.lian
	 * 2017年12月5日 上午11:17:09
	 */
	@Test
	public void testEquals1() {
		Person person = new Person();
		person.setOperateType(1);
		boolean flag = person.getOperateType() == OperateTypeEnum.UPDATE_OPERATE.getCode();
		Assert.assertTrue(flag);
	} 
	
	@Test
	public void testEquals2() {
		Student student = new Student();
		student.setOperateType(OperateTypeEnum.UPDATE_OPERATE);
		boolean flag = student.getOperateType().equals(OperateTypeEnum.UPDATE_OPERATE);
		Assert.assertTrue(flag);
	} 
	
	@Test
	public void testEquals3() {
		Student student = new Student();
		student.setOperateType(OperateTypeEnum.UPDATE_OPERATE);
		boolean flag = student.getOperateType() == OperateTypeEnum.UPDATE_OPERATE;
		Assert.assertTrue(flag);
	} 

}
