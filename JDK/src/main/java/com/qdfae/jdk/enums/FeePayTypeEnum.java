package com.qdfae.jdk.enums;

/**
 * 费用支付方式
 * 
 * @author hongwei.lian 
 * @date 2018年5月27日 下午8:07:49
 */
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
