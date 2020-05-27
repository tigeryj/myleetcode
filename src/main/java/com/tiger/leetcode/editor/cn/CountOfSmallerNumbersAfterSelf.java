//315.计算右侧小于当前元素的个数
//给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 num
//s[i] 的元素的数量。 
//
// 示例: 
//
// 输入: [5,2,6,1]
//输出: [2,1,1,0] 
//解释:
//5 的右侧有 2 个更小的元素 (2 和 1).
//2 的右侧仅有 1 个更小的元素 (1).
//6 的右侧有 1 个更小的元素 (1).
//1 的右侧有 0 个更小的元素.
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法

package com.tiger.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
	public static void main(String[] args) {
		Solution solution = new CountOfSmallerNumbersAfterSelf().new Solution();
		solution.countSmaller(new int[]{5, 2, 6, 1});
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		private Pair<Integer, Integer>[] aux;
		private int[] count;

		public List<Integer> countSmaller(int[] nums) {
			List<Integer> res = new ArrayList<>();
			if (nums == null || nums.length == 0) return res;

			aux = new Pair[nums.length];
			Pair<Integer, Integer>[] pairs = new Pair[nums.length];
			count = new int[nums.length];

			for (int i = 0; i < nums.length; i++) {
				pairs[i] = new Pair<>(nums[i], i);
			}

			mergeSort(pairs, 0, nums.length - 1);

			for (int i = 0; i < nums.length; i++) {
				res.add(count[i]);
			}
			return res;
		}

		private void mergeSort(Pair<Integer, Integer>[] pairs, int l, int r) {
			if (l >= r) return;

			int mid = l + (r - l) / 2;

			mergeSort(pairs, l, mid);
			mergeSort(pairs, mid + 1, r);

			merge(pairs, l, mid, r);
		}

		private void merge(Pair<Integer, Integer>[] pairs, int l, int mid, int r) {

			for (int i = l; i <= r; i++) {
				aux[i] = pairs[i];
			}
			int m = l, n = mid + 1;

			for (int i = l; i <= r; i++) {
				if (m > mid) {
					pairs[i] = aux[n++];
				} else if (n > r) {
					pairs[i] = aux[m++];
					count[pairs[i].getValue()] += r - mid;
				} else if (aux[m].getKey() <= aux[n].getKey()) {
					pairs[i] = aux[m++];
					count[pairs[i].getValue()] += n - 1 - mid;
				} else {
					pairs[i] = aux[n++];
				}
			}

		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}