package com.md.tree;

import java.util.LinkedList;

public class TreePrint {

	/**
	 * 输入一颗二元树，从上往下按层打印树的每个结点，同一层中按照从左往右的顺序打印。
	 * 例如输入
	 *    8
	 *   / \
	 *  6  10
	 * / \ / \
	 * 5 7 9 11
	 * 输出8 6 10 5 7 9 11。
	 * 
	 * 解：用一个FIFO队列实现
	 */
	public void printByLevel(Node root) {
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(root);
		while (!list.isEmpty()) {
			Node temp = list.removeLast();
			if (temp != null) {
				System.out.print(temp.getValue() + " ");
				list.addFirst(temp.getLeft());
				list.addFirst(temp.getRight());
			}
		}
	}

}
