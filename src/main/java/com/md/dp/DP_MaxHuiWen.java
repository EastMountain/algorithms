package com.md.dp;
/**
 * 
 * 给定字符串，找到它的最长回文子串，都有哪些思路呢？例如"abbctcbbkkkkkkabcdeedcba",回文字串很多了，但最长的是"abcdeedcba"。
 * 
 * @author lhe
 * @version 1.0.0 DP_MaxHuiWen.java 2014-9-10 下午20:13:45
 */
public class DP_MaxHuiWen {

	/**
	 * 字符串数组
	 */
	private char str[];
	
	/**
	 * 字符串数组长度
	 */
	private int n;
	
	/**
	 * 记录字符串str[i]，str[i+1],..str[j]是否为回文
	 * 0<=i<n
	 * j<=j<n
	 */
	private boolean h[][];
	
	/**
	 * 最大回文字符串数组
	 */
	private char maxHuiWen[];
	
	public DP_MaxHuiWen(char str[]){
		this.str = str;
		this.n = str.length ;
		this.h = new boolean[n][n];
	}
	
	/**
	 *  计算最优值
	 *  若i>j, h[i][j]=false
	  * 若i=j, h[i][j]=true
	  * 若i+1=j, h[i][j]=(str[i]==str[j])
	  * 其他，h[i][j] = h[i+1][j-1]&&(str[i]==str[j]) 
	  * 
	 */
	public void buildOptimizeValue(){
		/**
		 * 初始化下半部分
		 */
		for(int i=0;i<n;i++){
			for(int j=0;j<=i;j++){
				if(i>j){
					h[i][j]=false;
				}else if(i==j){
					h[i][j]=true;
				}
			}
		}
		
		for(int i=n-1;i>=0;i--){
			for(int j=i+1;j<n;j++){
				if ((i+1==j) && (str[i]==(str[j]))){
					h[i][j]=true;
				}else {
					h[i][j] = h[i+1][j-1]&&(str[i]==(str[j]));
				}
			}
		}
	}
	
	/**
	 * 构造最优解
	 * 当h[i][j]==true，并且j-i最大时，str[i],str[i+1],...,str[j]为最优解 
	 */
	public void buildOptimalSolution(){
		int max = 0;
		int start=0, end=0;
		for(int i=0;i<n;i++){
			for(int j=i;j<n;j++){
				if(h[i][j] && max<(j-i)){
					start=i;
					end=j;
					max=j-i;
				}
			}
		}
		
		maxHuiWen = new char[end-start+1];
		for(int k=0;k<(end-start+1);k++){
			maxHuiWen[k]=str[start+k];
		}
	}
	
	public char[] process(){
		this.buildOptimizeValue();
		this.buildOptimalSolution();
		return maxHuiWen;
	}
	
	public void print(){
		System.out.println("h[i][j]");
		System.out.print("i\\j	");
		for(int j=0;j<n;j++){
			System.out.print(j + "	");
		}
		System.out.println();
		for(int i=0;i<n;i++){
			System.out.print(i+"	");
			for(int j=0;j<n;j++){
				System.out.print(h[i][j] + "	");
			}
			System.out.println();
		}
				
		System.out.println();
		System.out.println("str[i]");
		for(int i=0;i<n;i++){
			System.out.print(str[i] + " ");
		}
		
		System.out.println();
		System.out.println("maxHuiWen[i]");
		for(int i=0;i<maxHuiWen.length;i++){
			System.out.print(maxHuiWen[i] + " ");
		}
		
	}
}
