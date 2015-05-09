package com.md.tree;

import com.md.tree.Node;
import com.md.tree.TreePrint;

import junit.framework.TestCase;

public class TreePrintTest extends TestCase{

	public void testPrintTree(){
		Node n1 = new Node(5, null,null);
		Node n2 = new Node(7, null,null);
		Node n3 = new Node(9, null,null);
		Node n4 = new Node(11, null,null);
		Node n5 = new Node(6, n1,n2);
		Node n6 = new Node(10, n3, n4);
		Node n7 = new Node(8, n5, n6);
		
		TreePrint tp = new TreePrint();
		tp.printByLevel(n7);
	}
}
