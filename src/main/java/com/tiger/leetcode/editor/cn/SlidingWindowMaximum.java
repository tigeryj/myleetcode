// [239] 滑动窗口最大值
//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2225 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 优先队列，比较容易想到，但是时间复杂度是O(nlogn)
         * @param nums
         * @param k
         * @return
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k < 1) return new int[0];
            int[] res = new int[nums.length - k + 1];
            PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n2[1] - n1[1]);
            for (int i = 0; i < nums.length; i++) {
                pq.add(new int[]{i, nums[i]});
                if (i >= k - 1) {
                    while (!pq.isEmpty() && pq.peek()[0] < i - k + 1) {
                        pq.poll();
                    }
                    res[i - k + 1] = pq.peek()[1];
                }
            }
            return res;
        }
    }

    /**
     * 单调队列，时间复杂度是O(n)
     */
    class SolutionV1 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k < 1) return new int[0];
            int[] res = new int[nums.length - k + 1];
            // 维护一个单调递减队列，队头是当前窗口的最大值
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {

                // 队头在窗口外，弹出
                if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                    deque.pollFirst();
                }
                // 保证队列单调递减（因为后面一个元素比前面大，前面的元素永远不可能是答案）
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                if (i >= k - 1) {
                    res[i - k + 1] = nums[deque.peekFirst()];
                }
            }
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
