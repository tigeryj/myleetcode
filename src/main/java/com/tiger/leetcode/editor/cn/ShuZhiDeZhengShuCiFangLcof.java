//剑指 Offer 16.数值的整数次方
//实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数
//问题。 
//
// 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归

package com.tiger.leetcode.editor.cn;

public class ShuZhiDeZhengShuCiFangLcof {
	public static void main(String[] args) {
		Solution solution = new ShuZhiDeZhengShuCiFangLcof().new Solution();
		System.out.println(solution.myPow(2, Integer.MIN_VALUE));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	//解答成功: 执行耗时:1 ms,击败了93.99% 的Java用户
	//recursive
	class Solution {
		public double myPow(double x, int n) {
			long N = n;
			if (N < 0) {
				x = 1 / x;
				N *= -1;
			}

			return myPow(x, N);
		}

		private double myPow(double x, long N) {
			if (N == 0) return 1;

			if (N % 2 == 0) {
				double p = myPow(x, N / 2);
				return p * p;
			} else {
				double p = myPow(x, (N - 1) / 2);
				return p * p * x;
			}
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)


	//Date:2020-07-01 21:14:29
	//解答成功: 执行耗时:1 ms,击败了93.99% 的Java用户
	class SolutionV1 {
		public double myPow(double x, int n) {
			long N = n;
			N = N < 0 ? -N : N;

			double res = 1;

			while (N > 0) {
				if ((N & 1) == 1) {
					res *= x;
				}
				x *= x;
				N = N >> 1;
			}

			return n < 0 ? 1 / res : res;
		}
	}

}