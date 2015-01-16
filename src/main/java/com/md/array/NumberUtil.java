package com.md.array;

public class NumberUtil {

	/**
	 * 
	  * 数组中有一个数字出现的次数超过了数组长度的一半，找出这个数字。
	  * 
	  * 思路：有一个数字出现的次数超过数组长度的一半，要找出这个数字可以用消除法
	  * 解：遍历数组，当两个数字一致时，计数加1，不一致时减1，最后计数大于1的数就是所要找的
	  * 
	  * @param a
	  * @return    
	  * @return int
	 */
	public static int getMajor(int a[]){
		int x = 0;
		int count=0;
		for(int i=0;i<a.length;i++){
			if(count==0){
				x=a[i];
				count++;
			}else if (x==a[i]){
				count++;
			}else{
				count--;
			}
		}
		return x;
	}
	
	
	public static void main(String args[]){
		
		int a[] = {1,1,1,2,2,3,4,5,6,6,2,2,2,2,2,2,2};
		System.out.println(NumberUtil.getMajor(a));
	}
}
