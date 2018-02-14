package com.qdfae.jdk.logger;

import java.math.BigDecimal;
import java.util.Map;

import org.slf4j.event.Level;

import com.qdfae.jdk.utils.NumberUtil;

public abstract class XMsgBase {
	private String logName= null;
	//请求类型配置
	private Map<String, String> requestTypeMap ;
	protected final static String _SepChar_Segment = "  ";
	protected final static String _SepChar_Start = "(";
	protected final static String _SepChar_End = ")";
	protected final static String _SepChar_More = " # ";
	private Level logLevel= Level.INFO;
	//执行的classname
	private String excuteClass="-";
	//执行的methodname
	private String excuteMethod="-";
	//响应-耗时
	private double reponseTimeMillis=0;
	//日志更多内容
	private Object[] moreMsg;
	
	private long startTime;
	
	private long endTime;
	
	private Throwable exception;
	
	public String getLogName() {
		return logName;
	}

	public XMsgBase setLogName(String logName) {
		this.logName = logName;
		return this;
	}

	public Level getLogLevel() {
		return logLevel;
	}

	public XMsgBase setLogLevel(Level logLevel) {
		this.logLevel = logLevel;
		return this;
	}

	public String getExcuteClass() {
		return excuteClass;
	}

	public XMsgBase setExcuteClass(String excuteClass) {
		this.excuteClass = excuteClass;
		return this;
	}

	public String getExcuteMethod() {
		return excuteMethod;
	}

	public XMsgBase setExcuteMethod(String excuteMethod) {
		this.excuteMethod = excuteMethod;
		return this;
	}

	public double getReponseTimeMillis() {
		if(reponseTimeMillis<=0){
			if(this.startTime==0) this.startTime=System.currentTimeMillis();
			if(this.endTime==0) this.endTime=System.currentTimeMillis();
			this.reponseTimeMillis = this.endTime - this.startTime;
		}
		return NumberUtil.getScale(new BigDecimal(reponseTimeMillis/1000.0),3).doubleValue();
	}

	public XMsgBase setReponseTimeMillis(double reponseTimeMillis) {
		this.reponseTimeMillis = reponseTimeMillis;
		return this;
	}

	public Object[] getMoreMsg() {
		return moreMsg;
	}

	public XMsgBase setMoreMsg(Object[] moreMsg) {
		this.moreMsg = moreMsg;
		return this;
	}

	public long getStartTime() {
		return startTime;
	}

	public XMsgBase setStartTime(long startTime) {
		this.startTime = startTime;
		return this;
	}

	public long getEndTime() {
		return endTime;
	}

	public XMsgBase setEndTime(long endTime) {
		this.endTime = endTime;
		return this;
	}
	

	public Map<String, String> getRequestTypeMap() {
		return requestTypeMap;
	}

	public XMsgBase setRequestTypeMap(Map<String, String> requestTypeMap) {
		this.requestTypeMap = requestTypeMap;
		return this;
	}

	/**
	 * info信息
	 * @return
	 * @return String
	 * @author yuhui.tang
	 * 2015年11月18日 上午11:10:07
	 */
	public abstract String toMessage(boolean isDebugEnabled);

	public Throwable getException() {
		return exception;
	}

	public XMsgBase setException(Throwable exception) {
		this.exception = exception;
		return this;
	}
}

