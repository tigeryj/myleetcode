// [剑指 Offer II 076] 数组中的第 k 大的数字
//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 
// 注意：本题与主站 215 题相同： https://leetcode-cn.com/problems/kth-largest-element-in-an-
//array/ 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 66 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.Random;

public class Xx4gT2 {
    public static void main(String[] args) {
        Solution solution = new Xx4gT2().new Solution();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class SolutionV1 {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2) -> n2 - n1);
            for (int n : nums) {
                pq.add(n);
            }
            int res = 0;
            while (k-- > 0) {
                res = pq.poll();
            }
            return res;
        }
    }

    class Solution {
        Random random = new Random();
        public int findKthLargest(int[] nums, int k) {
            if (nums == null || nums.length < k) throw new IllegalArgumentException("参数非法");

            return find(nums, 0, nums.length - 1, nums.length - k);
        }

        // v < < > > >
        // [l+1, j] < v
        private int find(int[] nums, int l, int r, int k) {

            int rdIdx = l + random.nextInt(r - l + 1);
            swap(nums, l, rdIdx);

            int v = nums[l];
            int j = l;
            for (int i = l + 1; i <= r; i++) {
                if (nums[i] < v) {
                    swap(nums, ++j, i);
                }
            }
            swap(nums, l, j);
            if (j == k) {
                return nums[k];
            } else if (j < k) {
                return find(nums, j + 1, r, k);
            } else {
                return find(nums, l, j - 1, k);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
