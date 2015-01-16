package com.md.dp;

/**
 * 
 * 最长公共子序列（Longest common subsequence）
 * 
 * 子序列
 * 一个给定序列的子序列是在该序列中删去若干元素后所得到的序列。即：给定X={x1,x2,…,xm}和Z={z1,z2,…,zk}，X的子序列是指存在一个严格递增下标序列{i1,i2,…,ik}，使得对于所有的j=1,2,…k，有zj=xij。例如：
 * 	Z={b,d,c,a}是X={a,b,c,d,c,b,a}的一个子序列
 * 公共子序列
 * 若序列Z是序列X的子序列，又是序列Y的子序列，则称Z是序列X和序列Y的公共子序列。例如：
 * 	序列"bcba"是"abcbdab"与"bdcaba"的公共子序列
 * 
 *
 * 给定两个序列X={x1,x2,…,xm}和Y={y1,y2,…,yn}，找出序列X和Y的最长公共子序列
 * 
 * @author lhe
 * @version 1.0.0 DP_LCS.java 2014-9-9 下午3:45:59
 */
public class DP_LCS {

	/**
	 * 序列X
	 */
	private char x[];
	/**
	 * 序列Y
	 */
	private char y[];
	/**
	 * 最长公共子序列Z
	 */
	private char z[];
	
	/**
	 * 序列X的长度
	 */
	private int m;
	
	/**
	 * 序列Y的长度
	 */
	private int n;
	
	/**
	 * {xi,xi+1,...,xm} 和 {yj,yj+1,...,yn}的最长公共子序列的长度
	 * c[i][j]
	 */
	private int c[][];
	
	/**
	 * 利用s(i,j)记录x(i)与y(j)比较的结果：
	 * 当x(i)=y(j)时， s(i,j)=1
	 * 当x(i)!=y(j)时，s(i,j)=0
	 */
	private int s[][];
	
	public DP_LCS(char x[], char y[]){
		this.x=x;
		this.y=y;
		this.n=y.length;
		this.m=x.length;
		this.c = new int[m+1][n+1];
		this.s = new int[m][n];
	}
	
	/**
	 * 
	  * 计算最优值
	  * 若i>m 或者 j>n时，为空序列，c[i][j]=0
	  * 若 X[i]==Y[j], c[i][j]=c[i+1][j+1]+1;
	  * 若X[i]!=Y[j], c[i][j]=max(c[i+1][j], c[i][j+1]);
	  * 
	  * 最优值在c[0][0]中
	  * 
	 */
	public void buildOptimizeValue(){
		//计算边界: 当i>m 或者 j>n时，c[i][j]=0
		for(int i=0;i<=m;i++){
			c[i][n]=0;
		}
		
		for(int j=0;j<=n;j++){
			c[m][j]=0;
		}
		
		/**
		 * 若 X[i]==Y[j], c[i][j]=c[i+1][j+1]+1;
		 * 若X[i]!=Y[j], c[i][j]=max(c[i+1][j], c[i][j+1]);
		 */
		for(int i=m-1;i>=0;i--){
			for(int j=n-1;j>=0;j--){
				if(x[i]==(y[j])){
					c[i][j]=c[i+1][j+1]+1;
				}else{
					if(c[i+1][j]>c[i][j+1]){
						c[i][j]=c[i+1][j];
					}else{
						c[i][j]=c[i][j+1];
					}
				}
			}
		}
	}
	
	/**
	 * 
	  * 构造最优解
	  *
	  * 为了能够构造最优解，在逆推计算最优值的过程中，利用s(i,j)记录x(i)与y(j)比较的结果：
	  * 当x(i)=y(j)时， s(i,j)=1
	  * 当x(i)!=y(j)时，s(i,j)=0
	  * X序列的每一项与Y序列的每一项逐一比较，根据s(i,j)与c(i,j)的取值构造最长公共子序列。对x(i)与y(j)比较，其中i=0,1,…,m-1; j=t,…n-1(t从0开始），当确定最长公共子序列中的一项时，通过t=t+1操作避免重复取项。
	  * 若s(i,j)=1且c(i,j)=c(0,0)时，取x(i)为最长公共序列中的第1项。
	  * 若s(i,j)=1且c(i,j)=c(0,0)-w时，取x(i)为最长公共序列中的第w项（其中，w从0开始，每确定最长公共子序列中的一项，w增一）
	 */
	public void buildOptimalSolution(){
		for (int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(x[i]==(y[j])){
					s[i][j]=1;
				}else{
					s[i][j]=0;
				}
			}
		}
		
		z = new char[c[0][0]];
		
		for(int t=0,w=0,i=0;i<m;i++){
			for(int j=t;j<n;j++){
				if(s[i][j]==1&&(c[0][0]-c[i][j]==w)){
					t=j+1;
					z[w]=x[i];
					w++;
				}				
			}
		}
	}
	
	public char[] process(){
		this.buildOptimizeValue();
		this.buildOptimalSolution();
		return z;
	}
	
	public void print(){
		System.out.println("c[i][j]");
		System.out.print("i\\j	");
		for(int j=0;j<=n;j++){
			System.out.print(j + "	");
		}
		System.out.println();
		for(int i=0;i<=m;i++){
			System.out.print(i+"	");
			for(int j=0;j<=n;j++){
				System.out.print(c[i][j] + "	");
			}
			System.out.println();
		}
		
		System.out.println("s[i][j]");
		System.out.print("i\\j	");
		for(int j=0;j<n;j++){
			System.out.print(j + "	");
		}
		System.out.println();
		for(int i=0;i<m;i++){
			System.out.print(i+"	");
			for(int j=0;j<n;j++){
				System.out.print(s[i][j] + "	");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("X[i]");
		for(int i=0;i<m;i++){
			System.out.print(x[i] + " ");
		}
		
		System.out.println();
		System.out.println("Y[i]");
		for(int i=0;i<n;i++){
			System.out.print(y[i] + " ");
		}
		
		System.out.println();
		System.out.println("Z[i]");
		for(int i=0;i<c[0][0];i++){
			System.out.print(z[i] + " ");
		}
	}
	

}
