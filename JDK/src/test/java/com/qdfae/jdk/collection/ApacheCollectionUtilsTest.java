package com.qdfae.jdk.collection;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.qdfae.jdk.domain.User;

public class ApacheCollectionUtilsTest {
	
	private List<User> userList;
	
	@Before
	public void init() {
		userList = new ArrayList<>();
		//userList.add(new User(1, "Tom", "00001"));
	}
	
	@Test
	public void testIsNotEmpty() {
		System.out.println("LIst集合是否为空：" + CollectionUtils.isNotEmpty(userList));
		System.out.println("LIst集合是否为空：" + CollectionUtils.isEmpty(userList));
	}

}
