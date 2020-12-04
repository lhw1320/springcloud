package com.qdfae.reflect.entity;

/**
 * 用户实体
 *
 * @author hongwei.lian
 * @date 2020年11月4日 下午12:19:42
 */
public class User {
	
	private Integer id;
	
	private String name;
	
	private String desc;
	
	User(Integer id) {
		this.id = id;
	}
	
	private User() {}
	
	protected User(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public User(Integer id, String name, String desc) {
		this.id = id;
		this.name = name;
		this.desc = desc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
