// [剑指 Offer II 015] 字符串中的所有变位词
//给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 变位词 指字母相同，但排列不同的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
// 
//
// 示例 2： 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的变位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的变位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的变位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 438 题相同： https://leetcode-cn.com/problems/find-all-anagrams-in-a-
//string/ 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 48 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class VabMRr {
    public static void main(String[] args) {
        Solution solution = new VabMRr().new Solution();
        System.out.println(solution.findAnagrams("abab", "ab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        public List<Integer> findAnagrams(String s, String p) {
            if (s == null || p == null || s.length() < p.length()) return new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            char[] c1 = s.toCharArray();
            char[] c2 = p.toCharArray();
            int count = 0;
            for (char c : c2) {
                if (freq1[c - 'a']++ == 0) {
                    count++;
                }
            }
            for (int i = 0, j = 0; i < c1.length; i++) {
                if (++freq2[c1[i] - 'a'] == freq1[c1[i] - 'a']) {
                    count--;
                }
                if (i >= c2.length) {
                    if (freq2[c1[j] - 'a']-- == freq1[c1[j] - 'a']) {
                        count++;
                    }
                    j++;
                }
                if (count == 0) {
                    res.add(j);
                }
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
