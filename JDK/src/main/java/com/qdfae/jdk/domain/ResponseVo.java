package com.qdfae.jdk.domain;

import java.io.Serializable;

/**
 * 
 *
 * @author hongwei.lian
 * @date 2018年3月2日 下午3:28:51
 */
public class ResponseVo<T> implements Serializable {
	
	private static final long serialVersionUID = -5018218055742995923L;

	public static final int SUCCESS = 0;
    
    public static final int FAIL = -1;
    
    public static final String SUCCESS_MSG = "Ok";

    private int retcode;
    
    private String msg;
    
    private T data;

    public ResponseVo() {
    	
    }

    public ResponseVo(int retcode, String msg, T data) {
        this.retcode = retcode;
        this.msg = msg;
        this.data = data;
    }

    public ResponseVo(int retcode, T data) {
        this.retcode = retcode;
        this.data = data;
    }

    public int getRetcode() {
        return retcode;
    }

    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseVo{" +
                "retcode=" + retcode +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
    
}

