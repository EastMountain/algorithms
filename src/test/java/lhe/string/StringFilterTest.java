package lhe.string;

import junit.framework.TestCase;

public class StringFilterTest  extends TestCase {

	public void testStringFilter(){
		String xStr = "abbctcbbkkkkkkacbcdeedcba\0";
		char ch[] = xStr.toCharArray(); 
		System.out.println();
		System.out.println("ch[i]");
		for(int i=0;i<ch.length;i++){
			System.out.print(ch[i] + " ");
		}
		StringFilter sf = new StringFilter();
		sf.filter(ch);
		System.out.println();
		for(int i=0;i<ch.length;i++){
			System.out.print(ch[i] + " ");
		}
	}

}
