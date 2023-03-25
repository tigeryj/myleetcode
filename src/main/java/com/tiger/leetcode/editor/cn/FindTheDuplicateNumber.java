// [287] 寻找重复数
//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。 
//
// 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。 
//
// 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,4,2,2]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,3,4,2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次 
// 
//
// 
//
// 进阶： 
//
// 
// 如何证明 nums 中至少存在一个重复的数字? 
// 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？ 
// 
//
// Related Topics 位运算 数组 双指针 二分查找 👍 2092 👎 0


package com.tiger.leetcode.editor.cn;

import com.tiger.utils.Pair;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        Solution solution = new FindTheDuplicateNumber().new Solution();
        int[] arr = new int[]{1, 1};
        System.out.println(solution.findDuplicate(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 如果我们把索引[0,n]每一个数字当成一个节点，nums[i]代表 i指向nums[i]，
         * 因为nums[i]肯定有一个重复的，意味着有两个指针指向它，所以这个链表必定存在环，问题转化为求环入口的问题
         * @param nums
         * @return
         */
        public int findDuplicate(int[] nums) {
            if (nums == null || nums.length == 0) return -1;
            int fast = 0, slow = 0;
            while (true) {
                fast = nums[nums[fast]];
                slow = nums[slow];
                if (fast == slow) {
                    slow = 0;
                    while (slow != fast) {
                        slow = nums[slow];
                        fast = nums[fast];
                    }
                    break;
                }
            }
            return slow;
        }
    }

    /**
     * 把nums[i]放到正确的位置上，最后nums[0]的位置上就是重复的元素.
     * 但这个方法改变了数组元素的位置，不符合题意
     */
    class SolutionV1 {
        public int findDuplicate(int[] nums) {
            if (nums == null || nums.length < 2) return -1;
            while (nums[0] != nums[nums[0]]) {
                swap(nums, 0, nums[0]);
            }
            return nums[0];
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
