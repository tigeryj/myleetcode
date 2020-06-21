//4.寻找两个正序数组的中位数
//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。 
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法

package com.tiger.leetcode.editor.cn;

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		Solution solution = new MedianOfTwoSortedArrays().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	//Date:2020-06-19 21:07:52
	//执行耗时:2 ms,击败了100.00% 的Java用户
	//内存消耗:40.7 MB,击败了100.00% 的Java用户
	class Solution {
		public double findMedianSortedArrays(int[] nums1, int[] nums2) {
			int l = nums1.length + nums2.length;
			if (l % 2 == 0) {
				int left = findKLargest(nums1, 0, nums2, 0, l / 2);
				int right = findKLargest(nums1, 0, nums2, 0, l / 2 + 1);
				return (left + right) / 2.0;
			} else {
				return findKLargest(nums1, 0, nums2, 0, l / 2 + 1);
			}

		}

		private int findKLargest(int[] nums1, int i, int[] nums2, int j, int k) {
			if (nums1.length - i > nums2.length - j) return findKLargest(nums2, j, nums1, i, k);

			if (i == nums1.length) {
				return nums2[j + k - 1];
			}

			if (k == 1) {
				return (nums1[i] < nums2[j]) ? nums1[i] : nums2[j];
			}

			int endI = Math.min(i + k / 2 - 1, nums1.length - 1);
			int endJ = j - 1 + k - (endI - i + 1);

			if (nums1[endI] < nums2[endJ]) {
				return findKLargest(nums1, endI + 1, nums2, j, k - (endI - i + 1));
			} else if (nums1[endI] > nums2[endJ]) {
				return findKLargest(nums1, i, nums2, endJ + 1, k - (endJ - j + 1));
			} else {
				return nums1[endI];
			}
		}

	}
	//leetcode submit region end(Prohibit modification and deletion)

}