package com.qdfae.jdk.common.domain;

import java.io.Serializable;
import java.util.List;

public class PageData<T> implements Serializable{
	
	/**
	 * @author hongwei.lian
	 * 2018年2月13日 下午7:17:16
	 */
	private static final long serialVersionUID = 161956811375811751L;

	private long totalsize;
	
	private long totalpage;
	
	private List<T> list;
	
	public PageData() {}
	
	public PageData(long totalsize, long totalpage, List<T> list) {
		super();
		this.totalsize = totalsize;
		this.totalpage = totalpage;
		this.list = list;
	}
	
	public long getTotalsize() {
		return totalsize;
	}
	
	public long getTotalpage() {
		return totalpage;
	}
	
	public List<T> getList() {
		return list;
	}
	
	public void setTotalsize(long totalsize) {
		this.totalsize = totalsize;
	}
	
	public void setTotalpage(long totalpage) {
		this.totalpage = totalpage;
	}
	
	public void setList(List<T> list) {
		this.list = list;
	}
	
}

