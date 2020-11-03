//剑指 Offer 53 - II.0～n-1中缺失的数字
//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
//这个数字。
//
//
//
// 示例 1:
//
// 输入: [0,1,3]
//输出: 2
//
//
// 示例 2:
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8
//
//
//
// 限制：
//
// 1 <= 数组长度 <= 10000
// Related Topics 数组 二分查找
// 👍 38 👎 0

package com.tiger.leetcode.editor.cn;

public class QueShiDeShuZiLcof {
	public static void main(String[] args) {
		Solution solution = new QueShiDeShuZiLcof().new Solution();
		System.out.println(solution.missingNumber(new int[]{0}));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	//[0,1,2,3,4,6,7] n = 7
	//Date:2020-07-16 22:58:27
	//解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户
	class Solution {
		public int missingNumber(int[] nums) {
			if (nums == null || nums.length == 0) throw new IllegalArgumentException();
			int l = 0, r = nums.length - 1;
			while (l <= r) {
				int mid = l + (r - l) / 2;
				if (nums[mid] != mid) {
					if (mid - 1 < 0 || nums[mid - 1] == mid - 1) return mid;
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			}
			return l == nums.length ? nums.length : l - 1;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}