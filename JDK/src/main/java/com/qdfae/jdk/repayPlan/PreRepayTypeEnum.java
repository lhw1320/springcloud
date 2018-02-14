package com.qdfae.jdk.repayPlan;

/**
 * 提前还款方式
 * 
 * @author hongwei.lian
 * 2018年2月14日 上午10:44:37
 */
public enum PreRepayTypeEnum {

	一次性提前还清(1),
	部分提前还款(2);
	
	public int value;
	
	private PreRepayTypeEnum(int value){
		this.value = value;
	}
	
	public static PreRepayTypeEnum fromValue(int value) {
		for(PreRepayTypeEnum preRepayType : PreRepayTypeEnum.values()) {
			if(value == preRepayType.value) {
				return preRepayType;
			}
		}
		return null;
	}
}
