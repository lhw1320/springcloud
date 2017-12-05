package com.qdfae.jdk.enums;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * 操作类型枚举
 * 
 * @author hongwei.lian
 * 2017年12月5日 上午11:18:09
 */
public enum OperateTypeEnum {
	
	UPDATE_OPERATE(1, "更新操作"), 
	
	INSERT_OPERATE(2, "新增操作");

	private int code;
	
	private String desc;

	OperateTypeEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	/**
	 * 根据code获取对应的OperateTypeEnum实例
	 * 
	 * @param code
	 * @return
	 * @author hongwei.lian
	 * 2017年12月5日 上午11:19:17
	 */
	public static OperateTypeEnum acquireByCode(int code) {
        Optional<OperateTypeEnum> tccActionEnum =
        		Arrays.stream(OperateTypeEnum.values())
                           .filter(value -> Objects.equals(value.getCode(), code))
                           .findFirst();
        return tccActionEnum.orElse(OperateTypeEnum.UPDATE_OPERATE);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
