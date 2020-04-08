//454.四数相加 II
//给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[
//l] = 0。 
//
// 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最
//终结果不会超过 231 - 1 。 
//
// 例如: 
//
// 
//输入:
//A = [ 1, 2]
//B = [-2,-1]
//C = [-1, 2]
//D = [ 0, 2]
//
//输出:
//2
//
//解释:
//两个元组如下:
//1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
//2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
// 
// Related Topics 哈希表 二分查找

package com.tiger.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

public class FourSumIi {
	public static void main(String[] args) {
		Solution solution = new FourSumIi().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
			int count = 0;
			HashMap<Integer, Integer> twoSumFreq = new HashMap<>();
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < B.length; j++) {
					Integer twoSum = A[i] + B[j];
					twoSumFreq.put(twoSum, twoSumFreq.getOrDefault(twoSum, 0) + 1);
				}
			}
			for (int i = 0; i < C.length; i++) {
				for (int j = 0; j < D.length; j++) {
					int target = -(C[i] + D[j]);
					if (twoSumFreq.containsKey(target)) {
						count += twoSumFreq.get(target);
					}
				}
			}
			return count;
		}

		public int fourSumCountV1(int[] A, int[] B, int[] C, int[] D) {

			Arrays.sort(C);
			Arrays.sort(D);
			int N = A.length;
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int k = 0, l = N - 1;
					while (k < N && l >= 0) {
						if (A[i] + B[j] + C[k] + D[l] == 0) {
							int sameK = 1, sameL = 1;
							while (k + 1 < N && C[k + 1] == C[k]) {
								sameK++;
								k++;
							}
							while (l - 1 >= 0 && D[l - 1] == D[l]) {
								sameL++;
								l--;
							}
							count += sameK * sameL;
							k++;
							l--;
						} else if (A[i] + B[j] + C[k] + D[l] < 0) {
							k++;
						} else {
							l--;
						}
					}
				}
			}
			return count;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}