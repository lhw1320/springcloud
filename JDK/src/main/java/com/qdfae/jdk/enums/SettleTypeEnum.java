package com.qdfae.jdk.enums;

public enum SettleTypeEnum {
场内结算(1),场外结算(2),场内间接结算(3);
	
	public int type;
	
	private SettleTypeEnum(int type){
		this.type = type;
	}
	
	public int getType(){
		return this.type;
	}
	
	public static String getDesc(Integer value) {
		if(value == null)
			return "";
		SettleTypeEnum[] array = SettleTypeEnum.values();
    	for(int i=0; i<array.length; i++) {
    		if(array[i].type == value) {
    			return array[i].toString();
    		}
    	}
    	return "";
    }

}
