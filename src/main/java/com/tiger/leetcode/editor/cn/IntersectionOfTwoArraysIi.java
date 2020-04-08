// 350.两个数组的交集 II
// 给定两个数组，编写一个函数来计算它们的交集。
//
// 示例 1:
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
// 输出: [2,2]
//
//
// 示例 2:
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// 输出: [4,9]
//
// 说明：
//
//
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
// 我们可以不考虑输出结果的顺序。
//
//
// 进阶:
//
//
// 如果给定的数组已经排好序呢？你将如何优化你的算法？
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
// 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
//
// Related Topics 排序 哈希表 双指针 二分查找

package com.tiger.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArraysIi {
	public static void main(String[] args) {
		Solution solution = new IntersectionOfTwoArraysIi().new Solution();
		int[] arr1 = {4, 4, 7, 8, 8};
		int[] arr2 = {4, 4, 8};
		int[] intersect = solution.intersect(arr1, arr2);
		System.out.println(Arrays.toString(intersect));
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		// 如果给定的数组已经排好序呢？你将如何优化你的算法？
		// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
		// 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
		public int[] intersect(int[] nums1, int[] nums2) {
			if (nums1 == null || nums2 == null) return new int[]{};
			int i = 0, j = 0, begin = 0;
			Arrays.sort(nums1);
			Arrays.sort(nums2);
			int[] res = new int[nums1.length];

			while (i < nums1.length && j < nums2.length) {
				if (nums1[i] == nums2[j]) {
					res[begin++] = nums1[i];
					i++;
					j++;
				} else if (nums1[i] < nums2[j]) {
					i++;
				} else {
					j++;
				}
			}
			return Arrays.copyOf(res, begin);
		}
	}

	// leetcode submit region end(Prohibit modification and deletion)
	public int[] intersect1(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null) return new int[]{};

		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums1) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		int[] res = new int[nums2.length];
		int count = 0;
		for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
				res[count++] = nums2[i];
				map.put(nums2[i], map.get(nums2[i]) - 1);
			}
		}
		return Arrays.copyOf(res, count);
	}
}
