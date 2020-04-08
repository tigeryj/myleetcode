//215.数组中的第K个最大元素
//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法

package com.tiger.leetcode.editor.cn;

import java.util.Random;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return find(nums, 0, nums.length - 1, nums.length - k);
        }

        private int find(int[] nums, int l, int r, int k) {
            int i = partition(nums, l, r);

            if (i == k) {
                return nums[k];
            } else if (i < k) {
                return find(nums, i + 1, r, k);
            } else {
                return find(nums, l, i - 1, k);
            }
        }

        private int partition(int[] nums, int l, int r) {
            Random random = new Random(System.currentTimeMillis());

            int randomIndex = l + random.nextInt(r - l + 1);

            swap(nums, r, randomIndex);

            int v = nums[r];
            int lt = l - 1;//nums[0,lt]<v

            for (int i = l; i < r; i++) {
                if (nums[i] < v) {
                    swap(nums, ++lt, i);
                }
            }
            swap(nums, lt + 1, r);

            return lt + 1;
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}