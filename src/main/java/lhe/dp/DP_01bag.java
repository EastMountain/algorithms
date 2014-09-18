package lhe.dp;

/**
 * 
 * 动态规划，01背包问题
 * 
 * @author lhe
 * @version 1.0.0 DP_01bag.java 2014-9-7 下午10:12:17
 */
public class DP_01bag {

	//物品数量，物品0,1,2,。。。，n-1
	private int n;
	
	//物品重量:w[0] ~ w[n-1]
	private int w[];
	
	//物品价值:v[0] ~ v[n-1]
	private int v[];	
	
	//背包最大容量
	private int c;
	
	/**
	 * m[i][j] 背包容量为j,  可取物品范围为i,i+1,...,n-1的最大价值
	 */
	private int m[][]; 
	
	/**
	 * 物品i是否装入，装入i则 x[i]=1，不装入i则x[i]=0
	 */
	private int x[];
	
	public DP_01bag(int n, int w[], int v[], int c){
		this.n=n;
		this.w=w;
		this.v=v;
		this.c=c;
		this.m = new int[n][c+1];
		this.x = new int[n];
	}
	
	/**
	 *  最优值计算	 	 
	  * 构建最大价值数组
	  * 
	  * 当0<=j<w(i)时，物品i不可能装入，最大效益值与m(i+1,j)相同；
	  * 当j>=w(i)时，有两种选择：
	  * ⑴不装入物品i，这时的最大效益值与m(i+1,j)相同；
	  * ⑵装入物品i，这时会产生效益v(i)，背包剩余容量为j-w(i)，可以选择物品i+1,…,n来装，最大效益值为m(i+1,j-w(i))+v(i)；
	  * 这时m(i,j)=max(m(i+1,j), m(i+1,j-w(i))+v(i))
	  * 
	  * 由于数组下标范围是0，1。。。，n-1
	 */
	public void buildOptimizeValue(){
		//根据边界条件计算m[n-1][j]
		for (int j=0;j<=c;j++){
			if(j>=w[n-1]){
				m[n-1][j]=w[n-1];
			}else{
				m[n-1][j]=0;
			}			
		}
		
		//逆推计算其他m[i][j]
		for (int i=n-2;i>=0;i--){
			for (int j=0;j<=c;j++){
				if(j>=w[i]&&(m[i+1][j]<m[i+1][j-w[i]]+v[i])){
					m[i][j]=m[i+1][j-w[i]]+v[i];
				}else{
					m[i][j]=m[i+1][j];
				}				
			}
		}			
	}
	
	/**
	 * 
	  * 构建最优解
	  * 步骤1：如果m[i][cw]>m[i+1][cw], 则装入i，否则不装入
	  * 步骤2：比较所装载的物品效益之和与最优值，决定物品n-1是否装载
	  * 
	 */
	public void buildOptimalSolution(){
		int sp=0;//已产生的价值
		int cw=c;//背包还剩的容量
		int sw=0;//已经使用的流量
		//step1
		for(int i=0;i<=n-2;i++){
			if(m[i][cw]>m[i+1][cw]){
				cw -= w[i];
				sw += w[i];
				sp += v[i];
				x[i]=1;
			}else{
				x[i]=0;
			}
				
		}
		
		//判断物品n-1是否装入
		if(m[0][c]-sp==v[n-1]){
			sw += w[n-1];
			sp += v[n-1];
			x[n-1]=1;
		}else{
			x[n-1]=0;
		}
	}
	
	public int[] process(){
		this.buildOptimizeValue();
		this.buildOptimalSolution();
		return x;
	}
	
	public void print(){
		System.out.println("m[i][j]");
		System.out.print("i\\j	");
		for(int j=0;j<=c;j++){
			System.out.print(j + "	");
		}
		System.out.println();
		for(int i=0;i<n;i++){
			System.out.print(i+"	");
			for(int j=0;j<=c;j++){
				System.out.print(m[i][j] + "	");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("x[i]");
		for(int i=0;i<n;i++){
			System.out.print(x[i] + " ");
		}
	}
}


