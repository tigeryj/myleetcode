//剑指 Offer 43.1～n整数中1出现的次数
//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。 
//
// 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。 
//
// 
//
// 示例 1： 
//
// 输入：n = 12
//输出：5
// 
//
// 示例 2： 
//
// 输入：n = 13
//输出：6 
//
// 
//
// 限制： 
//
// 
// 1 <= n < 2^31 
// 
//
// 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/ 
// Related Topics 数学

package com.tiger.leetcode.editor.cn;

public class OneNzhengShuZhong1chuXianDeCiShuLcof {
	public static void main(String[] args) {
		Solution solution = new OneNzhengShuZhong1chuXianDeCiShuLcof().new Solution();
		System.out.println(solution.countDigitOne(13));
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	//Date:2020-06-21 16:49:18
	//解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户
	class Solution {
		public int countDigitOne(int n) {
			return count(n);
		}

		private int count(int n) {
			if (n <= 0) return 0;

			String num = String.valueOf(n);
			int high = num.charAt(0) - '0';
			int pow = (int) Math.pow(10, num.length() - 1);
			int last = n - high * pow;

			if (high == 1) {
				return last + 1 + count(last) + count(pow - 1);
			} else {
				return pow + high * count(pow - 1) + count(last);
			}
		}

//		private int countOne(int i) {
//			int count = 0;
//			while (i != 0) {
//				if (i % 10 == 1) {
//					count++;
//				}
//				i /= 10;
//			}
//			return count;
//		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}