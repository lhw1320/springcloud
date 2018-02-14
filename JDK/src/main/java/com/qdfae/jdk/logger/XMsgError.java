package com.qdfae.jdk.logger;

import java.util.Map;

import org.slf4j.event.Level;

import com.qdfae.jdk.exception.BayMaxBaseException;
import com.qdfae.jdk.support.ConfigProperties;
import com.qdfae.jdk.utils.RequestResponseUtil;

public class XMsgError extends XMsgBase{
	//请求-URL
	private String requestURL="-";
	//请求-入参
	private Map<String, String[]> requestParamMap;
	//请求-来源地址
	private String requestRemoteAddress="-";
	
	private String appName;
	
	public static XMsgError build(){
		XMsgError msg =  new XMsgError();
		msg.setLogLevel(Level.ERROR);
		msg.setAppName(ConfigProperties.getProperty("productName"));
		return msg;
	}
	
	public static XMsgError buildSimple(String excuteClass, String excuteMethod, Throwable e){
		XMsgError msg =  new XMsgError();
		msg.setLogLevel(Level.ERROR);
		msg.setAppName(ConfigProperties.getProperty("productName"));
		msg.setExcuteClass(excuteClass);
		msg.setExcuteMethod(excuteMethod);
		msg.setException(e);
		return msg;
	}
	
	@Override
	public String toMessage(boolean isDebugEnabled){
		//#日志格式
		//[appName] [class] [method]
		//[request_url] [request_remoteaddress] [request_params] 
		//[exception]
		//[other msg # other msg]
		StringBuilder sb = new StringBuilder();
		sb.append(_SepChar_Start).append(this.getAppName()).append(_SepChar_End).append(_SepChar_Segment);
		sb.append(_SepChar_Start).append(this.getExcuteClass()).append(_SepChar_End).append(_SepChar_Segment);
		sb.append(_SepChar_Start).append(this.getExcuteMethod()).append(_SepChar_End).append(_SepChar_Segment);
		sb.append(_SepChar_Start).append(this.getRequestURL()).append(_SepChar_End).append(_SepChar_Segment);
		sb.append(_SepChar_Start).append(this.getRequestRemoteAddress()).append(_SepChar_End).append(_SepChar_Segment);
		sb.append(_SepChar_Start).append(RequestResponseUtil.getRequestParameters(this.getRequestParamMap(), isDebugEnabled)).append(_SepChar_End).append(_SepChar_Segment);
		Throwable exception = this.getException();
		if(exception instanceof BayMaxBaseException) {
    		BayMaxBaseException be = (BayMaxBaseException)exception;
    		sb.append(_SepChar_Start).append(exception.getClass().getName()).append(":").append(be.getRetCode()).append(",").append(be.getMessage()).append(_SepChar_End);
    	}else {
    		sb.append(_SepChar_Start).append(exception.getClass().getName()).append(":").append(exception.getMessage()).append(_SepChar_End);
    	}
		
		if(this.getMoreMsg() != null && this.getMoreMsg().length > 0){
			sb.append(_SepChar_Start);
			for (int i = 0; i < getMoreMsg().length; i++) {
				sb.append(getMoreMsg()[i].toString());
				if(i != getMoreMsg().length-1){
					sb.append(_SepChar_More);
				}
			}
			sb.append(_SepChar_End);
		}
		return sb.toString();
	}

	public String getRequestURL() {
		return requestURL;
	}

	public String getRequestRemoteAddress() {
		return requestRemoteAddress;
	}

	public String getAppName() {
		return appName;
	}

	public XMsgError setRequestURL(String requestURL) {
		this.requestURL = requestURL;
		return this;
	}

	public void setRequestRemoteAddress(String requestRemoteAddress) {
		this.requestRemoteAddress = requestRemoteAddress;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public Map<String, String[]> getRequestParamMap() {
		return requestParamMap;
	}

	public void setRequestParamMap(Map<String, String[]> requestParamMap) {
		this.requestParamMap = requestParamMap;
	}

}
