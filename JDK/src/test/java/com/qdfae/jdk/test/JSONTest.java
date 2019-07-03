package com.qdfae.jdk.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qdfae.jdk.domain.Person;
import com.qdfae.jdk.domain.Project;
import com.qdfae.jdk.domain.RefundParam;
import com.qdfae.jdk.domain.WhitePerson;

import cn.hutool.json.JSONUtil;

public class JSONTest {
	
	@Test
	public void testObjectUtils() {
		//String content = '[{"createOperatorId":661,"createTime":1542960240000,"file1":"模板1.pdf:82b2c141248d7c1fd37a1e445d79ea27.pdf","fileType":1,"id":2249,"infoName":"入会申请书","updateOperatorId":661,"updateTime":1542960240000,"userFileGuid":"beba5d032f9e4d7f9efa17135e99e7e1","userId":259897}]';
	}
	
	@Test
	public void test1() {
		RefundParam param = new RefundParam();
		param.setPerson(new Person(1, "jams", "harden"));
		List<Project> projects = new ArrayList<>();
		projects.add(new Project(1, new BigDecimal("11")));
		param.setProjects(projects);
		String content = JSON.toJSONString(param);
		
		RefundParam parseObject = JSONObject.parseObject(content, RefundParam.class);
		System.out.println(parseObject.getPerson().getId());
		System.out.println(parseObject.getProjects().get(0).getUserId());
	}
	
	@Test
	public void test2() {
		StringBuilder builder = new StringBuilder();
		builder.append(",").append("1");
		builder.append(",").append("2");
		System.out.println(builder.toString().substring(1));
	}
	
	@Test
	public void test3() {
		List<Person> list = new ArrayList<>();
		list.add(new Person(1, "", "Jams", 10));
		list.add(new Person(2, "Lebor", "", 11));
		list.add(new Person(3, "", "", 12));
		list.add(new Person(4, "Lei", "Allen", 13));
		int sum = 0;
		for (Person person : list) {
			if (StringUtils.isBlank(person.getFirstName()) || StringUtils.isBlank(person.getLastName())) {
				System.out.println(person.getId());
				continue ;
			}
			System.out.println("=======");
			if (Objects.nonNull(person.getAge())) {
				sum = sum + person.getAge();
			}
		}
		System.out.println(sum);
	}
	
	@Test
	public void test4() {
		List<Person> list = new ArrayList<>();
		list.add(new Person(1, "", "Jams", 10));
		list.add(new Person(2, "Lebor", "", 11));
		list.add(new Person(3, "", "", 12));
		list.add(new Person(4, "Lei", "Allen", 13));
		
		List<Person> subList = new ArrayList<>();
		subList.add(new Person(5, "111", "Jams", 20));
		list.addAll(null);
		System.out.println(list.size());
	}
	
	@Test
	public void test5() {
		WhitePerson person = new WhitePerson();
		
		if (person instanceof Person) {
			
		}
		
	}

}
