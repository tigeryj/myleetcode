package com.tiger.sort;

import java.util.Arrays;

/**
 * @auther Jack
 * @date 2020/4/12 20:26
 */

public class MergeSortReviewV1 {

	public static void main(String[] args) {
		int[] arr = new int[]{-9, 4, 1, 43, 43, 1546, 4, 54, 6, 1, 3, -43, 64, 434, 2143, 4134, 54, 6, 42};

		mergeSortBTU(arr);

		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr) {
		int l = 0, r = arr.length - 1;

		mergeSort(arr, l, r);
	}

	/**
	 * 自底向上
	 */
	private static void mergeSortBTU(int[] arr) {
		int N = arr.length;

		for (int sz = 1; sz < N; sz += sz) {
			for (int i = 0; i + sz < N; i += sz + sz) {
				merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, N - 1));
			}
		}
	}

	/**
	 * 自顶向下
	 */
	private static void mergeSort(int[] arr, int l, int r) {
		if (l == r) return;

		int mid = l + (r - l) / 2;

		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, r);

		merge(arr, l, mid, r);
	}


	private static void merge(int[] arr, int l, int mid, int r) {

		int[] aux = new int[r - l + 1];

		for (int i = l; i <= r; i++) {
			aux[i - l] = arr[i];
		}

		int left = l - l, right = mid - l + 1;

		for (int i = l; i <= r; i++) {
			if (left > mid - l) {
				arr[i] = aux[right++];
			} else if (right > r - l) {
				arr[i] = aux[left++];
			} else if (aux[left] > aux[right]) {
				arr[i] = aux[right++];
			} else {
				arr[i] = aux[left++];
			}
		}
	}

}
