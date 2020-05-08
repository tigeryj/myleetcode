//279.完全平方数
//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 示例 1: 
//
// 输入: n = 12
//输出: 3 
//解释: 12 = 4 + 4 + 4. 
//
// 示例 2: 
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9. 
// Related Topics 广度优先搜索 数学 动态规划

package com.tiger.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {
	public static void main(String[] args) {
		Solution solution = new PerfectSquares().new Solution();
		System.out.println(solution.numSquares(1));
		System.out.println(solution.numSquares(12));
		System.out.println(solution.numSquares(13));
		System.out.println(solution.numSquares(9));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int numSquares(int n) {
			Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
			Pair<Integer, Integer> originNode = new Pair<>(n, 0);
			queue.add(originNode);
			boolean[] visited = new boolean[n + 1];
			visited[n] = true;
			while (!queue.isEmpty()) {
				Pair<Integer, Integer> poll = queue.poll();
				int node = poll.getKey();
				int level = poll.getValue();
				for (int i = 1; ; i++) {
					int next = node - i * i;
					if (next < 0) break;
					if (next == 0) return level + 1;
					if (visited[next]) continue;
					visited[next] = true;
					queue.add(new Pair(next, level + 1));
				}
			}
			throw new IllegalArgumentException("Caculate error!");
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}