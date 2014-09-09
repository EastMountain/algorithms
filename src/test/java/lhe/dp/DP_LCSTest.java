package lhe.dp;

import junit.framework.TestCase;

public class DP_LCSTest  extends TestCase {

	public void testDP_LCS(){
		String xStr = "abct";
		String yStr = "btc";
    	String x[] = xStr.split(""); 
    	String y[] = yStr.split(""); 
    	DP_LCS lcs = new DP_LCS(x,y);
    	lcs.buildOptimizeValue();
    	lcs.buildOptimalSolution();
    	lcs.print();
    	
    }
}
