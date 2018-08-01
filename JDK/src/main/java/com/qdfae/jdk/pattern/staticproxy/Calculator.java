package com.qdfae.jdk.pattern.staticproxy;

/**
 * 静态代理
 *
 * @author hongwei.lian
 * @date 2018年7月31日 上午11:09:59
 */
public interface Calculator {
	
    //需要代理的接口
    int add(int a, int b);
    
    //接口实现类,执行真正的a+b操作
    public static class CalculatorImpl implements Calculator{
        
    	@Override
        public int add(int a, int b) {
            System.out.println("doing");
            return a+b;
        }
        
    }
    
    //静态代理类的实现.代码已经实现好了.
    public static class CalculatorProxy implements Calculator{
    	
        private Calculator calculator;
        
        public CalculatorProxy(Calculator calculator) {
            this.calculator=calculator;
        }
        @Override
        public int add(int a, int b) {
            //执行一些操作
            System.out.println("begin");
            int result = calculator.add(a, b);
            System.out.println("end");
            return result;
        }
        
    }
    
}
