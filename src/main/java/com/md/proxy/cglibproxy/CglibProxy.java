package com.md.proxy.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/**
 * 
 * cglib
 * 1. 针对类来实现代理的
 * 2. 对指定目标类产生一个子类，通过方法拦截技术拦截所有父类方法的调用
 * @version 1.0.0 CglibProxy.java 2014-11-30 下午5:26:29
 */
public class CglibProxy implements MethodInterceptor {
	
	private Enhancer enhancer = new Enhancer();
	
	/**
	 * 
	  * 创建clazz的子类
	  * @param clazz
	  * @return    
	  * @return Object
	 */
	public Object getProxy(Class<?> clazz){
		//设置创建子类的类
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return enhancer.create();
	}

	public Object intercept(Object obj, Method m, Object[] args, MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("实际类方法调用前，cglib 代理类逻辑");
		proxy.invokeSuper(obj, args);
		System.out.println("实际类方法调用后，cglib 代理类逻辑");
		return null;
	}

}
