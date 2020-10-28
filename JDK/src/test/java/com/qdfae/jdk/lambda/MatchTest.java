package com.qdfae.jdk.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.Before;
import org.junit.Test;

/**
 * Lambda匹配项测试类
 *
 * @author hongwei.lian
 * @date 2020年10月28日 下午5:08:15
 */
public class MatchTest {
	
	private List<UserVo> userVoList = new ArrayList<>();
	
	@Before
	public void init() {
		userVoList.add(new UserVo().setUserType(1).setUserCode("6002315"));
		userVoList.add(new UserVo().setUserType(1).setUserCode("6002316"));
		userVoList.add(new UserVo().setUserType(1).setUserCode("6002317"));
	}
	
	/**
	 * 测试noneMatch
	 * 
	 * 含义：不存在匹配项则返回true，否则返回false
	 *
	 * @author hongwei.lian
	 * @date 2020年10月28日 下午5:19:27
	 */
	@Test
	public void testNoneMatch() {
		boolean noneMatch = userVoList.stream().map(UserVo::getUserCode).noneMatch(userCode -> Objects.equals("6002319", userCode));
		System.out.println(noneMatch);
	}
	
	/**
	 * 测试anyMatch
	 * 
	 * 含义：存在匹配项则返回true，否则返回false
	 *
	 * @author hongwei.lian
	 * @date 2020年10月28日 下午5:21:05
	 */
	@Test
	public void testAnyMatch() {
		boolean anyMatch = userVoList.stream().map(UserVo::getUserCode).anyMatch(userCode -> Objects.equals("6002317", userCode));
		System.out.println(anyMatch);
	}
	
	/**
	 * 测试allMatch
	 * 
	 * 含义：全匹配项则返回true，否则返回false
	 *
	 * @author hongwei.lian
	 * @date 2020年10月28日 下午5:22:27
	 */
	@Test
	public void testAllMatch() {
		boolean allMatch = userVoList.stream().map(UserVo::getUserType).allMatch(userType -> Objects.equals(1, userType));
		System.out.println(allMatch);
	}

}
