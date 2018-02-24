package com.qdfae.jdk.enums;

/**
 * 融资期限类型
 * 
 * @author hongwei.lian
 * 2018年2月24日 下午5:39:04
 */
public enum TimeLimitTypeEnum {
	
	天(1),
	月(2),
	年(3);
	
	private Integer value;
	
	private TimeLimitTypeEnum(Integer value){
		this.value = value;
	}
	
	public static TimeLimitTypeEnum getTimeLimitType(Integer value){
		if(value == null) {
			return TimeLimitTypeEnum.天;
		}
		for(TimeLimitTypeEnum desc : TimeLimitTypeEnum.values()){
			if(desc.value == value){
				return desc;
			}
		}
		return TimeLimitTypeEnum.天;
	}
	
	public int getValue() {
		return value;
	}

}
