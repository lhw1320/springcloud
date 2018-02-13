package com.qdfae.jdk.repayPlan;

/**
 * 计息方式 
 * 
 * @author hongwei.lian 
 * @date 2018年2月13日 下午10:28:57
 */
public enum InterestTypeEnum {
	
	按日计息(1),
	按月计息(2),
	按年计息(3);
	
	public int value;
	
	private InterestTypeEnum(int value){
		this.value = value;
	}
	
	public static InterestTypeEnum getInterestType(Integer value){
		if(value == null) {
			return null;
		}
		for(InterestTypeEnum desc: InterestTypeEnum.values()){
			if(desc.value == value){
				return desc;
			}
		}
		return null;
	}

}
