package com.qdfae.jdk.enums;

public enum EncodingType {
	
	GBK("01"),
	UTF8("02"),
	UNICODE("03"),
	ISO_8859_1("04");
	
	private EncodingType(String type){
		this.type = type;
	}
	
	private String type;

	public String getType() {
		return type;
	}

}
