package com.qdfae.jdk.common.domain;

import java.io.Serializable;

import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;

import com.qdfae.jdk.support.JSONAssister;
import com.qdfae.jdk.support.ResponseCodeBase;
import com.qdfae.jdk.support.ResponseCodeProperties;

public class BaseResponse implements Serializable {

	/**
	 * @author hongwei.lian
	 * 2018年2月13日 下午7:02:42
	 */
	private static final long serialVersionUID = 7527047218922313762L;
	
	private int retcode;
	private String msg;
	
	public static BaseResponse build() {
		return new BaseResponse();
	}
	
	public static <T extends BaseResponse> T build(Class<T> c){
		try {
			return c.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
		}
		return null;
	}
	

	public int getRetcode() {
		return retcode;
	}

	public BaseResponse setRetcode(int retcode) {
		this.retcode = retcode;
		return this;
	}

	public String getMsg() {
		if(StringUtils.isEmpty(msg)) {
			return ResponseCodeProperties.getProperty(retcode);
		}
		return msg;
	}

	public BaseResponse setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public Response toResponse() {
		return JSONAssister.buildResponse(this).build();
	}
	
	public boolean isOk() {
		return this.retcode == ResponseCodeBase.OK;
	}

}
