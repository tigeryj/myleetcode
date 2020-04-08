// 349.两个数组的交集
// 给定两个数组，编写一个函数来计算它们的交集。
//
// 示例 1:
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
// 输出: [2]
//
//
// 示例 2:
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// 输出: [9,4]
//
// 说明:
//
//
// 输出结果中的每个元素一定是唯一的。
// 我们可以不考虑输出结果的顺序。
//
// Related Topics 排序 哈希表 双指针 二分查找

package com.tiger.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
  public static void main(String[] args) {
    Solution solution = new IntersectionOfTwoArrays().new Solution();
    solution.intersection(new int[] {1, 2}, new int[] {});
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
      Set<Integer> set = new HashSet<>();
      for (int i : nums1) {
        set.add(i);
      }
      Set<Integer> resSet = new HashSet<>();

      for (int i : nums2) {
        if (set.contains(i)) resSet.add(i);
      }

      int[] res = new int[resSet.size()];

      int i = 0;
      for (int s : resSet) {
        res[i++] = s;
      }
      return res;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
