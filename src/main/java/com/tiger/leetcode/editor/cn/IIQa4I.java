// [剑指 Offer II 038] 每日温度
//请根据每日 气温 列表 temperatures ，重新生成一个列表，要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不
//会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// 
//
// 
// 注意：本题与主站 739 题相同： https://leetcode-cn.com/problems/daily-temperatures/ 
//
// Related Topics 栈 数组 单调栈 👍 83 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.Stack;

public class IIQa4I {
    public static void main(String[] args) {
        Solution solution = new IIQa4I().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // [8 6 5 1 2 3] ====> [0 0 0 1 1 0]
        public int[] dailyTemperatures(int[] temperatures) {
            if (temperatures == null || temperatures.length == 0) return new int[0];
            int[] res = new int[temperatures.length];
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < temperatures.length; i++) {
                while (!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                    Integer popIdx = st.pop();
                    res[popIdx] = i - popIdx;
                }
                st.push(i);
            }
            return res;
        }
    }

    /**
     * 朴素法
     */
    class SolutionV1 {
        // [8 6 5 1 2 3] ====> [0 0 0 1 1 0]
        public int[] dailyTemperatures(int[] temperatures) {
            if (temperatures == null || temperatures.length == 0) return new int[0];
            int[] res = new int[temperatures.length];
            Stack<Pair> st = new Stack<>();
            for (int i = 0; i < temperatures.length; i++) {
                while (!st.isEmpty() && st.peek().value < temperatures[i]) {
                    Integer popIdx = st.pop().index;
                    res[popIdx] = i - popIdx;
                }
                st.push(new Pair(i, temperatures[i]));
            }
            while (!st.isEmpty()) {
                res[st.pop().index] = 0;
            }
            return res;
        }

        class Pair {
            Integer index;
            Integer value;

            public Pair(Integer index, Integer value) {
                this.index = index;
                this.value = value;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
