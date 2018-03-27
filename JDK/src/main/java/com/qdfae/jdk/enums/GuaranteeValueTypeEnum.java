package com.qdfae.jdk.enums;

public enum GuaranteeValueTypeEnum {
	金额(1), 百分比(2);
	public int type;
	
	private GuaranteeValueTypeEnum(int type){
		this.type = type;
	}
	
	public int getType(){
		return this.type;
	}

}
