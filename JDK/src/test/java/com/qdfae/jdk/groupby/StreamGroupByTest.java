package com.qdfae.jdk.groupby;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.qdfae.jdk.domain.UserVo;

public class StreamGroupByTest {
	
	@Test
	public void testListGroupBy() {
		List<UserVo> userVoList = new ArrayList<>();
		userVoList.add(new UserVo().setName("lisi").setAge(12));
		userVoList.add(new UserVo().setName("hha").setAge(10));
		userVoList.add(new UserVo().setName("wang").setAge(12));
		userVoList.add(new UserVo().setName("zhang").setAge(11));
		userVoList.add(new UserVo().setName("111").setAge(15));
		userVoList.add(new UserVo().setName("122").setAge(11));
		Map<Integer, List<UserVo>> collect = userVoList.stream().collect(Collectors.groupingBy(UserVo::getAge));
		List<UserVo> list1 = collect.get(12);
		List<UserVo> list2 = collect.get(10);
		List<UserVo> list3 = collect.get(11);
		List<UserVo> list4 = collect.get(15);
		List<UserVo> list5 = collect.get(13);
		System.out.println(JSON.toJSON(list1));
		System.out.println(JSON.toJSON(list2));
		System.out.println(JSON.toJSON(list3));
		System.out.println(JSON.toJSON(list4));
		System.out.println(JSON.toJSON(list5));
	}

}
