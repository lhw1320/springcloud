package com.qdfae.jdk.thread.exchanger;

import java.util.concurrent.Exchanger;

import org.junit.Test;

public class ExchangerTest {
	
	@Test
	public void test() {
		Exchanger<String> exchanger = new Exchanger<>();
		
		System.out.println(exchanger);
	}

}
