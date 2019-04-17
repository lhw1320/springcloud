package com.qdfae.jdk.domain;

import java.io.Serializable;
import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserVo implements Serializable {
	
	static final long serialVersionUID = 8335398772073310066L;

	String name;
	
    Integer age;
	
	List<AddressVo> addressVos;

}
