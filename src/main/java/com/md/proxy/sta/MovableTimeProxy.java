package com.md.proxy.sta;

public class MovableTimeProxy implements Movable {
	
	private Movable m;
	
	public MovableTimeProxy(Movable m){
		this.m = m;
	}

	public void move() {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		System.out.println("时间代理开始");
		m.move();
		long end = System.currentTimeMillis();
		System.out.println("时间代理：运行" + (end - start) + "微秒 ！！！");
	}

}
