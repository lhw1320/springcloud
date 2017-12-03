package com.qdfae.spring.conditional;

/**
 * Windows下所要创建的Bean类
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午6:03:13
 */
public class WindowsListService implements ListService {

	/**
	 * showListCmd()方法
	 */
	@Override
	public String showListCmd() {
		return "dir";
	}

}
