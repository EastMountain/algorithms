package com.md.string;
/**
 *  
 * @author lhe
 * @version 1.0.0 Brackets.java 2014-9-18 下午9:52:15
 */
public class Brackets {
	
	/**
	 * 
	 * 给定字符串，判断字符串中括号是否完整
	 * 1. "()"  yes;
	 * 2. ")("	no;
	 * 3. "(abcd(e)"	no
	 * 4. "(a)(b)"	yes
	 * 
	 * 要求必须用递归写，不能出现循环语句
	 * 
	 * @author lhe 2014-9-18 下午9:52:15
	 */
	public boolean matchByRecursion(char ch[], int n, int c){
		if(n==0){
			return c==0?true:false;
		}
		if(ch[n-1]=='('){
			return matchByRecursion(ch, n-1, c+1);
		}else if(ch[n-1]==')'){
			return matchByRecursion(ch, n-1, c-1);
		}else{
			return matchByRecursion(ch, n-1, c);
		}
	}
}
