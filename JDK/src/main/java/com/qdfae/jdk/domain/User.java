package com.qdfae.jdk.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * User实体类
 * 
 * @author hongwei.lian 
 * @date 2018年3月10日 上午12:33:22
 */
public class User implements Serializable {
	
	private static final long serialVersionUID = -7629758766870065977L;

	/**
	 * 用户ID
	 */
	private Integer id;
	
	/**
	 * 用户姓名
	 */
	private String userName;
	
	/**
	 * 用户代码
	 */
	private String userCode;
	
	private Date birthday;
	
	public User() {}
	
	public User(Integer id, String userName, String userCode) {
		this.id = id;
		this.userName = userName;
		this.userCode = userCode;
	}
	
	public User(Integer id, String userName, String userCode, Date birthday) {
		this.id = id;
		this.userName = userName;
		this.userCode = userCode;
		this.birthday = birthday;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * 针对userCode重写hashCode()方法
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userCode == null) ? 0 : userCode.hashCode());
		return result;
	}

	/**
	 * 针对userCode重写equals()方法
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userCode == null) {
			if (other.userCode != null)
				return false;
		} else if (!userCode.equals(other.userCode))
			return false;
		
		/*if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (userCode == null) {
			if (other.userCode != null)
				return false;
		} else if (!userCode.equals(other.userCode))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;*/
		
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userCode=" + userCode + "]";
	}
	
}
