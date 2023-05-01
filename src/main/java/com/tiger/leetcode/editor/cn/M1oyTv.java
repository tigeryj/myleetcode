// [剑指 Offer II 017] 含有所有字符的最短字符串
//给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。 
//
// 如果 s 中存在多个符合条件的子字符串，返回任意一个。 
//
// 
//
// 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC" 
//解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C' 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3： 
//
// 
//输入：s = "a", t = "aa"
//输出：""
//解释：t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//
// 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ 
//
// 
//
// 
// 注意：本题与主站 76 题相似（本题答案不唯一）：https://leetcode-cn.com/problems/minimum-window-
//substring/ 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 86 👎 0


package com.tiger.leetcode.editor.cn;

public class M1oyTv {
    public static void main(String[] args) {
        Solution solution = new M1oyTv().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 核心思路：窗口[j,i]满足包含t的所有字符，i向右滑动时，找到最大的j，继续满足条件
     */

    class Solution {
        public String minWindow(String s, String t) {
            if (s == null || t == null || s.length() < t.length()) return "";
            int[] freq = new int[128];
            int cnt = 0, minLen = Integer.MAX_VALUE;
            String res = "";
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();
            for (char c : tChars) {
                if (freq[c]++ == 0) {
                    cnt++;
                }
            }

            for (int i = 0, j = 0; i < sChars.length; i++) {
                if (--freq[sChars[i]] == 0) {
                    cnt--;
                }
                while (cnt == 0 && freq[sChars[j]] + 1 <= 0) {
                    freq[sChars[j]]++;
                    j++;
                }
                if (cnt == 0 && i - j + 1 < minLen) {
                    res = s.substring(j, i + 1);
                    minLen = res.length();
                }
            }
            return res;

        }
    }
    class SolutionV1 {
        public String minWindow(String s, String t) {
            if (s == null || t == null || s.length() < t.length()) return "";
            int[] freq = new int[128];
            int cnt = 0, minLen = Integer.MAX_VALUE;
            String res = "";
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();

            // 扫面t中字符，计算出每个字符出现的次数，以及不同字符的个数cnt
            for (char c : tChars) {
                if (freq[c]++ == 0) {
                    cnt++;
                }
            }

            // 维护窗口[j,i]，目的就是消灭掉cnt，且窗口最小
            for (int i = 0, j = 0; i < sChars.length; i++) {
                // sChars[i]变成0，则此时窗口已完全包含该字符，可以将cnt-1
                if (--freq[sChars[i]] == 0) {
                    cnt--;
                }
                // 窗口已经完全包含所有字符，且指针j向右移动后，还能继续满足条件
                while (cnt == 0 && freq[sChars[j]] + 1 <= 0) {
                    freq[sChars[j]]++;
                    j++;
                }
                // 看下当前的窗口是不是比之前的要小
                if (cnt == 0 && i - j + 1 < minLen) {
                    res = s.substring(j, i + 1);
                    minLen = res.length();
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
