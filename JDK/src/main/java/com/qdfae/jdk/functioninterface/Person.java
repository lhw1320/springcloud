package com.qdfae.jdk.functioninterface;

/**
 * Person实体类
 * @author hongwei.lian 
 * @date 2017年11月16日 上午12:09:08
 */
public class Person {
	
	private String firstName;
    
	private String lastName;
    
    public Person() {}
    
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
	
}
