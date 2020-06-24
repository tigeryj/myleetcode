//263.丑数
//编写一个程序判断给定的数是否为丑数。 
//
// 丑数就是只包含质因数 2, 3, 5 的正整数。 
//
// 示例 1: 
//
// 输入: 6
//输出: true
//解释: 6 = 2 × 3 
//
// 示例 2: 
//
// 输入: 8
//输出: true
//解释: 8 = 2 × 2 × 2
// 
//
// 示例 3: 
//
// 输入: 14
//输出: false 
//解释: 14 不是丑数，因为它包含了另外一个质因数 7。 
//
// 说明： 
//
// 
// 1 是丑数。 
// 输入不会超过 32 位有符号整数的范围: [−231, 231 − 1]。 
// 
// Related Topics 数学

package com.tiger.leetcode.editor.cn;

public class UglyNumber {
	public static void main(String[] args) {
		Solution solution = new UglyNumber().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	//Date:2020-06-24 23:51:44
	//解答成功: 执行耗时:1 ms,击败了100.00% 的Java用户
	class Solution {
		public boolean isUgly(int num) {
			if (num <= 0) return false;//不加这个判断就超时了。

			while (num % 2 == 0) {
				num /= 2;
			}
			while (num % 3 == 0) {
				num /= 3;
			}
			while (num % 5 == 0) {
				num /= 5;
			}

			return num == 1;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}