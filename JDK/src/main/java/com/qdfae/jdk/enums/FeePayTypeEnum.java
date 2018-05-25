package com.qdfae.jdk.enums;

public enum FeePayTypeEnum {
	
	线上(1),
	线下(2);
	
	private int value;
	
	private FeePayTypeEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
