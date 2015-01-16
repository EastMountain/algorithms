package com.md.dp;

import com.md.dp.DP_LCS;

import junit.framework.TestCase;

public class DP_LCSTest  extends TestCase {

	public void testDP_LCS(){
//		String xStr = "abct";
//		String yStr = "btc";
//    	String x[] = xStr.split(""); 
//    	String y[] = yStr.split(""); 
//    	DP_LCS lcs = new DP_LCS(x,y);
//    	lcs.buildOptimizeValue();
//    	lcs.buildOptimalSolution();
//    	lcs.print();
		String xStr = "abctyyxcvf";
		String yStr = "btcycf";
    	char x[] = xStr.toCharArray(); 
    	char y[] = yStr.toCharArray(); 
    	DP_LCS lcs = new DP_LCS(x,y);
    	lcs.buildOptimizeValue();
    	lcs.buildOptimalSolution();
    	lcs.print();
    	
    	float fl = 111111111211111111121111111112111111111.1111111f;
    	System.out.println(fl);
    	
    	int a=0,b=10,t=0;
    	if(a==0)
    		if(b>10)
    			t++;
    		else
    			t--;
    	System.out.println(t);
    }
}
