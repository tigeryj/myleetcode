// [剑指 Offer II 067] 最大的异或
//给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：nums = [3,10,5,25,2,8]
//输出：28
//解释：最大运算结果是 5 XOR 25 = 28. 
//
// 示例 2： 
//
// 
//输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
//输出：127
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁵ 
// 0 <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 
// 注意：本题与主站 421 题相同： https://leetcode-cn.com/problems/maximum-xor-of-two-
//numbers-in-an-array/ 
//
// Related Topics 位运算 字典树 数组 哈希表 👍 69 👎 0


package com.tiger.leetcode.editor.cn;

public class Ms70jA {
    public static void main(String[] args) {
        Solution solution = new Ms70jA().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Trie root = new Trie();
        public int findMaximumXOR(int[] nums) {
            for (int num : nums) {
                insert(num);
            }
            int res = 0;
            for (int num : nums) {
                res = Math.max(res, xor(num));
            }
            return res;
        }
        private int xor(int num) {
            int res = 0;
            Trie node = root;
            for (int i = 30; i >= 0 ; i--) {
                int bit = num >> i & 1;
                if (bit == 0 && node.childs[1] != null) {
                    res ^= 1 << i;
                    node = node.childs[1];
                } else if (bit == 1 && node.childs[0] != null) {
                    res ^= 1 << i;
                    node = node.childs[0];
                } else {
                    node = node.childs[bit];
                }
            }
            return res;
        }
        private void insert(int num) {
            Trie node = root;
            for (int i = 30; i >= 0; i--) {
                int bit = num >> i & 1;
                if (node.childs[bit] == null) {
                    node.childs[bit] = new Trie();
                }
                node = node.childs[bit];
            }
            node.isEnd = true;
        }
    }
    class Trie {
        Trie[] childs = new Trie[2];
        boolean isEnd = false;
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
