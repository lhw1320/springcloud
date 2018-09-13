package com.qdfae.jdk.exception;

import java.io.OutputStream;

public class SmallSubAutoCloseable extends SubAutoCloseable {
	
	public SmallSubAutoCloseable(AutoCloseable autoCloseable) {
		super(autoCloseable);
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
