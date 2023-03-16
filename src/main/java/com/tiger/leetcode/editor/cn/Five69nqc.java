// [剑指 Offer II 035] 最小时间差
//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints <= 2 * 10⁴ 
// timePoints[i] 格式为 "HH:MM" 
// 
//
// 
//
// 
// 注意：本题与主站 539 题相同： https://leetcode-cn.com/problems/minimum-time-difference/ 
//
// Related Topics 数组 数学 字符串 排序 👍 40 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class Five69nqc {
    public static void main(String[] args) {
        Solution solution = new Five69nqc().new Solution();
        System.out.println(solution.findMinDifference(Arrays.asList("00:00", "04:00", "22:00")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            if (timePoints == null || timePoints.isEmpty()) return -1;
            int[] times = new int[timePoints.size()];
            for (int i = 0; i < times.length; i++) {
                String[] hhMM = timePoints.get(i).split(":");
                Integer hh = Integer.valueOf(hhMM[0]);
                Integer mm = Integer.valueOf(hhMM[1]);
                times[i] = hh * 60 + mm;
            }
            int max = 24 * 60;
            int min = max;
            Arrays.sort(times);
            for (int i = 0; i < times.length - 1; i++) {
                min = Math.min(min, times[i + 1] - times[i]);
            }
            min = Math.min(min, max - times[times.length - 1] + times[0]);
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
