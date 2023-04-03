// [剑指 Offer II 074] 合并区间
//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// 
//
// 
// 注意：本题与主站 56 题相同： https://leetcode-cn.com/problems/merge-intervals/ 
//
// Related Topics 数组 排序 👍 51 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SsGoHC {
    public static void main(String[] args) {
        Solution solution = new SsGoHC().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0) return new int[0][0];
            Arrays.sort(intervals, (n1, n2) -> n1[0] - n2[0]);
            List<int[]> res = new ArrayList<>();
            res.add(intervals[0]);
            for (int i = 1; i < intervals.length; i++) {
                int[] last = res.get(res.size() - 1);
                if (last[1] >= intervals[i][0]) {
                    last[1] = Math.max(last[1], intervals[i][1]);
                } else {
                    res.add(intervals[i]);
                }
            }
            return res.toArray(new int[][]{});
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
