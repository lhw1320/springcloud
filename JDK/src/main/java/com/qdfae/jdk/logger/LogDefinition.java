package com.qdfae.jdk.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogDefinition {
	
	/**
     * 默认info日志
     */
    protected static final Logger InfoLog = getLogger("info");
    /**
     * 默认错误日志
     */
    protected static final Logger ErrorLog = getLogger("error");
	
	protected static Logger getLogger(String name){
		return LoggerFactory.getLogger(name);
	}

}
