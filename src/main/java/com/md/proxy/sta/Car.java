package com.md.proxy.sta;

import java.util.Random;

public class Car implements Movable {

	public void move() {
		// TODO Auto-generated method stub
		try {
			System.out.println("car is moving......");
			Thread.sleep(new Random().nextInt(2000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
