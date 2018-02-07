package com.qdfae.jdk.exception;

import com.qdfae.jdk.support.ResponseCodeProperties;

/**
 * 异常基类
 * 用于逻辑判断抛出异常
 * 
 * @author hongwei.lian
 * 2018年2月7日 下午7:53:55
 */
public class BayMaxBaseException extends RuntimeException {

	/**
	 * @author hongwei.lian
	 * 2018年2月7日 下午7:53:48
	 */
	private static final long serialVersionUID = 6511639273645789855L;
	
	/**
	 * 错误返回码
	 */
	private int retCode;
	
	/**
	 * 异常
	 */
	private Throwable cause;
	
	/**
	 * 异常描述
	 */
	private String causeMessage;
	
	public BayMaxBaseException(Throwable cause) {
		super();
		this.cause = cause;
	}
	
	public BayMaxBaseException(int retCode, Throwable cause, String causeMessage) {
		super();
		this.retCode = retCode;
		this.cause = cause;
		this.causeMessage = causeMessage;
	}
	
	public BayMaxBaseException(int retCode, Throwable cause) {
		super();
		this.retCode = retCode;
		this.cause = cause;
		this.causeMessage = cause == null ? ResponseCodeProperties.getProperty(retCode) : cause.getMessage();
	}
	
	public int getRetCode() {
		return retCode;
	}

	public BayMaxBaseException setRetCode(int retCode) {
		this.retCode = retCode;
		return this;
	}

	public Throwable getCause() {
		return cause;
	}

	public BayMaxBaseException setCause(Throwable cause) {
		this.cause = cause;
		return this;
	}

	public String getCauseMessage() {
		return causeMessage;
	}

	public BayMaxBaseException setCauseMessage(String causeMessage) {
		this.causeMessage = causeMessage;
		return this;
	}

	@Override
	public String getMessage() {
		return this.causeMessage;
	}
	
}
