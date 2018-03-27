package com.qdfae.jdk.enums;

public enum ProjectStatusEnum {
	
	未提交(1),
	待审批(4),
	审批退回(5),
	待发布(6),
	已发布(7),
	认购中(8),
	认购结束(9),
	发行成功(10),
	发行失败(-1),
	取消发行(-2),
	项目作废(-3);
	
	public int value;

    private ProjectStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static String getDesc(int value) {
    	ProjectStatusEnum[] array = ProjectStatusEnum.values();
    	for(int i=0; i<array.length; i++) {
    		if(array[i].value == value) {
    			return array[i].toString();
    		}
    	}
    	return "";
    }
    
    public static ProjectStatusEnum fromValue(int value) {
		for (ProjectStatusEnum item : ProjectStatusEnum.values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}

}
