package com.qdfae.jdk.string;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import com.qdfae.jdk.domain.User;
import com.qdfae.jdk.exception.BayMaxBaseException;
import com.qdfae.jdk.support.ResponseCodeBase;

/**
 * 测试StringUtils
 *
 * @author hongwei.lian
 * @date 2018年11月26日 上午9:23:25
 */
public class StringTest {
	
	private List<User> users = new ArrayList<>(); 
	
	@Before
	public void init() {
		users.add(new User(1, "John", "60012356"));
		users.add(new User(2, "Harden", "60012357"));
		users.add(new User(3, "Paul", "60012358"));
	}
	
	@Test
	public void testAppend1() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < users.size(); i++) {
//			if (i) {
//				
//			}
		}
		
		for (User user : users) {
			sb.append(user.getId()).append(",");
		}
		System.out.println(sb.toString());//-- 1,2,3,
		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length()-1);
		}
		System.out.println(sb.toString());//-- 1,2,3
	}
	
	@Test
	public void testAppend2() {
		StringBuilder sb = new StringBuilder();
		for (User user : users) {
			sb.append(user.getId()).append(",");
		}
		System.out.println(sb.toString());//-- 1,2,3,
		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length()-1);
		}
		System.out.println(sb.toString());//-- 1,2,3
	}
	
	@Test
	public void testJoin() {
		String ids = StringUtils.join(users.stream().map(User::getId).collect(Collectors.toList()), ",");
		System.out.println(ids);//-- 1,2,3
	}
	
	@Test
	public void testSplit() {
		String excelSealFile = "";
		if (StringUtils.isNotBlank(excelSealFile)) {
			System.out.println("既不是null也不是''");
			String[] split = excelSealFile.split(":");
			System.out.println(split.length);
		}
	}
	
	@Test
	public void testHadle() {
		try {
			this.testThrowNew();
		} catch (Exception e) {
			System.out.println("=====" + e.getMessage());
		}
	}
	
	
	public void testThrow() {
		this.testThrowNew();
	}
	
	public void testThrowNew() {
		throw new BayMaxBaseException(ResponseCodeBase.SYSTEM_ERROR, null, "上传不成功，请重新上传"); 
	}

}
