//93.复原IP地址
//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 
//
// 示例: 
//
// 输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"] 
// Related Topics 字符串 回溯算法

package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
//		List<String> list = solution.restoreIpAddresses("010010");
//        List<String> list = solution.restoreIpAddresses("25525511135");
        List<String> list = solution.restoreIpAddresses("1");
        System.out.println(list.toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<String> res = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            dfs(s, 0, 0, new ArrayList<>());
            return res;
        }

        private void dfs(String s, int start, int count, List<String> path) {
            if (start == s.length() && count == 4) {
                String ip = String.join(".", path);
                res.add(ip);
                return;
            }
            if (start == s.length() || count == 4) return;
            for (int i = start, part = 0; i < s.length() && i < start + 3; i++) {
                if (i > start && s.charAt(start) == '0') break;
                part = part * 10 + s.charAt(i) - '0';
                if (part > 255) break;
                path.add(String.valueOf(part));
                dfs(s, i + 1, count + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class SolutionV1 {

        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            if (s == null || s.isEmpty()) return res;
            restoreIpAddresses(res, s, 0, "");
            return res;
        }

        private void restoreIpAddresses(List<String> res, String ips, int partCount, String path) {
            if (ips.isEmpty() && partCount == 4) {
                res.add(path);
                return;
            }
            if (ips.isEmpty() || partCount > 4) return;

            for (int size = 1; size <= 3 && size <= ips.length(); size++) {
                String part = ips.substring(0, size);
                if (!isValidPart(part)) continue;
                restoreIpAddresses(res, ips.substring(size), partCount + 1, path.isEmpty() ? part : path + "." + part);
            }
        }

        private boolean isValidPart(String part) {
            int partInt = Integer.parseInt(part);
            if (partInt > 255) return false;
            if (!String.valueOf(partInt).equals(part)) return false;
            return true;
        }

		/*private int count(int num) {
			if (num == 0) return 1;
			int count = 0;
			while (num != 0) {
				num /= 10;
				count++;
			}
			return count;
		}
		*/
    }

}