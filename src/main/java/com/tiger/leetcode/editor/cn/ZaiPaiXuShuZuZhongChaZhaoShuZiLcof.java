//剑指 Offer 53 - I.在排序数组中查找数字 I
//统计一个数字在排序数组中出现的次数。
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 45 👎 0

package com.tiger.leetcode.editor.cn;

public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
	public static void main(String[] args) {
		Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	//Date:2020-07-15 20:30:41
	//解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户
	class Solution {

		public int search(int[] nums, int target) {
			if (nums == null || nums.length == 0) return 0;
			int i = 0, j = nums.length - 1;
			int mid;
			int targetIndex = -1;
			int res = 0;
			while (i <= j) {
				mid = i + (j - i) / 2;
				if (nums[mid] < target) {
					i = mid + 1;
				} else if (nums[mid] > target) {
					j = mid - 1;
				} else {
					targetIndex = mid;
					break;
				}
			}
			if (targetIndex == -1) return 0;

			int l = targetIndex, r = targetIndex + 1;

			while (l >= 0 && nums[l] == nums[targetIndex]) {
				res++;
				l--;
			}

			while (r < nums.length && nums[r] == nums[targetIndex]) {
				res++;
				r++;
			}

			return res;
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

	//Date:2020-07-15 20:19:25
	//解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户
	class SolutionV1 {
		private int count;
		private int target;

		public int search(int[] nums, int target) {
			if (nums == null || nums.length == 0) return 0;
			this.target = target;
			find(nums, 0, nums.length - 1);
			return count;
		}

		private void find(int[] nums, int start, int end) {
			if (start > end) return;

			int mid = start + (end - start) / 2;

			if (nums[mid] > target) {
				find(nums, start, mid - 1);
			} else if (nums[mid] < target) {
				find(nums, mid + 1, end);
			} else {
				count++;
				find(nums, start, mid - 1);
				find(nums, mid + 1, end);
			}
		}
	}

}