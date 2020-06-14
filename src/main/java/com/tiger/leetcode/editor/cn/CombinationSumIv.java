//377.组合总和 Ⅳ
//给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。 
//
// 示例: 
//
// 
//nums = [1, 2, 3]
//target = 4
//
//所有可能的组合为：
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//
//请注意，顺序不同的序列被视作不同的组合。
//
//因此输出为 7。
// 
//
// 进阶： 
//如果给定的数组中含有负数会怎么样？ 
//问题会产生什么变化？ 
//我们需要在题目中添加什么限制来允许负数的出现？ 
//
// 致谢： 
//特别感谢 @pbrother 添加此问题并创建所有测试用例。 
// Related Topics 动态规划

package com.tiger.leetcode.editor.cn;

public class CombinationSumIv {
	public static void main(String[] args) {
		Solution solution = new CombinationSumIv().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	//Date:2020-06-10 21:53:01
	//执行耗时:1 ms,击败了99.64% 的Java用户
	class Solution {
		public int combinationSum4(int[] nums, int target) {
			if (nums == null || target < 0) return 0;
			int n = nums.length;

			int[] dp = new int[target + 1];

			dp[0] = 1;

			for (int i = 1; i <= target; i++) {
				for (int num : nums) {
					if (i >= num) {
						dp[i] += dp[i - num];
					}
				}
			}
			return dp[target];
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}