package com.qdfae.jdk.exception;

import com.qdfae.jdk.support.ResponseCodeBase;

/**
 * 
 * 
 * @author hongwei.lian
 * 2018年2月7日 下午8:09:49
 */
public class EmptyParameterException extends BayMaxBaseException {

	/**
	 * @author hongwei.lian
	 * 2018年2月7日 下午8:06:44
	 */
	private static final long serialVersionUID = 6802077934469903961L;

	/**
	 * 重写构造方法
	 * 
	 * @author hongwei.lian
	 * 2018年2月7日 下午8:09:59
	 */
	public EmptyParameterException() {
		super(ResponseCodeBase.SYSTEM_PARAMETERS_EMPTY, null);
	}

}
