package com.qdfae.spring.conditional;

/**
 * Linux下所要创建的Bean类
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午6:03:32
 */
public class LinuxListService implements ListService {

	/**
	 * showListCmd()方法
	 */
	@Override
	public String showListCmd() {
		return "ls";
	}

}
