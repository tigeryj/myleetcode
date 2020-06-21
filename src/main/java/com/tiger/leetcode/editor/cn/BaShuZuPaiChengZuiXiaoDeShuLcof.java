//剑指 Offer 45.把数组排成最小的数
//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 排序

package com.tiger.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class BaShuZuPaiChengZuiXiaoDeShuLcof {
	public static void main(String[] args) {
		Solution solution = new BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
		String s = solution.minNumber(new int[]{3, 30, 34, 5, 1, 9, 21});
		System.out.println(s);
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	//Date:2020-06-21 23:20:42
	//解答成功: 执行耗时:5 ms,击败了98.75% 的Java用户
	class Solution {
		public String minNumber(int[] nums) {

			String[] strs = new String[nums.length];
			for (int i = 0; i < nums.length; i++) {
				strs[i] = String.valueOf(nums[i]);
			}
			sort(strs, 0, strs.length - 1);

			StringBuilder sb = new StringBuilder();
			for (String s : strs) {
				sb.append(s);
			}
			return sb.toString();
		}

		private void sort(String[] strs, int start, int end) {
			if (start >= end) return;
			int partition = partition(strs, start, end);
			sort(strs, start, partition - 1);
			sort(strs, partition + 1, end);
		}

		private int partition(String[] strs, int start, int end) {
			if (start >= end) return start;
			String v = strs[start];
			//[start+1,i)<v (j,end]>v
			int i = start + 1, j = end;
			while (i <= j) {
				while (i <= end && compare(strs[i], v) <= 0) {
					i++;
				}

				while (j >= start + 1 && compare(strs[j], v) >= 0) {
					j--;
				}
				if (i >= j) break;
				swap(strs, i, j);
				i++;
				j--;
			}
			swap(strs, start, j);
			return j;
		}

		private void swap(String[] strs, int i, int j) {
			String tmp = strs[i];
			strs[i] = strs[j];
			strs[j] = tmp;
		}


		public int compare(String num1, String num2) {
			String a = num1 + num2;
			String b = num2 + num1;
			int i = 0;
			while (i < a.length() && i < b.length()) {
				if (a.charAt(i) > b.charAt(i)) {
					return 1;
				} else if (a.charAt(i) < b.charAt(i)) {
					return -1;
				}
				i++;
			}
			return a.length() - b.length();
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)


	//Date:2020-06-21 22:54:47
	//解答成功: 执行耗时:5 ms,击败了98.75% 的Java用户
	class SolutionV1 {
		public String minNumber(int[] nums) {

			Comparator<String> comparator = new Comparator<String>() {
				@Override
				public int compare(String num1, String num2) {
					String a = num1 + num2;
					String b = num2 + num1;
					int i = 0;
					while (i < a.length() && i < b.length()) {
						if (a.charAt(i) > b.charAt(i)) {
							return 1;
						} else if (a.charAt(i) < b.charAt(i)) {
							return -1;
						}
						i++;
					}

					return a.length() - b.length();

				}
			};

			String[] strs = new String[nums.length];
			for (int i = 0; i < nums.length; i++) {
				strs[i] = String.valueOf(nums[i]);
			}

			Arrays.sort(strs, comparator);

			StringBuilder sb = new StringBuilder();
			for (String s : strs) {
				sb.append(s);
			}
			return sb.toString();
		}


		private int compare(int n1, int n2) {
			String num1 = String.valueOf(n1);
			String num2 = String.valueOf(n2);

			String a = num1 + num2;
			String b = num2 + num1;
			int i = 0;
			while (i < a.length() && i < b.length()) {
				if (a.charAt(i) > b.charAt(i)) return 1;
			}

			return a.length() - b.length();

		}
	}
}