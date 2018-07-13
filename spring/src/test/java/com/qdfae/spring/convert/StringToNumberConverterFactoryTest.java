package com.qdfae.spring.convert;

import java.math.BigDecimal;

import org.junit.Test;

public class StringToNumberConverterFactoryTest {
	
	@Test
	public void testStringToNumber() {
		BigDecimal val = new BigDecimal("10,000.00");
	    System.out.println(val);	
	}
	
}




