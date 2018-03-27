package com.qdfae.jdk.enums;

public enum DrawbackStatusEnum {
	无退款(0),未退款(1), 退款处理中(2), 退款成功(3),部分退款(5),退款失败(4);

	public int status;

	private DrawbackStatusEnum(int status) {

		this.status = status;
	}

	public int getStatus() {
		return status;
	}

}
