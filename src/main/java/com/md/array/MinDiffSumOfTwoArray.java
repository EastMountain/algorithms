package com.md.array;

import java.util.Arrays;

public class MinDiffSumOfTwoArray {

	/**
	 * 
	  * 有两个序列a,b，大小都为n,序列元素的值任意整数，无序；要求：通过交换a,b 中的元素，使[序列a 元素的和]与[序列b 元素的和]之间的差最小。
	  * 例如:var a=[100,99,98,1,2, 3];
	  * var b=[1, 2, 3, 4,5,40];
	  * 
	  * 
	  * 先对a，b合并然后排序，之后从大直小放入a，b中，规则是先往a里放，然后放b，直到b的元素和大于等于a，然再往b里放，以此类推, a,b的长度不能超过原来的长度
	  * @param a
	  * @param b    
	  * @return void
	 */
	public static void process(int[] a, int[] b) {
		if (a == null || b == null || a.length != b.length) {
			return;
		}
		int length = a.length;
		int[] temp = new int[2 * length];
		System.arraycopy(a, 0, temp, 0, length);
		System.arraycopy(b, 0, temp, length, length);
		Arrays.sort(temp);
		a = new int[length];
		b = new int[length];
		int aSum = 0, aIndex = 0;
		int bSum = 0, bIndex = 0;
		for (int i = temp.length - 1; i >= 0; i--) {
			if (aIndex == length) {
				b[bIndex++] = temp[i];
				continue;
			}
			if (bIndex == length) {
				a[aIndex++] = temp[i];
				continue;
			}
			if (aSum > bSum) {
				b[bIndex++] = temp[i];
				bSum += temp[i];
			} else {
				a[aIndex++] = temp[i];
				aSum += temp[i];
			}
		}
		for (int i = 0; i < 2 * length; i++) {
			System.out.print(temp[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < length; i++) {
			System.out.print(b[i] + " ");
		}

	}

	public static void main(String[] args) {
		int[] a = { 100, 99, 98, 1, 2, 3 };
		int[] b = { 1, 2, 3, 4, 5, 40 };
		process(a, b);
	}
}
