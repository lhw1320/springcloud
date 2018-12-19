package com.qdfae.jdk.enums;

/**
 * 还款计划计算周期模式
 *
 * @author hongwei.lian
 * @date 2018年9月21日 下午2:22:54
 */
public enum CalculatePeriodModeEnum {
	
	自然周期计算模式(1), 
	非自然周期计算模式(2);
	
	private int value;

    private CalculatePeriodModeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
}
