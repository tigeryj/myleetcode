// [剑指 Offer II 002] 二进制加法
//给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: a = "11", b = "10"
//输出: "101" 
//
// 示例 2: 
//
// 
//输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
//
// 
//
// 
// 注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/ 
//
// Related Topics 位运算 数学 字符串 模拟 👍 58 👎 0


package com.tiger.leetcode.editor.cn;

public class JFETK5 {
    public static void main(String[] args) {
        Solution solution = new JFETK5().new Solution();
        System.out.println(solution.addBinary("0110101", "111"));
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        sb.append(1);
        sb.append(3);
        System.out.println(sb.toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int addition = 0, sum = 0;
            for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
                sum = addition;
                if (i >= 0) {
                    sum += a.charAt(i) - '0';
                }
                if (j >= 0) {
                    sum += b.charAt(j) - '0';
                }
                char c = (char) (sum % 2 + '0');
                sb.append(c);
                addition = sum / 2;
            }
            if (addition > 0) {
                sb.append(addition);
            }
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
