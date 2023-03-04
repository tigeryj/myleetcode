//435.无重叠区间
//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。 
//
// 注意: 
//
// 
// 可以认为区间的终点总是大于它的起点。 
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。 
// 
//
// 示例 1: 
//
// 
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
// Related Topics 贪心算法

package com.tiger.leetcode.editor.cn;

import com.tiger.utils.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class NonOverlappingIntervals {
	public static void main(String[] args) {
		Solution solution = new NonOverlappingIntervals().new Solution();
		int[][] pairs = new int[][]{{1, 2}, {1, 2}, {1, 2}};
		int[][] pairs2 = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
		int[][] pairs3 = new int[][]{{1, 2}, {2, 3}};
		int[][] pairs4 = new int[][]{{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}};
		System.out.println(solution.eraseOverlapIntervals(pairs));//2
		System.out.println(solution.eraseOverlapIntervals(pairs2));//1
		System.out.println(solution.eraseOverlapIntervals(pairs3));//0
		System.out.println(solution.eraseOverlapIntervals(pairs4));//2


	}
	//暴力法
	//动态规划
	//贪心

	//leetcode submit region begin(Prohibit modification and deletion)

	//Date:2020-06-15 22:32:49
	//解答成功: 执行耗时:6 ms,击败了26.65% 的Java用户
	//贪心
	class Solution {

		public int eraseOverlapIntervals(int[][] intervals) {
			if (intervals == null || intervals.length == 0) return 0;

			Pair<Integer, Integer>[] pairs = new Pair[intervals.length];

			for (int i = 0; i < intervals.length; i++) {
				pairs[i] = new Pair(intervals[i][0], intervals[i][1]);
			}

			Arrays.sort(pairs, new Comparator<Pair<Integer, Integer>>() {
				@Override
				public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
					return o1.getValue() - o2.getValue();
				}
			});

			int res = 1;
			int pre = 0;
			for (int i = 1; i < pairs.length; i++) {
				if (pairs[i].getKey() >= pairs[pre].getValue()) {
					res++;
					pre = i;
				}
			}

			return pairs.length - res;
		}

	}
	//leetcode submit region end(Prohibit modification and deletion)

	//Date:2020-06-15 00:21:23
	//DP
	//执行耗时:7 ms,击败了14.69% 的Java用户
	class SolutionV2 {

		public int eraseOverlapIntervals(int[][] intervals) {
			if (intervals == null || intervals.length == 0) return 0;

			Pair<Integer, Integer>[] pairs = new Pair[intervals.length];

			for (int i = 0; i < intervals.length; i++) {
				pairs[i] = new Pair(intervals[i][0], intervals[i][1]);
			}

			Arrays.sort(pairs, new Comparator<Pair<Integer, Integer>>() {
				@Override
				public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
					return o1.getKey() - o2.getKey();
				}
			});

			//dp[i]表示以pair[i]结尾的最长的不重叠的个数
			int dp[] = new int[pairs.length];
			int max = 1;
			for (int i = 0; i < pairs.length; i++) {
				dp[i] = 1;
				for (int j = i - 1; j >= 0; j--) {
					if (pairs[i].getKey() >= pairs[j].getValue()) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
						break;
					}
				}
				max = Math.max(max, dp[i]);
			}

			return pairs.length - max;
		}

	}


	//Date:2020-06-14 23:48:51
	//Brute Force
	//Time Limit Exceeded
	class SolutionV1 {

		private int max = Integer.MIN_VALUE;

		public int eraseOverlapIntervals(int[][] intervals) {
			max = Integer.MIN_VALUE;
			List<Pair<Integer, Integer>> path = new LinkedList<>();
			dfs(intervals, 0, path);

			return intervals.length - max;
		}

		private void dfs(int[][] intervals, int start, List<Pair<Integer, Integer>> path) {
			if (start == intervals.length) {
				max = Math.max(max, path.size());
				return;
			}

			for (int i = start; i < intervals.length; i++) {
				if (notOverlap(path, intervals[i])) {
					path.add(new Pair<>(intervals[i][0], intervals[i][1]));
					dfs(intervals, start + 1, path);
					path.remove(path.size() - 1);
				}
				dfs(intervals, start + 1, path);
			}

		}

		private boolean notOverlap(List<Pair<Integer, Integer>> path, int[] interval) {

			for (Pair<Integer, Integer> pair : path) {
				if (interval[0] >= pair.getValue() || interval[1] <= pair.getKey()) {
					continue;
				} else {
					return false;
				}
			}
			return true;
		}
	}

}