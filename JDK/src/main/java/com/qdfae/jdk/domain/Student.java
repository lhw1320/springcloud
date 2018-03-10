package com.qdfae.jdk.domain;

import java.util.Date;

import com.qdfae.jdk.enums.OperateTypeEnum;

public class Student {
	
    private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private Integer age;
	
	private Date birthday;
	
	private String address;
	
	/**
	 * 操作类型
	 */
	private OperateTypeEnum operateType;

	public Student() {}

	public Student(Integer id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public OperateTypeEnum getOperateType() {
		return operateType;
	}

	public void setOperateType(OperateTypeEnum operateType) {
		this.operateType = operateType;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", birthday=" + birthday + ", address=" + address + ", operateType=" + operateType + "]";
	}
	
}
