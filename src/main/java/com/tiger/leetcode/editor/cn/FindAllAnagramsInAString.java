//438.找到字符串中所有字母异位词
//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表

package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        solution.findAnagrams("baa","aa");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();

            if (s.length() < p.length() || p.length() < 1) return res;


            int[] slide = new int[26];
            int[] target = new int[26];
            for (Character c : p.toCharArray()) {
                target[c - 'a'] += 1;
            }

            int l = 0, r = -1;//slide window
            while (r + 1 < s.length()) {
                slide[s.charAt(++r) - 'a'] += 1;
                if (r - l + 1 > p.length()) {
                    slide[s.charAt(l++) - 'a'] -= 1;
                }
                if (r - l + 1 == p.length() && equals(slide, target)) {
                    res.add(l);
                }
            }
            return res;
        }

        private boolean equals(int[] slide, int[] target) {
            for (int i = 0; i < 26; i++) {
                if (slide[i] != target[i]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}