package com.qdfae.jdk.enums;

public enum ReleaseStatusEnum {
	
	无放款(0),
	未放款(1),
	处理中(2),
	放款成功(3),
	放款失败(4);
	
	public int value;

    private ReleaseStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
