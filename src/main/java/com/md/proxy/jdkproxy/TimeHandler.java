package com.md.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 
 * JDK动态代理
 * 1.只能代理实现了接口的类
 * 2.没有实现接口的类不能实现JDK的动态代理
 * @version 1.0.0 TimeHandler.java 2014-11-30 下午5:32:59
 */
public class TimeHandler implements InvocationHandler {

	public TimeHandler(Object target) {
		super();
		this.target = target;
	}

	private Object target;
	
	/**
	 * 在method.invoke(target, args); 前后实现该handler的业务逻辑
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		System.out.println("时间代理开始");
		method.invoke(target, args);
		long end = System.currentTimeMillis();
		System.out.println("时间代理：运行" + (end - start) + "微秒 ！！！");
		return null;
	}

}
