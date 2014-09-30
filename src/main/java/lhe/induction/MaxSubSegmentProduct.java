package lhe.induction;
/**
 * 给一个int数组，求这个数组的最大子段乘积（不考虑溢出）
 * 
 * solution:
 * 最大子段不能包含0，以0分割每个子段
 * 
 * 假设
 * 对于A[i,k]
 * maxi 是 A[i,k]的乘积最大值
 * mini 是 A[i,k]的乘积绝对值最大
 * mp 是 最大子段乘积
 * 
 * 则
 * 对于A[i,k+1]
 * maxi= max{maxi * A[k+1], mini * A[k+1], A[k+1]} 
 * mixi= mix{maxi * A[k+1], mini * A[k+1], A[k+1]}
 * 最大子段乘积max{mp, maxi * A[k+1], mini * A[k+1]，A[k+1]}  
 * 
 * @version 1.0.0 MaxSubSegmentProduct.java 2014-9-30 下午3:57:35
 */
public class MaxSubSegmentProduct {

	public int process(int a[]){
		int maxi=1, mini = 1;
		int temp_maxi=1, temp_mini=1;
		int mp = Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++){
			maxi *= a[i];
			mini *= a[i];
			mp = Math.max(Math.max(Math.max(maxi, mini), mp),a[i]);
			temp_maxi = maxi;
			temp_mini = mini;
			mini = Math.min(Math.min(temp_maxi, temp_mini), a[i]);
			maxi = Math.max(Math.max(temp_maxi, temp_mini), a[i]);			
		}
		
		return mp;
	}
	
}
