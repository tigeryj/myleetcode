//剑指 Offer 49.丑数
//我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 1 2 3 4 5 6 8 9 10 12
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学

package com.tiger.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class ChouShuLcof {
	public static void main(String[] args) {
		Solution solution = new ChouShuLcof().new Solution();
		System.out.println(solution.nthUglyNumber(1352));
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	//Date:2020-06-23 23:04:34
	//解答成功: 执行耗时:3 ms,击败了80.56% 的Java用户
	class Solution {
		public int nthUglyNumber(int n) {
			if (n <= 0) throw new IllegalArgumentException();

			int a = 0, b = 0, c = 0;
			int[] dp = new int[n];
			dp[0] = 1;
			for (int i = 1; i < n; i++) {
				dp[i] = Math.min(dp[a] * 2, Math.min(dp[b] * 3, dp[c] * 5));
				if (dp[i] == dp[a] * 2) {
					a++;
				}
				if (dp[i] == dp[b] * 3) {
					b++;
				}
				if (dp[i] == dp[c] * 5) {
					c++;
				}
			}
			return dp[n - 1];
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

	//Time Limit Exceeded
	class SolutionV1 {
		public int nthUglyNumber(int n) {
			if (n <= 0) throw new IllegalArgumentException();
			if (n <= 5) return n;

			Set<Integer> set = new HashSet<>();
			int res = 0;
			while (n > 0) {
				res++;
				if (isUgly(res, set)) {
					set.add(res);
					n--;
				}
			}
			return res;
		}

		public boolean isUgly(int num, Set<Integer> set) {
			if (num == 1) return true;
			return (num % 2 == 0 && set.contains(num / 2)) ||
				(num % 3 == 0 && set.contains(num / 3)) ||
				(num % 5 == 0 && set.contains(num / 5));
		}
	}
}