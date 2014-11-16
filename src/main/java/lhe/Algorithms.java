package lhe;

public class Algorithms {

	/**
	 * 
	  * 题目：求1+2+…+n，要求不能使用乘除法、for、while、if、else、switch、case 等关键字以及条件判断语句
	  *
	  * 解：使用&&运算符，如果n<=0时， (n>0)为false，就不会再判断&&后面的语句，递归就不会再执行了
	  * @param n
	  * @return    
	  * @return int
	 */
	public int nSum(int n){
		int sum=0;
		int temp=-1;
		boolean bo = (n>0)&&(temp==(sum=n+nSum(n-1)));
		return sum;
	}
	
	/**
	 * 
	  * 输入一个已经按升序排序过的数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字。
	  * 要求时间复杂度是O(n)。如果有多对数字的和等于输入的数字，输出任意一对即可。
	  * 例如输入数组1、2、4、7、11、15 和数字15。由于4+11=15，因此输出4 和11。
	  * 
	  * 解：使用两个指针，一个从数组前f，一个从数组后遍历e，当两者之和小于给定的数字时，f++, 当两者之和大于给定的数字时，e--，
	  * 直到和与给定的数字相等，或者f=e
	  * @param arr
	  * @param k
	  * @return    
	  * @return int
	 */
	public void find2Number(int[] arr, int k){
		int f=0, e=arr.length-1;
		while((arr[f]+arr[e]) != k && f<e){
			if((arr[f]+arr[e]) < k) 
				f++;
			else
				e--;
		}
		if((arr[f]+arr[e]) == k){
			System.out.println("Found: " + arr[f] + " and " + arr[e]);
		}else{
			System.out.println("Not Found" );
		}
	}
}
