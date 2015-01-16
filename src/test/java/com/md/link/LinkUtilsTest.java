package com.md.link;

import com.md.link.LinkNode;
import com.md.link.LinkUtils;

import junit.framework.TestCase;

public class LinkUtilsTest extends TestCase{

	public void testReverse(){
		
		LinkNode f = new LinkNode();
		f.setNext(null);
		f.setValue(4);
		LinkNode t = new LinkNode();
		t.setNext(f);
		t.setValue(3);
		LinkNode s = new LinkNode();
		s.setNext(t);
		s.setValue(2);
		LinkNode first = new LinkNode();
		first.setNext(s);
		first.setValue(1);
		LinkUtils.print(first);
		LinkNode newFirst = LinkUtils.reverse(first);
		LinkUtils.print(newFirst);
	}
	
	public void testReversePrint(){
		LinkNode f = new LinkNode();
		f.setNext(null);
		f.setValue(4);
		LinkNode t = new LinkNode();
		t.setNext(f);
		t.setValue(3);
		LinkNode s = new LinkNode();
		s.setNext(t);
		s.setValue(2);
		LinkNode first = new LinkNode();
		first.setNext(s);
		first.setValue(1);
		LinkUtils.print(first);
		System.out.println();
		LinkUtils.reversePrint(first);
	}

}
