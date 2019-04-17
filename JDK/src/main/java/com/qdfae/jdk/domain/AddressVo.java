package com.qdfae.jdk.domain;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressVo implements Serializable {
	
	static final long serialVersionUID = 3965029770139920197L;

	Integer proId;
	
	Integer cityId;
	
	Integer disId;

}
