package com.qdfae.jdk.enums;

public enum TransferTypeEnum {
拆分转让 (1), 整体转让(2);
	
	public int type;
	
	private TransferTypeEnum(int type){
		this.type = type;
	}
	
	public int getType(){
		return this.type;
	}
	
	public static String getDesc(Integer value) {
		if(value == null)
			return "";
		TransferTypeEnum[] array = TransferTypeEnum.values();
    	for(int i=0; i<array.length; i++) {
    		if(array[i].type == value) {
    			return array[i].toString();
    		}
    	}
    	return "";
    }

}
