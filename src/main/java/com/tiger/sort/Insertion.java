package com.tiger.sort;

import java.util.Arrays;

/**
 * @auther Jack
 * @date 2020/2/21 21:24
 */

public class Insertion<T extends Comparable<T>> implements Sortable<T> {
	@Override
	public void sort(T[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			T toInsert = arr[i];
			int j = i;
			for (; j > 0; j--) {
				if (less(toInsert, arr[j - 1])) {
					arr[j] = arr[j - 1];
				}
			}
			arr[j] = toInsert;
		}
	}

	//v2 减少交换
	public void sortV2(T[] arr) {
		for (int i = 1; i < arr.length; i++) {
			T toInsert = arr[i];
			int j;
			for (j = i; j > 0 && less(toInsert, arr[j - 1]); j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = toInsert;
		}
	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[]{5, 4, 3, 2, 1};
//        Integer[] arr = new Integer[]{1, 2, 4, 3, 5};

		new Insertion<Integer>().sort(arr);

		System.out.println(Arrays.toString(arr));
	}
}
