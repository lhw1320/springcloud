package com.qdfae.jdk.pattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.qdfae.jdk.pattern.staticproxy.Calculator;

/**
 * 动态代理
 * 
 * https://zhuanlan.zhihu.com/p/28870960
 *
 * @author hongwei.lian
 * @date 2018年7月31日 上午11:13:10
 */
public class ProxyFactory implements InvocationHandler {
    
	private Class<?> target;
    
    private Object real;
    
    //委托类class
    public ProxyFactory(Class<?> target){
        this.target=target;
    }
	
    //实际执行类bind
    public  Object bind(Object real){
        this.real=real;
        //利用JDK提供的Proxy实现动态代理
        return  Proxy.newProxyInstance(target.getClassLoader(),new Class[]{target},this);
    }
    
    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
		//代理环绕
        System.out.println("begin");
        //执行实际的方法
        Object invoke = method.invoke(real, args);
        System.out.println("end");
        return invoke;
    }

    public static void main(String[] args) {
        Calculator proxy =(Calculator) new ProxyFactory(Calculator.class).bind(new Calculator.CalculatorImpl());
        proxy.add(1,2);
    }
    
}
