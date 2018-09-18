package com.qdfae.jdk.enums;

public enum AuditStatusEnum {
	
	待提交(1), 
	已提交待审核(2), 
	审核退回(3), 
	审核通过(4), 
	审核不通过(5),;
	
	public int value;

	private AuditStatusEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
