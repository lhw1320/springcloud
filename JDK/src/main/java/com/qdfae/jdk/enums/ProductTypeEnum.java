package com.qdfae.jdk.enums;

public enum ProductTypeEnum {
	
	债务融资计划(1),
	金融资产转让(2),
	金融产品发行(3);
	
	public int value;

    private ProductTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public static int getMenuAdminType(Integer type) {
		if(type != null) {
			if(type.intValue() == ProductTypeEnum.债务融资计划.value) {
				return 3;
			}else if(type.intValue() == ProductTypeEnum.金融资产转让.value){
				return 4;
			}else if(type.intValue() == ProductTypeEnum.金融产品发行.value) {
				return 5;
			}
		}
		return 2; //普通业务
	}
    
    public static String getDesc(int value) {
    	ProductTypeEnum[] array = ProductTypeEnum.values();
    	for(int i=0; i<array.length; i++) {
    		if(array[i].value == value) {
    			return array[i].toString();
    		}
    	}
    	return "";
    }

}
