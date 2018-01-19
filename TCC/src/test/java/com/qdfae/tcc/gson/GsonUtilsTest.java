package com.qdfae.tcc.gson;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.qdfae.tcc.domain.Person;
import com.qdfae.tcc.utils.GsonUtils;

/**
 * 
 * 
 * @author hongwei.lian 
 * @date 2018年1月14日 下午3:39:34
 */
public class GsonUtilsTest {
	
	/**
	 *  
	 * @author hongwei.lian  
	 * @date 2017年12月2日 下午5:12:13
	 */
	@Test
	public void testToJson() {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person(1, "Kobe", "Btrant"));
		personList.add(new Person(2, "Tom", "Smith"));
		personList.add(new Person(3, "Green", "Dayne"));
		personList.add(new Person(4, "Amy", "Jenny"));
		personList.add(new Person(5, "Lee", "David"));
		String json = GsonUtils.getInstance().toJson(personList);
		System.out.println(json);
	} 
	
	/**
	 *  
	 * @author hongwei.lian  
	 * @date 2017年12月2日 下午5:12:22
	 */
	@Test
	public void testFromJson() {
		String json = "[{'id':1,'firstName':'Kobe','lastName':'Btrant'}, {'id':2,'firstName':'Tom','lastName':'Smith'}, {'id':3,'firstName':'Green','lastName':'Dayne'}, {'id':4,'firstName':'Amy','lastName':'Jenny'}, {'id':5,'firstName':'Lee','lastName':'David'}]";
		List<Person> personList = GsonUtils.getInstance().fromJson(json, List.class);
		System.out.println(personList);
	} 

}
