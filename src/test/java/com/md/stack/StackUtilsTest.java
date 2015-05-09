package com.md.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import junit.framework.TestCase;

public class StackUtilsTest extends TestCase {

	public void testIsPopOrder(){
		List<Integer> pushOrderList = Arrays.asList(1,2,3,4,5,6,7);
		List<Integer> popOrderList = Arrays.asList(4,6,3,5,7,2,1);
		System.out.println(StackUtils.isPopOrder(pushOrderList, popOrderList));
		
		System.out.println(51034%10);
	}
	
	public void testPutToButtom(){
		Stack<Object> stack = new Stack<Object>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println("init:");
		StackUtils.printStack(stack);
		StackUtils.putToButtom(stack, 6);
		System.out.println();
		System.out.println("after push:");
		StackUtils.printStack(stack);
	}
	
	public void testReverse(){
		Stack<Object> stack = new Stack<Object>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println("init:");
		StackUtils.printStack(stack);
		StackUtils.reverse(stack);
		System.out.println();
		System.out.println("after reverse:");
		StackUtils.printStack(stack);
	}
}
