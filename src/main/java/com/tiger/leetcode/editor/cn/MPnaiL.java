// [剑指 Offer II 014] 字符串中的变位词
//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// 
//
// 
// 注意：本题与主站 567 题相同： https://leetcode-cn.com/problems/permutation-in-string/ 
//
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 85 👎 0


package com.tiger.leetcode.editor.cn;

public class MPnaiL {
    public static void main(String[] args) {
        Solution solution = new MPnaiL().new Solution();
        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() > s2.length())
                return false;
            int[] freq = new int[26];
            int counter = 0;
            for (char c : s1.toCharArray()) {
                if (freq[c - 'a']++ == 0) {
                    counter++;
                }
            }
            char[] s2Array = s2.toCharArray();
            for (int i = 0, j = 0; i < s2Array.length; i++) {

                // i位置
                if (--freq[s2Array[i] - 'a'] == 0) {
                    counter--;
                }

                if (i >= s1.length()) {
                    if (freq[s2Array[j++] - 'a']++ == 0) {
                        counter++;
                    }
                }

                if (counter == 0) return true;
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
