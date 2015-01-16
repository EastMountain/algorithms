package com.md.array;

import java.util.List;

import com.google.common.collect.Lists;

public class FindNumber {

	/**
	 * 
	 * .一个int数组，里面数据无任何限制，要求求出所有这样的数a[i]，
	 *其左边的数都小于等于它，右边的数都大于等于它。
	 *能否只用一个额外数组和少量其它空间实现
	 * 
	 */
	public List<Integer> findShunXuNum(int[] a){
		
		List<Integer> maxList = Lists.newArrayList();
		int max = Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++){
			if(a[i]>max){
				max = a[i];
				maxList.add(max);
			}else{
				while(maxList.get(maxList.size()-1) >= a[i]){
					maxList.remove(maxList.size()-1);
				}
			}
		}
		
		return maxList;
	}
}
