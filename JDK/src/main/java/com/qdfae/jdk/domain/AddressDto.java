package com.qdfae.jdk.domain;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressDto implements Serializable {
	
    static final long serialVersionUID = 8635711165651948750L;

    Integer proId;
	
	Integer cityId;
	
	Integer disId;

}
