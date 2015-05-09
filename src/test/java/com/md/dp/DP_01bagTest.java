package com.md.dp;

import com.md.dp.DP_01bag;

import junit.framework.TestCase;

public class DP_01bagTest extends TestCase {

	public void testDP_01bag(){
    	int n=10; 
    	int w[] = {10,20,50,80,30,40,90,70,100,60}; 
    	int v[] = {30,80,20,50,60,90,70,500,40,10}; 
    	int c = 100;
    	DP_01bag bag = new DP_01bag(n,w,v,c);
    	bag.buildOptimizeValue();
    	bag.buildOptimalSolution();
    	bag.print();
    	
    }

}