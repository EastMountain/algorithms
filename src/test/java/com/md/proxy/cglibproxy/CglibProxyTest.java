package com.md.proxy.cglibproxy;

import junit.framework.TestCase;

public class CglibProxyTest extends TestCase{

	public void testCglibProxy(){
		CglibProxy proxy = new CglibProxy();
		Train t = (Train)proxy.getProxy(Train.class);
		t.move();
	}
}
