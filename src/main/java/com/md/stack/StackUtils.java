package com.md.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackUtils {

	/**
	 * 
	  * 输入两个整数序列。其中一个序列表示栈的push 顺序，
	  * 判断另一个序列有没有可能是对应的pop 顺序。
	  * 为了简单起见，我们假设push 序列的任意两个整数都是不相等的。
	  * 比如输入的push 序列是1、2、3、4、5，6那么4、6、5、3、2、1 就有可能是一个pop 系列。
	  * 因为可以有如下的push 和pop 序列：
	  * push 1，push 2，push 3，push 4，pop，push 6，pop 6，push 5，pop，pop，pop，pop，这样得到的pop 序列就是4、6、5、3、2、1。
	  * 但序列4、6、3、5、1、2 就不可能是push 序列1、2、3、4、5、6 的pop 序列。
	  * 
	  * 分析
	  * 构建一个辅助堆栈；
	  * 查看pop顺序数组，因为第一个pop出来的是4，而push顺序是确定的，所以需要把4及之前的123都push到堆栈中；
	  * 此时4已经是栈顶元素，pop出来
	  * 接下来处理第二个pop元素6，同样，需要把数组中56 push到栈中，因为4之前的数据已经push了，所以不需要push
	  * 此时6已经是栈顶元素，pop出来
	  * 接下来处理第三个pop元素5，因为是栈顶元素，直接pop出来
	  * 其他的元素同理
	  * 
	  * @param pushOrderList
	  * @param popOrderList
	  * @return    
	  * @return boolean
	 */
	public static boolean isPopOrder(List<Integer> pushOrderList, List<Integer> popOrderList){
		boolean isOrder = false;
		if(pushOrderList != null && popOrderList != null && pushOrderList.size()==popOrderList.size()){
			Stack<Integer> stack = new Stack<Integer>();
			int pushIndex = 0, popIndex=0;
			int listSize = popOrderList.size();
			//pop元素的索引不能超过pop序列的总长度
			while(popIndex < listSize){
				//当栈空或者当前pop元素不是栈顶元素时，需要判断是否把push序列中对应pop元素之前的元素push到栈中
				while(stack.empty()||stack.peek() != popOrderList.get(popIndex)){
					//如果pop元素不是栈顶元素，并且对应的push元素的位置在前一次push元素位置之前，则表明不是一个pop序列
					if(pushOrderList.lastIndexOf(popOrderList.get(popIndex)) < pushIndex){
						return false;
					}
					//如果push元素的位置小于学列的大小，则把push序列中对应pop元素之前的元素push到栈中，否则表明不是一个pop序列
					if(pushIndex < listSize){
						stack.push(pushOrderList.get(pushIndex));
						pushIndex++;
					}else{
						return false;
					}
				}
				stack.pop();
				popIndex++;
			}
			isOrder = stack.empty();			
		}
		
		return isOrder;
	}
	
	
	/**
	 * 
	  * 用递归颠倒一个栈。例如输入栈{1, 2, 3, 4, 5}，1 在栈顶。颠倒之后的栈为{5, 4, 3, 2, 1}，5 处在栈顶。
	  *
	  * @param stack    
	  * @return void
	 */
	public static void reverse(Stack<Object> stack){
		if(stack == null || stack.size()==1){
			return;
		}
		Object ob = stack.pop();
		reverse(stack);
		putToButtom(stack, ob);
	}
	
	/**
	 * 
	  * 将元素加入栈底
	  * @param stack
	  * @param item    
	  * @return void
	 */
	public static void putToButtom(Stack<Object> stack, Object item){
		if(stack.isEmpty()){
			stack.push(item);
			return;
		}
		Object ob = stack.pop();
		putToButtom(stack,item);
		stack.push(ob);
	}
	
	public static void printStack(Stack<Object> stack){
		if(stack.isEmpty()){
			return;
		}
		
		Object[] obArr = stack.toArray();
		for(Object ob: obArr){
			System.out.print(ob + " ");
		}
	}
}
