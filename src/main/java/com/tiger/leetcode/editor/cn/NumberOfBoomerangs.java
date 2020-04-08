//447.回旋镖的数量
//给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺
//序）。 
//
// 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。 
//
// 示例: 
//
// 
//输入:
//[[0,0],[1,0],[2,0]]
//
//输出:
//2
//
//解释:
//两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
// 
// Related Topics 哈希表

package com.tiger.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {
	public static void main(String[] args) {
		Solution solution = new NumberOfBoomerangs().new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int numberOfBoomerangs(int[][] points) {
			int num = 0;
			for (int i = 0; i < points.length; i++) {
				Map<Integer, Integer> distanceFreq = new HashMap<>();
				for (int j = 0; j < points.length; j++) {
					if (i != j) {
						int distance = getDistance(points, i, j);
						num += 2 * distanceFreq.getOrDefault(distance, 0);
						distanceFreq.put(distance, distanceFreq.getOrDefault(distance, 0) + 1);
					}
				}
			}
			return num;
		}

		private int getDistance(int[][] points, int i, int j) {
			return (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}