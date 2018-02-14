package com.qdfae.jdk.repayPlan;

public enum RepayTypeEnum {
	一次性还本付息(1),
	等额本息按月还款(2),
	等额本金按月还款(3),
	按月付息到期还本(4),
	按季付息到期还本(5),
	按年付息到期还本(6);
	
	public int value;
	
	private RepayTypeEnum(int status){
		this.value = status;
	}
	
	public static RepayTypeEnum getRepayType(Integer value){
		if(value == null) {
			return 一次性还本付息;
		}
		for(RepayTypeEnum desc : RepayTypeEnum.values()){
			if(desc.value == value){
				return desc;
			}
		}
		return 一次性还本付息;
	}

	public static String getDesc(Integer value) {
		if(value == null) {
			return "";
		}
		RepayTypeEnum[] array = RepayTypeEnum.values();
		for(int i=0; i<array.length; i++) {
			if(array[i].value == value) {
				return array[i].toString();
			}
		}
		return "";
	}
}