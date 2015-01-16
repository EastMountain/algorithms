package com.md.proxy.sta;

import junit.framework.TestCase;

public class MovableTest extends TestCase{

	public void testMove(){
		Car car = new Car();
		MovableLogProxy mlp = new MovableLogProxy(car);
		MovableTimeProxy mtp = new MovableTimeProxy(mlp);
		mtp.move();
	}
}
