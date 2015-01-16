package com.md.induction;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 输入两个整数n 和m，从数列1，2，3.......n 中随意取几个数,使其和等于m ,要求将其中所有的可能组合列出来.
 * 
 * @author Administrator
 * @version 1.0.0 FindCombination.java 2014-11-20 上午10:30:16
 */
public class FindCombination {

	
	public static void find(int n, int m){		
		if(n>m){
			n=m;
		}
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<=n;i++){
			list.add(0);
		}
		findHelper(n,m,list);
	}
	
	/**
	 * 
	  * 1. 当m<n时， 大于m的数不在组合中，则n=m
	  * 2. 当n在组合中时，问题分解为f(n-1, m-n)的子问题
	  * 3. 当n不在组合中时，问题分解为f(n-1,m)的子问题
	  * 4. 当m==0时，分解完成，打印一组组合
	  * 5. 其他情况，当n=0,或者m<0时，该组合不成立直接返回
	  *
	  * @param n
	  * @param m ： 和数
	  * @param list    
	  * @return void
	 */
	public static void findHelper(int n, int m, List<Integer> list){
		if(m==0){
			//print
			System.out.println();
			for(int i=0;i<list.size();i++){
				if(list.get(i)==1 & list.get(i) !=0){
					System.out.print(i+" ");
				}
				
			}
			return;
		}
		if(m<n){
			n=m;
		}
		
		if(n==0 || m <0){
			return;
		}
		//n在组合中
		list.set(n, 1);
		findHelper(n-1,m-n,list);
		//n不在组合中
		list.set(n, 0);
		findHelper(n-1,m,list);		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindCombination.find(20, 36);
	}

}
