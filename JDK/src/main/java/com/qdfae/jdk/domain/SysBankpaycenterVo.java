package com.qdfae.jdk.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SysBankpaycenterVo implements Serializable {

	private static final long serialVersionUID = -2194847412712646173L;
	
	private Integer paycenterId;
	
	 private String payCenterName;
	 
	 @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	 private Date createTime;

	public SysBankpaycenterVo(Integer paycenterId, String payCenterName) {
		this.paycenterId = paycenterId;
		this.payCenterName = payCenterName;
	}

	public Integer getPaycenterId() {
		return paycenterId;
	}

	public void setPaycenterId(Integer paycenterId) {
		this.paycenterId = paycenterId;
	}

	public String getPayCenterName() {
		return payCenterName;
	}

	public void setPayCenterName(String payCenterName) {
		this.payCenterName = payCenterName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "SysBankpaycenterVo [paycenterId=" + paycenterId + ", payCenterName=" + payCenterName + ", createTime="
				+ createTime + "]";
	}
	 
}
