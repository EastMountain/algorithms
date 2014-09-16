package lhe.array;

/**
 * 
 * 给定一个无序的整数数组，怎么找到第一个大于0，并且不在此数组的最小整数。比如[1,2,0] 返回 3, [3,4,-1,1] 返回 2。最好能O(1)空间和O(n)时间。
 * 
 * @author lhe
 * @version 1.0.0 FindTheMinIntegerNotInArray.java 2014-9-16 下午3:53:19
 */
public class FindTheMinIntegerNotInArray {

	private int a[];
	
	private int minIntegerNotInArray;
	
	public FindTheMinIntegerNotInArray(int a[]){
		this.a=a;
	}
	
	/**
	 * 从a[n-1]向前遍历
	 * 若a[i]<0 or a[i]>=n or a[i]=i,不变,遍历下一个
	 * 若0<a[i]<n，将a[i]放到对应的位置i上：swap(a[a[i]],a[i])
	 * 
	 * 遍历一遍以后a[1]到丢失的最小整数之间是有序的，并且第一个a[i]!=i的数就是丢失的数（i>0）
	  * 
	 */
	public void find(){
		int n = a.length;
		int temp;
		for(int i=n-1;i>=0;i--){
			while(a[i]>=0&&a[i]<n&&i!=a[i]){
				if(a[i]==a[a[i]]){
					break;
				}else{
					temp=a[a[i]];
					a[a[i]]=a[i];
					a[i]=temp;
				}
			}
		}
		for(int i=1;i<a.length;i++){
			if(a[i]>0&&a[i]!=i){
				minIntegerNotInArray = i;
				break;
			}
		}
	}
	
	public void print(){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		System.out.println("The min integer not in array is "+minIntegerNotInArray);
	}
}
