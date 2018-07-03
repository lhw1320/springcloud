package com.qdfae.jdk.enums;

public enum PingAnApp {
	
SYS_YQZL("01","银企直连");
	
	private String appId;
	
	private String appDesc;
	
	private PingAnApp(String appId,String appDesc){
		this.appId = appId;
		this.appDesc = appDesc;
	}

	public String getAppId() {
		return appId;
	}

	public String getAppDesc() {
		return appDesc;
	}

}
