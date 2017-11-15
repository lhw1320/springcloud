package com.qdfae.jdk.interfaces;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 
 * @author hongwei.lian 
 * @date 2017年11月15日 下午10:19:04
 */
public class FormulaTest {
	
	/**
	 *  测试
	 * @author hongwei.lian  
	 * @date 2017年11月15日 下午10:18:13
	 */
	@Test
	public void testCalculateAndSqrt() {
		Formula formula = new Formula() {
			
		    @Override
		    public double calculate(int number) {
		        return sqrt(number * 100);
		    }
		    
		};
		double calculate = formula.calculate(100);     
		double sqrt = formula.sqrt(16);
		assertTrue(calculate == 100.0);
		assertTrue(sqrt == 4.0);
	}

}
