//剑指 Offer 11.旋转数组的最小数字
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
//
// 示例 1： 
//
// 输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/ 
// Related Topics 二分查找

package com.tiger.leetcode.editor.cn;

public class XuanZhuanShuZuDeZuiXiaoShuZiLcof {
	public static void main(String[] args) {
		Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
		System.out.println(solution.minArray(new int[]{5, 6, 7, 8, 0, 1, 2, 3}));
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	//Date:2020-06-28 21:59:46
	//解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户
	class Solution {
		public int minArray(int[] numbers) {
			if (numbers == null || numbers.length == 0) throw new IllegalArgumentException();

			int l = 0, r = numbers.length - 1;

			int mid;
			while (l < r) {
				mid = l + (r - l) / 2;
				if (numbers[mid] > numbers[r]) {
					l = mid + 1;
				} else if (numbers[mid] < numbers[r]) {
					r = mid;
				} else {
					r--;
				}
			}

			return numbers[r];
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}