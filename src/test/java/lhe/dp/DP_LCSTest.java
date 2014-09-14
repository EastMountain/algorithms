package lhe.dp;

import junit.framework.TestCase;

public class DP_LCSTest  extends TestCase {

	public void testDP_LCS(){
		String xStr = "abctyyxcvf";
		String yStr = "btcycf";
    	char x[] = xStr.toCharArray(); 
    	char y[] = yStr.toCharArray(); 
    	DP_LCS lcs = new DP_LCS(x,y);
    	lcs.buildOptimizeValue();
    	lcs.buildOptimalSolution();
    	lcs.print();
    	
    }
}
