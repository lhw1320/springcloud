package com.qdfae.spring.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * 控制器基类
 *
 * @author hongwei.lian
 * @date 2018年3月21日 下午7:14:07
 */
@Controller
public class BaseController {
	
	/**
	 * 当前线程request对象
	 */
	private ThreadLocal<HttpServletRequest> currentRequest = new ThreadLocal<HttpServletRequest>();
	
	/**
	 * 当前线程response对象
	 */
	private ThreadLocal<HttpServletResponse> currentResponse = new ThreadLocal<HttpServletResponse>();
	
	/**
	 * 初始化request对象和response对象
	 *
	 * @param request
	 * @param response
	 * @author hongwei.lian
	 * @date 2018年3月21日 下午7:16:51
	 */
	@ModelAttribute
	public void setHttpServletRequestAndResponse(HttpServletRequest request,HttpServletResponse response){
		currentRequest.set(request);
		currentResponse.set(response);
	}
	
	/**
	 * 获取request
	 *
	 * @return
	 * @author hongwei.lian
	 * @date 2018年3月21日 下午7:17:50
	 */
	public HttpServletRequest request() {
	    return currentRequest.get();
	}
	
	/**
	 * 获取response
	 *
	 * @return
	 * @author hongwei.lian
	 * @date 2018年3月21日 下午7:18:05
	 */
	public HttpServletResponse response(){
		return currentResponse.get();
	}
	
	/**
	 * https://blog.csdn.net/lovesomnus/article/details/78873089
	 * 
	 * 
	 * 
	 * 
	 */

}
