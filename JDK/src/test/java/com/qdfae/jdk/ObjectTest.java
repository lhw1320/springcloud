package com.qdfae.jdk;

import org.junit.Test;

public class ObjectTest {
	
	@Test
	public void test1(){
		String id1 = "217393201702192";
		int hashCode1 = id1.hashCode();
		System.out.println(hashCode1);
		
		String id2 = "217393201702102";
		int hashCode2 = id2.hashCode();
		System.out.println(hashCode2);
	}

}
