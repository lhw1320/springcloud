package com.qdfae.jdk.support;

import javax.ws.rs.core.Cookie;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.huajin.baymax.encrypt.IrreversibEncrypt;
import com.huajin.baymax.logger.XMsgBaseSimlpe;
import com.qdfae.jdk.logger.Xlogger;

public class SessionFactory {
	
	public static final ThreadLocal<String> sessionid = new ThreadLocal<String>();
	
	protected static Logger log = LogManager.getLogger(SessionFactory.class);
	
	//sessionkey
	private static String sessionKey;
	
	//cookieDomain
	private static String cookieDomain = "";
	
	private static String cookiePath = "/";
	
	//cookie超时时间 -1 为永不超时
	private static int maxAge = -1;

	/**
	 * 授权key
	 */
	private static String authorizedKey = "userwebauth";
	/**
	 * 授权值的长度
	 */
	private static int authorizedLength = 16;
	static {
		try {
			sessionKey = ConfigProperties.getProperty("userweb.sessionKey", "USERWEBSESIONID");
			cookieDomain = ConfigProperties.getProperty("userweb.cookieDomain");
			if (cookieDomain == null) {
				cookieDomain = "";
			}
			cookiePath = ConfigProperties.getProperty("userweb.cookiePath");
			if (cookiePath == null || cookiePath.trim().length() == 0) {
				cookiePath = "/";
			}

			authorizedKey = ConfigProperties.getProperty("userweb.authorizedKey","userwebauth");
			if (authorizedKey != null && authorizedKey.trim().length() > 0) {
				authorizedKey = IrreversibEncrypt.get16MD5String(authorizedKey);
			}
		} catch (Exception e) {
			Xlogger.log(XMsgBaseSimlpe.build(SessionFactory.class.getName(), "", "Can not load session Config. Use Default."));
		}
	}

	/**
	 * 获取当前sessionID 如果cookie中没有 将会在 threadLocal中获取
	 * 
	 * @return
	 */
	public static String getCurrentSessionId(HttpServletRequest request,HttpServletResponse response) {
		String sessionId = getCurrentSessionIdCookie(request, response);
		if (StringUtils.isBlank(sessionId)) {
			createSesionId(response);
			sessionId = sessionid.get();
		}
		return sessionId;
	}
	
	/**
	 * 创建sessionid
	 * @return void
	 * @author wenqiang
	 * 2015年5月25日 下午7:44:02
	 */
	public static void createSesionId(HttpServletResponse response) {
		String sessionId = buildSessionId();
		Cookie mycookies = new Cookie(sessionKey, sessionId);
		mycookies.setMaxAge(maxAge);
		mycookies.setDomain(cookieDomain);
		mycookies.setPath(cookiePath);
		mycookies.setHttpOnly(true);
		response.addCookie(mycookies);
		/**
		 * 重新设置sessionid
		 */
		sessionid.remove();
		sessionid.set(sessionId);
	}

	/**
	 * 获取包含sessionid的Cookie value
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public static String getCurrentSessionIdCookie(HttpServletRequest request,HttpServletResponse response) {
		Cookie cookies[] = request.getCookies();
		Cookie mycookie = null;
		String sessionId = "";
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				mycookie = cookies[i];
				if (sessionKey.equals(mycookie.getName())) {
					sessionId = mycookie.getValue();
					break;
				}
			}
		}
		if (sessionId != null && sessionId.trim().length() != 0) {
			/**
			 * sessionid验证失败，重新生成sessionid
			 */
			if (!checkSessionId(sessionId)) {
				Cookie mycookies = new Cookie(sessionKey, sessionId);
				mycookies.setMaxAge(0);
				mycookies.setDomain(cookieDomain);
				mycookies.setPath(cookiePath);
				mycookies.setHttpOnly(true);
				response.addCookie(mycookies);
				return null;
			}
		}
		return sessionId;
	}

	/**
	 * 创建新的sessionID
	 * 
	 * @return
	 */
	private static String buildSessionId() {
		String sessionId = UUID.randomUUID().toString().toUpperCase();
		if (authorizedKey != null && authorizedKey.length() > 0) {
			StringBuilder sb = new StringBuilder(60);
			sb.append(authorizedKey);
			sb.append("-");
			sb.append(sessionId);
			sessionId = sb.toString();
		}
		return sessionId;
	}

	/**
	 * 检验sessionID是否合法
	 * 
	 * @param sessionId
	 * @return
	 */
	private static boolean checkSessionId(String sessionId) {
		if (authorizedKey != null && authorizedKey.length() > 0) {
			if (sessionId.trim().length() < authorizedLength) {
				return false;
			}
			String key = sessionId.substring(0, authorizedLength);
			if (authorizedKey.equals(key)) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * 获取当前session
	 * 
	 * @return
	 */
	public static HttpSessionWrapper getSession(HttpServletRequest request,HttpServletResponse response) {
		String sessionId = getCurrentSessionId(request, response);
		request = new HttpRequestWrapper(sessionId, request);
		HttpSession session = request.getSession();
		if (session != null) {
			if (session instanceof HttpSessionWrapper) {
				return (HttpSessionWrapper) session;
			}
		}
		return null;
	}
	
	/**
	 * 创建普通的cookie对象
	 * @return void
	 * @author wenqiang
	 * 2015年5月25日 下午7:47:55
	 */
	public static void createCookie(String name,String value,HttpServletResponse response){
		
		Cookie mycookie = new Cookie(name, value);
		mycookie.setMaxAge(maxAge);
		mycookie.setDomain(cookieDomain);
		mycookie.setPath(cookiePath);
		mycookie.setHttpOnly(true);
		response.addCookie(mycookie);
	}
	
}