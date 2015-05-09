package com.md.induction;

import com.md.induction.MaxSubSegmentProduct;

import junit.framework.TestCase;

public class MaxSubSegmentProductTest extends TestCase {

	public void testProcess(){
		
    	int a[] = {2,3,-1,2,-2,4,-8,0,10,10}; 
//		int a[] = {2,3,0,-8,0,10}; 
//		int a[] = {2,3,-1,2,-2,4};
    	for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
    	System.out.println();
    	MaxSubSegmentProduct mssp = new MaxSubSegmentProduct();
    	
    	System.out.println(mssp.process(a));
    }

}
