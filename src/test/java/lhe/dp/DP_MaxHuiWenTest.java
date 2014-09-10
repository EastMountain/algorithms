package lhe.dp;

import junit.framework.TestCase;

public class DP_MaxHuiWenTest extends TestCase {

	public void testDP_MaxHuiWen(){
		String xStr = "abbctcbbkkkkkkabcdeedcba";
    	String str[] = xStr.split(""); 
    	DP_MaxHuiWen mhw = new DP_MaxHuiWen(str);
    	mhw.buildOptimizeValue();
    	mhw.buildOptimalSolution();
    	mhw.print();    	
    }

}
