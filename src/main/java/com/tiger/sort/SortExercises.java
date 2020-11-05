package com.tiger.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @auther Jack
 * @date 2020/11/4 21:19
 */

public class SortExercises {

	public static void selection(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			swap(arr, minIndex, i);
		}
	}


	public static void insertion(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int toInsert = arr[i];
			int j = i;
			for (; j > 0 && arr[j - 1] > toInsert; j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = toInsert;
		}
	}

	public static void bubble(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	public static void quickSort3Ways(int[] arr, int l, int r) {
		if (l >= r) return;

		int v = arr[l];
		int lt = l;//[l+1,lt] <v
		int gt = r + 1;//[gt,r] >v

		int i = l + 1;
		while (i < gt) {
			if (arr[i] < v) {
				swap(arr, lt + 1, i);
				lt++;
				i++;
			} else if (arr[i] > v) {
				swap(arr, i, --gt);
			} else {
				i++;
			}
		}
		swap(arr, l, gt - 1);

		quickSort3Ways(arr, l, lt);
		quickSort3Ways(arr, gt, r);
	}

	private static void swap(int[] arr, int j, int i) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		Random random = new Random(System.currentTimeMillis());
		int[] arr = new int[100];
		for (int i = 0; i < 100; i++) {
			arr[i] = random.nextInt(1000);
		}

		quickSort3Ways(arr, 0, arr.length - 1);

		System.out.println(Arrays.toString(arr));
	}
}
