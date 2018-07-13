package com.qdfae.jdk.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserSealVo implements Serializable {
	private static final long serialVersionUID = -6306673951133452972L;
	Integer id;
	Integer userId;
	Integer trusteeship;
	Integer auditStatus;
	String remark;
	Date createTime;
	Integer createOperatorId;
	Date updateTime;
	Integer updateOperatorId;
	String phone;
	String address;
	String realName;
	
	public void test1() {
		this.getId();
	}
	
}
