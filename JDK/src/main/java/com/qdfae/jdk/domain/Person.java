package com.qdfae.jdk.domain;

import java.util.Date;

/**
 * Persons实体类
 * 
 * @author hongwei.lian
 * 2017年11月23日 下午12:45:31
 */
public class Person {
	
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private Integer age;
	
	private Date birthday;
	
	private String address;
	
	/**
	 * 操作类型
	 */
	private int operateType;
	
	public Person() {}

	public Person(Integer id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Person(Integer id, String firstName, String lastName, Integer age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getOperateType() {
		return operateType;
	}

	public void setOperateType(int operateType) {
		this.operateType = operateType;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", birthday=" + birthday + ", address=" + address + ", operateType=" + operateType + "]";
	}
	
}
