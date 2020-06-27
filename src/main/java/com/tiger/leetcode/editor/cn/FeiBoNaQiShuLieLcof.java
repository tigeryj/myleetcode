//剑指 Offer 10- I.斐波那契数列
//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下： 
//
// F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 0 1 1 2 3 5 8 13
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 509 题相同：https://leetcode-cn.com/problems/fibonacci-number/ 
// Related Topics 递归

package com.tiger.leetcode.editor.cn;

public class FeiBoNaQiShuLieLcof {
	public static void main(String[] args) {
		Solution solution = new FeiBoNaQiShuLieLcof().new Solution();
		System.out.println(solution.fib(48));
		System.out.println(solution.fib(49));
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	//Date:2020-06-27 21:26:14
	//解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户
	class Solution {
		public int fib(int n) {
			if (n < 0) throw new IllegalArgumentException();
			if (n < 2) return n;
//			int[] dp = new int[n + 1];
//			dp[0] = 0;
//			dp[1] = 1;
			int pre = 0;
			int cur = 1;
			int next;
			for (int i = 2; i <= n; i++) {
				next = (pre + cur) % 1000000007;
				pre = cur;
				cur = next;
			}
			return cur;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}