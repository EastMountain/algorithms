package com.md.dp;

/**
 * 
 * 给定字符串，可以通过插入字符，使其变为回文，求最少插入字符的数量。
 * 
 * DP:
 * 方法一：
 * d[i][j] 表示 第i到第j个字符变为回文，最少插入字符的数量
 * 若i>=j, 则d[i][j]=0
 * 若str[i]=str[j], 则d[i][j]=d[i+1][j-1]
 * 若str[i]!=str[j], 则d[i][j]=min(d[i+1][j]+1, d[i][j-1]+1)
 * 
 * 方法二：
 * 
 * @author lhe
 * @version 1.0.0 DP_MinInsertStr.java 2014-9-14 下午2:41:20
 */
public class DP_MinInsertStr {
	
	//字符串
	private char str[];
	
	//字符串长度
	private int n;
	
	//d[i][j] 表示 第i到第j个字符变为回文，最少插入字符的数量
	private int d[][];
	
	public DP_MinInsertStr(char str[]){
		this.str=str;
		this.n=str.length;
		this.d=new int[n][n];
	}
	
	public void buildOptimizeValue(){
		//若i>=j, 则d[i][j]=0
		for(int i=0;i<n;i++){
			for(int j=i;j>=0;j--){
				d[i][j]=0;
			}
		}
		
		/**
		 * 若str[i]=str[j], 则d[i][j]=d[i+1][j-1]
		 * 若str[i]!=str[j], 则d[i][j]=min(d[i+1][j]+1, d[i][j-1]+1)
		 */
		for(int i=n-2;i>=0;i--){
			for(int j=i+1;j<n;j++){
				if(str[i]==(str[j])){
					d[i][j]=d[i+1][j-1];
				}else{
					if((d[i][j-1]+1)<(d[i+1][j]+1)){
						d[i][j]=d[i][j-1]+1;
					}else {
						d[i][j]=d[i+1][j]+1;
					}					
				}
			}
		}
	}
	
	
	public void print(){
		System.out.println("str");
		for(int i=0;i<n;i++){
			System.out.print(str[i]);
		}
		System.out.println();
		System.out.println("d[i][j]");
		System.out.print("i\\j	");
		for(int j=0;j<n;j++){
			System.out.print(j + "	");
		}
		System.out.println();
		for(int i=0;i<n;i++){
			System.out.print(i+"	");
			for(int j=0;j<n;j++){
				System.out.print(d[i][j] + "	");
			}
			System.out.println();
		}		
	}
	

}
