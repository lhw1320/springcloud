package com.qdfae.tcc.gson;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.happylifeplat.tcc.common.utils.GsonUtils;
import com.qdfae.tcc.domain.Person;

public class GsonUtilsTest {
	
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
	
	@Test
	public void testFromJson() {
		String json = "[{'id':1,'firstName':'Kobe','lastName':'Btrant'}, {'id':2,'firstName':'Tom','lastName':'Smith'}, {'id':3,'firstName':'Green','lastName':'Dayne'}, {'id':4,'firstName':'Amy','lastName':'Jenny'}, {'id':5,'firstName':'Lee','lastName':'David'}]";
		List<Person> personList = GsonUtils.getInstance().fromJson(json, List.class);
		System.out.println(personList);
	} 

}
