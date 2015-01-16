package com.md.proxy.sta;

public class MovableLogProxy implements Movable {
	
	private Movable m;
	
	public MovableLogProxy(Movable m){
		this.m = m;
	}

	public void move() {
		// TODO Auto-generated method stub
		System.out.println("日志代理开始");
		m.move();
		System.out.println("日志代理结束");
	}

}