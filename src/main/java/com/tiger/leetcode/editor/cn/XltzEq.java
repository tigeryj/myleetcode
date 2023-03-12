// [剑指 Offer II 018] 有效的回文
//给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 本题中，将空字符串定义为有效的 回文串 。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串 
//
// 示例 2: 
//
// 
//输入: s = "race a car"
//输出: false
//解释："raceacar" 不是回文串 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
//
// 
//
// 
// 注意：本题与主站 125 题相同： https://leetcode-cn.com/problems/valid-palindrome/ 
//
// Related Topics 双指针 字符串 👍 47 👎 0


package com.tiger.leetcode.editor.cn;

public class XltzEq {
    public static void main(String[] args) {
        Solution solution = new XltzEq().new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            if (s == null) return false;
            if (s.isEmpty()) return true;
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    sb.append(c);
                } else if (c >= 'A' && c <= 'Z') {
                    sb.append(Character.toLowerCase(c));
                } else if (c >= '0' && c <= '9') {
                    sb.append(c);
                }
            }
            char[] chars = sb.toString().toCharArray();
            for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
                if (chars[i] != chars[j]) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
