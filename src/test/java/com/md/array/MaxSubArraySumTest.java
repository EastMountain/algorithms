package com.md.array;

import com.md.array.MaxSubArraySum;

import junit.framework.TestCase;

public class MaxSubArraySumTest extends TestCase {

	public void testProcess(){
		int a[] = {31,-10,1,3,5,6,-3,-19,30}; 
    	for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
    	System.out.println();
    	MaxSubArraySum ms = new MaxSubArraySum();
    	System.out.println(ms.process(a));
	}

}
