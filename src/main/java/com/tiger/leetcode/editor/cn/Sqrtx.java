//69.x 的平方根
//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找

package com.tiger.leetcode.editor.cn;

public class Sqrtx {
	public static void main(String[] args) {
		Solution solution = new Sqrtx().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	//Date:2020-06-18 21:56:53
	//解答成功: 执行耗时:2 ms,击败了59.30% 的Java用户
	class Solution {
		public int mySqrt(int x) {
			if (x == 0) return 0;
			if (x < 4) return 1;

			long l = 2;
			long r = x / 2;

			while (l <= r) {
				long mid = l + (r - l) / 2;
				long res = mid * mid;
				if (res > x) {
					r = mid - 1;
				} else if (res < x) {
					l = mid + 1;
				} else {
					return (int) mid;
				}
			}
			return (int) r;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}