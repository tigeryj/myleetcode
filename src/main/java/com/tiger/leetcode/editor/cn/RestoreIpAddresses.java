//93:复原IP地址
//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 
//
// 示例: 
//
// 输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"] 
// Related Topics 字符串 回溯算法

package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RestoreIpAddresses {
	public static void main(String[] args) {
		Solution solution = new RestoreIpAddresses().new Solution();
//		List<String> list = solution.restoreIpAddresses("010010");
		List<String> list = solution.restoreIpAddresses("25525511135");
		System.out.println(list.toString());
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	//执行耗时:3 ms,击败了85.71% 的Java用户
	//Date:2020-05-17 10:04:52
	class Solution {
		public List<String> restoreIpAddresses(String s) {
			List<String> res = new ArrayList<>();
			if (s == null || s.isEmpty()) return res;
			Deque<String> deque = new LinkedList<>();

			restoreIpAddresses(s, res, 0, deque);

			return res;
		}

		private void restoreIpAddresses(String s, List<String> res, int begin, Deque<String> deque) {
			if (begin == s.length() && deque.size() == 4) {
				res.add(String.join(".", deque));
				return;
			}

//			if (begin == s.length() || deque.size() == 4) return;
			int residual = s.length() - begin;
			if (residual < 4 - deque.size() || residual > 3 * (4 - deque.size())) return;


			for (int i = 1; i < 4; i++) {
				if (begin + i > s.length()) break;
				String ipSeg = s.substring(begin, begin + i);

				if (isValidSeg(ipSeg)) {
					deque.addLast(ipSeg);
					restoreIpAddresses(s, res, begin + i, deque);
					deque.removeLast();
				}
			}
		}

		private boolean isValidSeg(String ip) {
			if (ip.length() > 1 && ip.charAt(0) == '0') return false;
			int ipInt = Integer.parseInt(ip);
			return ipInt > -1 && ipInt < 256;
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