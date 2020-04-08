// 76.最小覆盖子串
// 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
//
// 示例：
//
// 输入: S = "ADOBECODEBANC", T = "ABC"
// 输出: "BANC"
//
// 说明：
//
//
// 如果 S 中不存这样的子串，则返回空字符串 ""。
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window

package com.tiger.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
  public static void main(String[] args) {
    Solution solution = new MinimumWindowSubstring().new Solution();
    String s = solution.minWindow("", "");
    System.out.println(s);
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String minWindow(String s, String t) {
      if (s == null || t == null || s == "" || t == "") {
        return "";
      }

      Map<Character, Integer> targetFreq = new HashMap<>();
      Map<Character, Integer> windowFreq = new HashMap<>();
      int match = 0; // match size
      int l = 0, r = -1; // sliding window
      int start = 0, end = s.length() + 1;
      long minLength = Long.MAX_VALUE;

      for (char c : t.toCharArray()) {
        targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
      }

      while (l < s.length()) {

        if (r + 1 < s.length() && match < targetFreq.size()) {
          r++;
          windowFreq.put(s.charAt(r), windowFreq.getOrDefault(s.charAt(r), 0) + 1);
          if (targetFreq.containsKey(s.charAt(r))
              && windowFreq.get(s.charAt(r)).equals(targetFreq.get(s.charAt(r)).intValue())) {
            match++;
          }
        } else {
          if (match == targetFreq.size() && r - l < minLength) {
            start = l;
            end = r;
            minLength = r - l;
          }
          windowFreq.put(s.charAt(l), windowFreq.get(s.charAt(l)) - 1);
          if (targetFreq.containsKey(s.charAt(l))
              && windowFreq.get(s.charAt(l)).intValue() < targetFreq.get(s.charAt(l))) {
            match--;
          }
          l++;
        }
      }
      return minLength == Long.MAX_VALUE ? "" : s.substring(start, end + 1);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

  class Solution2 {
    public String minWindow(String s, String t) {

      if (t == null || t == "" || s == "") return "";

      int[] path = new int[128];
      int[] target = new int[128];
      for (Character c : t.toCharArray()) {
        target[c] += 1;
      }

      int l = 0, r = -1; // sliding window
      String minStr = s + t;

      while (l < s.length()) {

        if (!contains(path, target)) {
          if (r + 1 < s.length()) {
            path[s.charAt(++r)] += 1;
          } else {
            break;
          }
        } else {
          if (r - l + 1 < minStr.length()) {
            minStr = s.substring(l, r + 1);
          }
          path[s.charAt(l++)] -= 1;
        }
      }
      return minStr.length() > s.length() ? "" : minStr;
    }

    private boolean contains(int[] path, int[] target) {
      for (int i = 0; i < target.length; i++) {
        if (path[i] < target[i]) {
          return false;
        }
      }
      return true;
    }
  }
}
