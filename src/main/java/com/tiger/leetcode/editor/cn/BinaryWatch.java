//401:二进制手表
//二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。 
//
// 每个 LED 代表一个 0 或 1，最低位在右侧。 
//
// 
//
// 例如，上面的二进制手表读取 “3:25”。 
//
// 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。 
//
// 案例: 
//
// 
//输入: n = 1
//返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "
//0:32"] 
//
// 
//
// 注意事项: 
//
// 
// 输出的顺序没有要求。 
// 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。 
// 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。 
// 
// Related Topics 位运算 回溯算法

package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public static void main(String[] args) {
        Solution solution = new BinaryWatch().new Solution();
        List<String> list = solution.readBinaryWatch(2);
        System.out.println(list);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> readBinaryWatch2(int num) {
            List<String> time = new ArrayList<>();
            for (int h = 0; h < 12; h++) {
                for (int m = 0; m < 60; m++) {
                    if (bitCount(h << 6 | m) == num) {
                        time.add(String.format("%d:%02d", h, m));
                    }
                }
            }
            return time;
        }

        private int bitCount(int num) {
            int count = 0;
            while (num != 0) {
                num &= (num - 1);
                ++count;
            }
            return count;
        }

        public List<String> readBinaryWatch(int num) {
            List<String> time = new ArrayList<>();
            if (num > 8) {
                return time;
            }

            int[] hUnit = {8, 4, 2, 1};
            int[] mUnit = {32, 16, 8, 4, 2, 1};

            for (int i = 0; i <= Math.min(num, 3); i++) {

                if (num - i > 5) continue;

                List<Integer> hours = new ArrayList<>();
                List<Integer> mins = new ArrayList<>();

                backTrace(hours, hUnit, 0, 0, i);
                backTrace(mins, mUnit, 0, 0, num - i);

                for (int h : hours) {
                    if (h > 11) continue;
                    for (int m : mins) {
                        time.add(String.format("%d:%02d", h, m));
                    }
                }
            }
            return time;
        }

        private void backTrace(List<Integer> res, int[] unit, int count, int start, int n) {
            if (count > 59) {
                return;
            }
            if (n == 0) {
                res.add(count);
                return;
            }

            for (int i = start; i < unit.length; i++) {
                backTrace(res, unit, count + unit[i], i + 1, n - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}