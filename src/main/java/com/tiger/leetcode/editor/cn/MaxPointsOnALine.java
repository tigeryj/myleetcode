//149.直线上最多的点数
//给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。 
//
// 示例 1: 
//
// 输入: [[1,1],[2,2],[3,3]]
//输出: 3
//解释:
//^
//|
//|        o
//|     o
//|  o  
//+------------->
//0  1  2  3  4
// 
//
// 示例 2: 
//
// 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出: 4
//解释:
//^
//|
//|  o
//|     o        o
//|        o
//|  o        o
//+------------------->
//0  1  2  3  4  5  6 
// Related Topics 哈希表 数学

package com.tiger.leetcode.editor.cn;

import java.util.HashMap;

public class MaxPointsOnALine {
	public static void main(String[] args) {
		Solution solution = new MaxPointsOnALine().new Solution();
		System.out.println(0 % 4);
		System.out.println(solution.gcd(0, 4));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int maxPoints(int[][] points) {
			int res = 0;
			for (int i = 0; i < points.length; i++) {
				HashMap<String, Integer> map = new HashMap<>();
				int dup = 0;
				int max = 0;
				for (int j = i + 1; j < points.length; j++) {
					int a = points[i][1] - points[j][1];
					int b = points[i][0] - points[j][0];

					if (a == 0 && b == 0) {
						dup++;
					} else {
						int gcd = gcd(a, b);
						String key = a / gcd + "#" + b / gcd;
						map.put(key, map.getOrDefault(key, 0) + 1);
						max = Math.max(max, map.get(key));
					}
				}
				res = Math.max(res, max + dup + 1);
			}
			return res;
		}

		private int gcd(int a, int b) {
			while (b != 0) {
				int tmp = a % b;
				a = b;
				b = tmp;
			}
			return a;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}