//剑指 Offer 39.数组中出现次数超过一半的数字
//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 位运算 分治算法

package com.tiger.leetcode.editor.cn;

public class ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof {
	public static void main(String[] args) {
		Solution solution = new ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof().new Solution();
		System.out.println(solution.majorityElement(new int[]{1, 2, 2}));
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	//Date:2020-06-21 11:38:54
	//解答成功: 执行耗时:1 ms,击败了100.00% 的Java用户
	class Solution {
		public int majorityElement(int[] nums) {
			if (nums == null || nums.length == 0) throw new IllegalArgumentException();

			int target = nums[0];
			int vote = 1;

			for (int i = 1; i < nums.length; i++) {
				if (vote == 0) {
					target = nums[i];
					vote++;
				} else if (target == nums[i]) {
					vote++;
				} else if (target != nums[i]) {
					vote--;
				}
			}
			return target;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

	//Date:2020-06-21 11:05:54
	//解答成功: 执行耗时:2 ms,击败了74.31% 的Java用户
	class SolutionV1 {
		public int majorityElement(int[] nums) {
			if (nums == null || nums.length == 0) throw new IllegalArgumentException();

			int target = nums.length / 2;
			int i = 0, j = nums.length - 1, k = 0;

			while (k != target) {
				k = partition(nums, i, j);
				if (k < target) {
					i = k + 1;
				} else if (k > target) {
					j = k - 1;
				}
			}
			return nums[k];
		}

		private int partition(int[] nums, int start, int end) {
			if (start >= end) return start;

			int v = nums[start];
			int i = start + 1, j = end;

			while (i <= j) {
				while (i <= end && nums[i] < v) {
					i++;
				}
				while (j >= start + 1 && nums[j] > v) {
					j--;
				}

				if (i > j) break;

				swap(nums, i, j);
				i++;
				j--;
			}
			swap(nums, start, j);

			return j;
		}

		private void swap(int[] nums, int i, int j) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}
	}

}