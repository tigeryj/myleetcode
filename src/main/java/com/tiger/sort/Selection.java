package com.tiger.sort;

import java.util.Arrays;

/**
 * @auther Jack
 * @date 2020/2/21 21:38
 */

public class Selection<T extends Comparable<T>> implements Sortable<T> {
	@Override
	public void sort(T[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (less(arr[j], arr[minIndex])) {
					minIndex = j;
				}
			}
			swap(arr, minIndex, i);
		}
	}

	public static void main(String[] args) {
//        Integer[] arr = new Integer[]{5, 4, 3, 2, 1};
		Integer[] arr = new Integer[]{1, 2, 4, 3, 5};

		new Selection<Integer>().sort(arr);

		System.out.println(Arrays.toString(arr));
	}
}
