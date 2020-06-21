//剑指 Offer 40.最小的k个数
//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法

package com.tiger.leetcode.editor.cn;

import java.util.Arrays;

public class ZuiXiaoDeKgeShuLcof {
	public static void main(String[] args) {
		Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
		int[] arr = new int[]{4, 3, 5, 6, -1, 3, 4, 6, 76, 2, 53, 26, 26};
		System.out.println(Arrays.toString(solution.getLeastNumbers(arr, 5)));
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	//Date:2020-06-20 21:09:36
	//执行耗时:2 ms,击败了99.44% 的Java用户
	class Solution {
		public int[] getLeastNumbers(int[] arr, int k) {
			if (arr == null || arr.length == 0 || k == 0) return new int[0];
			if (arr.length <= k) return arr;
			int l = 0, r = arr.length - 1;
			while (true) {
				int partition = partition(arr, l, r);
				if (partition < k) {
					l = partition + 1;
				} else if (partition > k) {
					r = partition - 1;
				} else {
					break;
				}
			}
			return Arrays.copyOf(arr, k);
		}

		private int partition(int[] arr, int start, int end) {
			if (start >= end) return start;

			int v = arr[start];
			//arr[start+1,i)<v  arr(j,end]>v
			int i = start + 1, j = end;
			while (true) {
				while (i <= end && arr[i] < v) {
					i++;
				}
				while (j >= start && arr[j] > v) {
					j--;
				}
				if (i > j) break;
				swap(arr, i, j);
				i++;
				j--;
			}
			swap(arr, start, j);
			return j;
		}

		private void swap(int[] arr, int i, int j) {
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)
/*
	public void quickSort(int[] arr, int start, int end) {
		if (start >= end) return;

		int partition = partition(arr, start, end);

		quickSort(arr, start, partition - 1);
		quickSort(arr, partition + 1, end);
	}

*/
}