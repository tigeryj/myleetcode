//剑指 Offer 57 - II.和为s的连续正数序列
//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// 👍 131 👎 0

package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class HeWeiSdeLianXuZhengShuXuLieLcof {
	public static void main(String[] args) {
		Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
		System.out.println(solution.findContinuousSequence(15));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	//slid window 滑动窗口
	class Solution {
		public int[][] findContinuousSequence(int target) {
			if (target < 1) return new int[0][0];

			List<int[]> list = new ArrayList<>();
			//窗口[i,j]
			int i = 1, j = 0, sum = 0;
			while (i <= target / 2) {
				if (sum < target) {
					j++;
					sum += j;
				} else if (sum > target) {
					sum -= i;
					i++;
				} else {
					int[] path = new int[j - i + 1];
					for (int k = i; k <= j; k++) {
						path[k - i] = k;
					}
					list.add(path);
					sum -= i;
					i++;
				}
			}
			int[][] res = new int[list.size()][];
			for (int k = 0; k < list.size(); k++) {
				res[k] = list.get(k);
			}
			return res;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

	//Time Limit Exceeded
	//Date:2020-07-29 20:29:15
	class SolutionV1 {
		public int[][] findContinuousSequence(int target) {
			if (target < 1) return new int[0][0];

			List<List<Integer>> list = new ArrayList<>();
			for (int begin = 1; begin <= target / 2; begin++) {
				int sum = 0;
				List<Integer> path = new ArrayList<>();
				for (int i = begin; i <= target / 2 + 1; i++) {
					sum += i;
					path.add(i);
					if (sum == target) {
						list.add(path);
						break;
					}
				}
			}

			int[][] res = new int[list.size()][];

			for (int i = 0; i < list.size(); i++) {
				res[i] = new int[list.get(i).size()];
				for (int j = 0; j < list.get(i).size(); j++) {
					res[i][j] = list.get(i).get(j);
				}
			}
			return res;
		}
	}

}