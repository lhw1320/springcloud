package com.qdfae.jdk.exception;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

/**
 * SubAutoCloseable
 *
 * @author hongwei.lian
 * @date 2018年9月11日 下午3:00:06
 */
public class SubAutoCloseable implements AutoCloseable {
	
	protected AutoCloseable autoCloseable;
	
	public SubAutoCloseable() {}
	
	public SubAutoCloseable(AutoCloseable autoCloseable) {
        this.autoCloseable = autoCloseable;
    }

	/**
	 * 读取资源
	 *
	 * @author hongwei.lian
	 * @date 2018年9月11日 下午2:59:31
	 */
	public void readResouse() {
        System.out.println("正在读取资源");
    }
	
	/**
	 * 关闭资源
	 *
	 * @throws Exception
	 * @author hongwei.lian
	 * @date 2018年9月11日 下午2:59:31
	 */
    @Override
    public void close() throws Exception {
        System.out.println("关闭资源");
    }

}
