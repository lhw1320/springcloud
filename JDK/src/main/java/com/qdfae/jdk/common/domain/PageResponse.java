package com.qdfae.jdk.common.domain;

import com.qdfae.jdk.support.ResponseCodeBase;
import com.qdfae.jdk.support.ResponseCodeProperties;

public class PageResponse<T> extends DataResponse<T> {
	
	/**
	 * @author hongwei.lian
	 * 2018年2月13日 下午7:15:58
	 */
	private static final long serialVersionUID = 6057276393145634080L;
	
	private long totalsize;
	private long totalpage;

	public long getTotalsize() {
		return this.totalsize;
	}

	public PageResponse<T> setTotalsize(long totalsize) {
		this.totalsize = totalsize;
		return this;
	}

	public long getTotalpage() {
		return totalpage;
	}

	public PageResponse<T> setTotalpage(long totalpage) {
		this.totalpage = totalpage;
		return this;
	}

	@Override
	public PageResponse<T> setData(T data) {
		super.setData(data);
		return this;
	}

	@Override
	public PageResponse<T> setRetcode(int responseCode) {
		super.setRetcode(responseCode);
		return this;
	}

	@Override
	public PageResponse<T> setMsg(String message) {
		super.setMsg(message);
		return this;
	}

	public static <T> PageResponse<T> create() {
		return new PageResponse<>();
	}

	public static <T> PageResponse<T> emptyParamter() {
		PageResponse<T> response = new PageResponse<>();
		response.setRetcode(ResponseCodeBase.SYSTEM_PARAMETERS_EMPTY);
		response.setMsg(ResponseCodeProperties.getProperty(response.getRetcode()));
		return response;
	}

}
