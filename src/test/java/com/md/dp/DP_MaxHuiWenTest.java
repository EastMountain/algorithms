package com.md.dp;

import com.md.dp.DP_MaxHuiWen;

import junit.framework.TestCase;

public class DP_MaxHuiWenTest extends TestCase {

	public void testDP_MaxHuiWen(){
		String xStr = "abbctcbbkkkkkkabcdeedcba";
		char str[] = xStr.toCharArray(); 
    	DP_MaxHuiWen mhw = new DP_MaxHuiWen(str);
    	mhw.buildOptimizeValue();
    	mhw.buildOptimalSolution();
    	mhw.print();    	
    }

}