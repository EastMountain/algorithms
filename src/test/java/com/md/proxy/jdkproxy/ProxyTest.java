package com.md.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import junit.framework.TestCase;

import com.md.proxy.sta.Car;
import com.md.proxy.sta.Movable;

public class ProxyTest extends TestCase{

	public void testProxy(){
		Car car = new Car();
		//此处的TimeHandler也可以为其他的类使用，而MovableTimeProxy只能为实现Movable接口的类使用，这就是动态代理和静态代理的区别
		InvocationHandler h = new TimeHandler(car);
		Class<?> cls = car.getClass();
		
		Movable m = (Movable)Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);
		m.move();
	}
}
