package com.md.dp;

import com.md.dp.DP_MinInsertStr;

import junit.framework.TestCase;

public class DP_MinInsertStrTest extends TestCase {

	public void testDP_MinInsertStr(){
		String xStr = "abbctcbbkkkkkkabcdeedcba";
    	char str[] = xStr.toCharArray(); 
//		String str[] = (String[])Splitter.on("").trimResults().omitEmptyStrings().splitToList(xStr).toArray();
    	DP_MinInsertStr mhw = new DP_MinInsertStr(str);
    	mhw.buildOptimizeValue();
    	mhw.print();    	
    }

}