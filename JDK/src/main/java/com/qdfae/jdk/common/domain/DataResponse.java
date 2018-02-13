package com.qdfae.jdk.common.domain;

import com.qdfae.jdk.support.ResponseCodeBase;
import com.qdfae.jdk.support.ResponseCodeProperties;

public class DataResponse<T> extends BaseResponse {
	
	/**
	 * @author hongwei.lian
	 * 2018年2月13日 下午7:14:10
	 */
	private static final long serialVersionUID = 7796247095786403153L;
	
	private T data;

	public T getData() {
		return data;
	}

	public DataResponse<T> setData(T data) {
		this.data = data;
		return this;
	}

	@Override
	public DataResponse<T> setRetcode(int responseCode) {
		super.setRetcode(responseCode);
		return this;
	}

	@Override
	public DataResponse<T> setMsg(String message) {
		super.setMsg(message);
		return this;
	}

	public static <T> DataResponse<T> create() {
		return new DataResponse<>();
	}

	public static <T> DataResponse<T> emptyParamter() {
		DataResponse<T> response = new DataResponse<>();
		response.setRetcode(ResponseCodeBase.SYSTEM_PARAMETERS_EMPTY);
		response.setMsg(ResponseCodeProperties.getProperty(response.getRetcode()));
		return response;
	}

}
