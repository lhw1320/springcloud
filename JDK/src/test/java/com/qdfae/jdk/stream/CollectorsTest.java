package com.qdfae.jdk.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.qdfae.jdk.domain.User;

/**
 * 字符串拼接
 *
 * @author hongwei.lian
 * @date 2021年3月11日 下午4:06:58
 */
public class CollectorsTest {
	
	private List<User> userList1;
	
	@Before
	public void init() {
		userList1 = new ArrayList<>();
		userList1.add(new User(1, "Jams", "Harden"));
		userList1.add(new User(2, "Jams", "Worf"));
		userList1.add(new User(3, "Jams", "John"));
	}

	/**
	 * https://blog.csdn.net/qq_42227281/article/details/102737819?utm_term=stream%E5%B0%86%E5%AD%97%E7%AC%A6%E4%B8%B2%E6%8B%BC%E6%8E%A5&utm_medium=distribute.pc_aggpage_search_result.none-task-blog-2~all~sobaiduweb~default-0-102737819&spm=3001.4430
	 *
	 * List<String> strings = Arrays.asList("abc", "", "de", "efg", "abcd", "", "jkl");
	 * String mergeString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(","));
	 * System.err.println("合并字符串 : "+mergeString);
	 * 
	 * @author hongwei.lian
	 * @date 2021年3月11日 下午4:07:26
	 */
	@Test
	public void test1() {
		String collect = userList1.stream()
				                                   .map(user -> user.getUserName() + "-" + user.getUserCode())
				                                   .collect(Collectors.joining(";"));
		System.out.println(collect);
	}

}
