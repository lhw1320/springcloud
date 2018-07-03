package com.qdfae.jdk.domain;

public class PacketHeadItem {
	
public String defaultValue;//默认值
	
	public int length;

	public PacketHeadItem(String defaultValue, int length) {
		super();
		this.defaultValue = defaultValue;
		this.length = length;
	}

}
