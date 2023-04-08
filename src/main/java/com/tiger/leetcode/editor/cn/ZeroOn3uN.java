// [剑指 Offer II 087] 复原 IP 
//给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。 
//
// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "10203040"
//输出：["10.20.30.40","102.0.30.40","10.203.0.40"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
//
// 
//
// 
// 注意：本题与主站 93 题相同：https://leetcode-cn.com/problems/restore-ip-addresses/ 
//
// Related Topics 字符串 回溯 👍 52 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ZeroOn3uN {
    public static void main(String[] args) {
        Solution solution = new ZeroOn3uN().new Solution();
        System.out.println(solution.restoreIpAddresses("25525511135"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            if (s == null || s.length() == 0) return res;
            backTracking(s, 0, new ArrayList<>());
            return res;
        }

        private void backTracking(String s, int start, List<String> path) {
            if (start == s.length() && path.size() == 4) {
                res.add(String.join(".", path));
                return;
            }
            if (start == s.length() || path.size() == 4) return;

            for (int i = start, num = 0; i < s.length(); i++) {
                if (i > start && s.charAt(start) == '0') break;
                num = num * 10 + s.charAt(i) - '0';
                if (num > 255) break;
                path.add(s.substring(start, i + 1));
                backTracking(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
