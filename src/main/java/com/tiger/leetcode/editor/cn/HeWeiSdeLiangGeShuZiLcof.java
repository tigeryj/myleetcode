//剑指 Offer 57.和为s的两个数字
//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
// 
//
// 示例 2： 
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 
// 👍 30 👎 0

package com.tiger.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class HeWeiSdeLiangGeShuZiLcof {
	public static void main(String[] args) {
		Solution solution = new HeWeiSdeLiangGeShuZiLcof().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	//Date:2020-07-19 20:23:40
	//解答成功: 执行耗时:2 ms,击败了98.18% 的Java用户
	class Solution {
		public int[] twoSum(int[] nums, int target) {
			if (nums == null || nums.length == 0) return new int[0];

			int l = 0, r = nums.length - 1;
			while (l < r) {
				int other = target - nums[r];
				if (nums[l] == other) {
					return new int[]{nums[l], nums[r]};
				} else if (nums[l] > other) {
					r--;
				} else {
					l++;
				}
			}
			return new int[0];
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

	//Date:2020-07-19 20:16:03
	//解答成功: 执行耗时:44 ms,击败了21.75% 的Java用户
	class SolutionV2 {
		public int[] twoSum(int[] nums, int target) {
			if (nums == null || nums.length == 0) return new int[0];

			for (int i = 0; i < nums.length; i++) {
				int other = find(nums, i + 1, target - nums[i]);
				if (other != -1) {
					return new int[]{nums[i], nums[other]};
				}
			}
			return new int[0];
		}

		private int find(int[] nums, int begin, int target) {
			int l = begin, r = nums.length - 1;
			while (l <= r) {
				int mid = l + (r - l) / 2;
				if (nums[mid] == target) {
					return mid;
				} else if (nums[mid] > target) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			}
			return -1;
		}
	}

	//Date:2020-07-19 20:07:28
	//解答成功: 执行耗时:56 ms,击败了13.87% 的Java用户
	class SolutionV1 {
		public int[] twoSum(int[] nums, int target) {
			if (nums == null || nums.length == 0) return new int[0];
			Set<Integer> set = new HashSet<>();
			for (int num : nums) {
				if (set.contains(target - num)) return new int[]{num, target - num};
				set.add(num);
			}
			return new int[0];
		}
	}

}