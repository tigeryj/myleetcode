//剑指 Offer 03.数组中重复的数字
//找出数组中重复的数字。 
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表

package com.tiger.leetcode.editor.cn;

public class ShuZuZhongZhongFuDeShuZiLcof {
	public static void main(String[] args) {
		Solution solution = new ShuZuZhongZhongFuDeShuZiLcof().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	//Date:2020-06-25 00:00:46
	//解答成功: 执行耗时:2 ms,击败了70.79% 的Java用户
	class Solution {
		public int findRepeatNumber(int[] nums) {
			boolean[] visited = new boolean[100000];

			for (int i = 0; i < nums.length; i++) {
				if (visited[nums[i]]) return nums[i];
				visited[nums[i]] = true;
			}
			throw new IllegalArgumentException("Not find repeat number");
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}