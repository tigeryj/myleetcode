// [剑指 Offer II 016] 不含重复字符的最长子字符串
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子字符串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// 
//
// 
// 注意：本题与主站 3 题相同： https://leetcode-cn.com/problems/longest-substring-without-
//repeating-characters/ 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 70 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class WtcaE1 {
    public static void main(String[] args) {
        Solution solution = new WtcaE1().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 枚举每以i为结尾的字串，找到符合条件离它最远的j
         * 当i向后移动时，j只能向右移动，符合单调性
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) return 0;
            int res = 0;
            int[] freq = new int[256];
            for (int i = 0, j = 0; i < s.length(); i++) {
                freq[s.charAt(i)]++;
                while (freq[s.charAt(i)] > 1) {
                    freq[s.charAt(j++)]--;
                }
                res = Math.max(res, i - j + 1);
            }
            return res;
        }
    }

    class SolutionV1 {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) return 0;
            // 记录最后一次出现的字符和对应的索引
            Map<Character, Integer> map = new HashMap<>();
            char[] chars = s.toCharArray();
            int res = 0;
            for (int i = 0, j = 0; i < chars.length; i++) {
                Integer exist = map.get(chars[i]);
                if (exist != null && exist >= j) {
                    j = exist + 1;
                }
                map.put(chars[i], i);
                res = Math.max(res, i - j + 1);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
