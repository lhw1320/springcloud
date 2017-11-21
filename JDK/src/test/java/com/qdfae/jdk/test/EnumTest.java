package com.qdfae.jdk.test;

import org.junit.Test;

public class EnumTest {
	
	/**
	 * 操作类型内部枚举
	 * @author hongwei.lian
	 * 2017年11月21日 下午7:29:43
	 */
	private enum operateType {
		UPDATE_OPERATE(1), INSERT_OPERATE(2);
		
		private int value;
		 
	    private operateType(int value) {
	        this.value = value;
	    }
	 
	    public int getValue() {
	        return value;
	    }
		
	}
	
	@Test
	public void testEnum(){
		//EnumTest.operateType = 
	}

}
