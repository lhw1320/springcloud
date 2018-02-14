package com.qdfae.jdk.logger;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.event.Level;

import com.qdfae.jdk.exception.BayMaxBaseException;

public class Xlogger extends LogDefinition {
	/**
	 * 写入日志在指定的日志文件或info.log
	 * @param msg
	 * @return void
	 * @author yuhui.tang
	 * 2015年11月17日 下午5:11:42
	 */
	public static void log(XMsgBase msg) {
		Throwable t = msg.getException();
		//指定logger输出
		Logger logger = null;
		String logName = msg.getLogName();
		if(StringUtils.isNotBlank(logName)){
			logger = getLogger(logName);
		}
		if(logger == null){
			logger = InfoLog;
		}
		String message = msg.toMessage(logger.isDebugEnabled());
		Level level = msg.getLogLevel();
		if (StringUtils.isNotBlank(message)) {
			
			if(level == null)
				level = Level.INFO;
			switch(level) {
			case INFO:
				logger.info(message, t);
				break;
			case ERROR:
				logger.error(message, t);
				break;
			case WARN:
				logger.warn(message, t);
				break;
			case DEBUG:
				logger.debug(message, t);
				break;
			case TRACE:
				logger.trace(message, t);
				break;
			}
		}
	}
	/**
	 * 记录错误日志在error.log
	 * @param msg
	 * @return void
	 * @author yuhui.tang
	 * 2015年11月17日 下午5:49:56
	 */
	public static void error(XMsgBase msg) {
		String message = msg.toMessage(ErrorLog.isDebugEnabled());
		Throwable t = msg.getException();
		if(t instanceof BayMaxBaseException) {
			InfoLog.error(message, t);
		}else {
			ErrorLog.error(message, t);
		}
	}
}
