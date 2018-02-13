package com.qdfae.jdk.repayPlan;

/**
 * 融资期限类型
 * 
 * @author hongwei.lian 
 * @date 2018年2月13日 下午10:31:37
 */
public enum ProjectLimitTypeEnum {
	
	天(1),
	月(2),
	年(3);
	
	public Integer value;
	
	private ProjectLimitTypeEnum(Integer value){
		this.value = value;
	}
	
	public static ProjectLimitTypeEnum getProjectLimitType(Integer value){
		if(value == null) {
			return ProjectLimitTypeEnum.天;
		}
		for(ProjectLimitTypeEnum desc : ProjectLimitTypeEnum.values()){
			if(desc.value == value){
				return desc;
			}
		}
		return ProjectLimitTypeEnum.天;
	}
	
	public int getType() {
		return value;
	}

}
