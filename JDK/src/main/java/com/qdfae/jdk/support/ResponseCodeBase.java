package com.qdfae.jdk.support;

public class ResponseCodeBase {
	
	 public static final int ERROR = -1;
	 
	 public static final int OK = 0;
	 
	 /**
	  * 系统错误
	  */
	 public static final int SYSTEM_ERROR = 50000;
	 
	 public static final int FUNDBIZ_TRANSFER_ERROR = 50001;
	 
	 /**
	  * 系统参数为空
	  */
	 public static final int SYSTEM_PARAMETERS_EMPTY = 50002;
	 
	 public static final int SYSTEM_PARAMETERS_FORMAT_ERROR = 50003;
	 
	 public static final int FUNDBIZ_EMPTY_RESULT = 50004;
	 
	 public static final int RECORD_INSERT_FAILURE = 30002;
	 
	 public static final int RECORD_IS_NULL = 33001;
	 
	 public static final int RECORD_EXIST = 33002;
	 
	 public static final int TOKEN_INVALID = 10097;
	 
	 public static final int TOKEN_ADD_FAIURE = 10098;
	 
	 public static final int TOKEN_UPDATE_FAIURE = 10099;
	 
	 public static final int TOKEN_DELETE_FAILURE = 10100;

}
