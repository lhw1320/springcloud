package com.qdfae.jdk.domain;

import java.io.Serializable;
import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
public class UserDto implements Serializable {
	
	static final long serialVersionUID = -1878900484212180065L;

	String name;
	
    Integer age;
	
	List<AddressDto> addressDtos;

}
