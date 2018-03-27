package com.qdfae.jdk.enums;

public enum PayStatusEnum {
	
	无需支付(0),
	待支付(1),
	支付成功(2),
	处理中(3),
	支付失败(4),
	部分支付(5);
	public int status;
	
	private PayStatusEnum(int status){
		this.status = status;
	}

	public int getStatus() {
		return status;
	}
	
	public static PayStatusEnum getDesc(int status){
		for(PayStatusEnum desc : PayStatusEnum.values()){
			if(desc.status == status){
				return desc;
			}
		}
		return null;
	}

}
