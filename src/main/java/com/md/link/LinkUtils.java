package com.md.link;

public class LinkUtils {

	/**
	 * 
	  * 链表反转
	  * @param first
	  * @return    
	  * @return LinkNode
	 */
	public static LinkNode reverse(LinkNode first){
		LinkNode n = first;
		LinkNode newNext = null;
		while(n!=null){
			first.setNext(newNext);
			newNext = first;
			n = n.getNext();
			if(n !=null){
				first = n;
			}			
		}
		return first;
	}
	
	/**
	 * 
	  * 输入一个链表的头结点，从尾到头反过来输出每个结点的值。
	  * 
	  * 分析：
	  * 1.使用栈实现，从头到位压入栈，再打印栈
	  * 2.递归实现：而递归本质上就是一个栈结构。
	  * @param head    
	  * @return void
	 */
	public static void reversePrint(LinkNode head){
		if(head!=null){
			reversePrint(head.getNext());
			System.out.print(head.getValue() + " ");
		}
	}
	
	public static void print(LinkNode first){
		System.out.println();
		while(first!=null){
			System.out.print(first.getValue() + " ");
			first=first.getNext();
		}
	}

}
