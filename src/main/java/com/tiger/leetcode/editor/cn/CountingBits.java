//338.比特位计数
//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。 
//
// 示例 1: 
//
// 输入: 2
//输出: [0,1,1] 
//
// 示例 2: 
//
// 输入: 5
//输出: [0,1,1,2,1,2] 
//
// 进阶: 
//
// 
// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？ 
// 要求算法的空间复杂度为O(n)。 
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。 
// 
// Related Topics 位运算 动态规划

package com.tiger.leetcode.editor.cn;

public class CountingBits {
	public static void main(String[] args) {
		Solution solution = new CountingBits().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	//Date:2020-06-29 22:29:43
	//解答成功: 执行耗时:2 ms,击败了77.76% 的Java用户
	class Solution {
		public int[] countBits(int num) {
			if (num < 0) return new int[]{};
			int[] dp = new int[num + 1];

			for (int i = 1; i <= num; i++) {
				dp[i] = dp[i / 2] + i % 2;
			}
			return dp;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)


	//Date:2020-06-29 22:24:23
	//解答成功: 执行耗时:2 ms,击败了77.76% 的Java用户
	class SolutionV1 {
		public int[] countBits(int num) {
			if (num < 0) return new int[]{};
			if (num == 0) return new int[1];

			int[] dp = new int[num + 1];
			dp[1] = 1;

			for (int i = 2; i <= num; i++) {
				dp[i] = dp[i >>> 1];
				if ((i & 1) == 1) {
					dp[i] += 1;
				}
			}
			return dp;
		}
	}
}
