package lhe.string;

import junit.framework.TestCase;

public class BracketsTest extends TestCase {

	public void testBrackets(){
		String xStr = "a(bbc(tcbbkkkk(kkacbc)deed(cb)))a\0";
		char ch[] = xStr.toCharArray(); 
		Brackets brackets = new Brackets();
		System.out.println(brackets.matchByRecursion(ch, ch.length, 0));
	}

}
