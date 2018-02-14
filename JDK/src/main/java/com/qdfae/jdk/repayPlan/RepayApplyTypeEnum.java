package com.qdfae.jdk.repayPlan;

/**
 * 还款方式
 * 
 * @author hongwei.lian
 * 2018年2月14日 上午10:42:48
 */
public enum RepayApplyTypeEnum {

	按期还款(1),
	提前还款(2),
	逾期还款(3);
	
	public int value;
	
	private RepayApplyTypeEnum(int value){
		this.value = value;
	}
	
	public static RepayApplyTypeEnum fromValue(int value) {
		for(RepayApplyTypeEnum preRepayType : RepayApplyTypeEnum.values()) {
			if(value == preRepayType.value) {
				return preRepayType;
			}
		}
		return null;
	}
	
}
