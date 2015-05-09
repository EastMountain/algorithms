package com.md.string;

import java.util.List;

import com.google.common.collect.Lists;

public class StringUtils {
	
	/**
	 * 定义字符串的左旋转操作：把字符串前面的若干个字符移动到字符串的尾部。 
	 * 如把字符串abcdef 左旋转2位得到字符串cdefab。请实现字符串左旋转的函数。 
	 * 要求时间对长度为n 的字符串操作的复杂度为O(n)，辅助内存为O(1)。
	 * 
	 * 解：abcdefghijk, 5
	 * (abcde (reverse)-> edcba, fghijk (reverse)-> kjihgf)->edcbakjigf (reverse)-> fgijkabcde
	 *
	 *
	 * 
	 * @param chars
	 * @param step
	 * @return void
	 */
	public static String leftRotation(String str, int step){
		if(str == null || str.length()==0){
			throw new IllegalArgumentException();
		}
		char[] chars = str.toCharArray();
		int begin =0;
		int end = chars.length-1;
		if(step<chars.length){
			reverse(chars, begin, step-1);
			reverse(chars, step, end);
			reverse(chars, begin, end);
		}		
		return new String(chars);
	}
	
	/**
	 * 
	  * 反转chars数组中从start到end的数据
	  * @param chars
	  * @param start
	  * @param end
	  * @return    
	  * @return String
	 */
	public static String reverse(char[] chars, int start, int end){
		char temp;
		for(int i=start, j=end;i<j;i++,j--){
			temp = chars[i];
			chars[i]=chars[j];
			chars[j]=temp;
		}
		return new String(chars);
	}
	
	/**
	 * 
	  * 题目：输入一个字符串，打印出该字符串中字符的所有排列。
	  * 例如输入字符串abc，则输出由字符a、b、c 所能排列出来的所有字符串
	  * abc、acb、bac、bca、cab 和cba。
	  * 
	  * 分析：分解子问题，对于长度为n的字符串，设所有排列为F(n),
	  * 则所有排列为第一个字符与F(n-1)的排列，
	  * 只要将第一个字符插入到F(n-1)每一个排序的第0到第n-1的位置
	  * @param s
	  * @return    
	  * @return List<String>
	 */
	public static List<String> generatePermutation(String s){
	     List<String> pl = Lists.newArrayList();
	     if(s==null) return pl;
	     int n=s.length();
	     if(n==1) {
	    	 pl.add(s);
	         return pl;
	     }
	     //第一个字符
	     char f = s.charAt(0);
	     //除第一个字符外所有字符的排列
	     List<String> spl = generatePermutation(s.substring(1));
	     //将第一个字符插入到子字符排列中
	     for(String str: spl){
	    	 //插入到F(n-1)每一个排序的第0到第n-1的位置
	    	 for(int i=0;i<n;i++){	    		 
	    		 pl.add(new StringBuilder(str).insert(i, f).toString());
	    	 }
	     }
	    
	     return pl;
	}

	
	public static void main(String[] args) {
		String str = "abcdefghijk";
		System.out.println(StringUtils.leftRotation(str, 6));
		
		List<String> pl = generatePermutation("abcd");
		for(String s: pl){
			System.out.println(s + " ");
		}
	}

}
