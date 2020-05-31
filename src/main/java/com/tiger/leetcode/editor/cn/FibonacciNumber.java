//509.斐波那契数
//斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
// 
//
// 给定 N，计算 F(N)。 
//
// 
//
// 示例 1： 
//
// 输入：2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
// 
//
// 示例 2： 
//
// 输入：3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
// 
//
// 示例 3： 
//
// 输入：4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
// 
//
// 
//
// 提示： 
//
// 
// 0 ≤ N ≤ 30 
// 
// Related Topics 数组

package com.tiger.leetcode.editor.cn;

public class FibonacciNumber {
	public static void main(String[] args) {
		Solution solution = new FibonacciNumber().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	//执行耗时:0ms,击败了100.00%的Java用户
	//Date:2020-05-28 21:46:19
	class Solution {
		public int fib(int N) {
			if (N < 2) return N;

			int[] aux = new int[N + 1];
			aux[0] = 0;
			aux[1] = 1;
			for (int i = 2; i < N + 1; i++) {
				aux[i] = aux[i - 1] + aux[i - 2];
			}
			return aux[N];
		}

	}

	//执行耗时:0 ms,击败了100.00% 的Java用户
	//内存消耗:36.6 MB,击败了5.26% 的Java用户
	class SolutionV2 {
		public int fib(int N) {
			int[] aux = new int[N + 1];
			for (int i = 0; i < N + 1; i++) {
				aux[i] = -1;
			}

			return fib(N, aux);
		}

		private int fib(int N, int[] aux) {
			if (N == 0) return 0;
			if (N == 1) return 1;
			if (aux[N] == -1) {
				aux[N] = fib(N - 1, aux) + fib(N - 2, aux);
			}
			return aux[N];
		}
	}

	//leetcode submit region end(Prohibit modification and deletion)
	//执行耗时:10 ms,击败了21.15% 的Java用户
	class SolutionV1 {
		public int fib(int N) {
			if (N == 0) return 0;
			if (N == 1) return 1;

			return fib(N - 1) + fib(N - 2);
		}
	}

}