// [662] 二叉树最大宽度
//给你一棵二叉树的根节点 root ，返回树的 最大宽度 。 
//
// 树的 最大宽度 是所有层中最大的 宽度 。 
//
// 
// 
// 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 
//null 节点，这些 null 节点也计入长度。 
// 
// 
//
// 题目数据保证答案将会在 32 位 带符号整数范围内。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,3,2,5,3,null,9]
//输出：4
//解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,3,2,5,null,null,9,6,null,7]
//输出：7
//解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
// 
//
// 示例 3： 
// 
// 
//输入：root = [1,3,2,5]
//输出：2
//解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [1, 3000] 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 563 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumWidthOfBinaryTree().new Solution();
        TreeNode node = new TreeNode(1);
        TreeNode cur = node;
        for (int i = 0; i < 40; i++) {
            cur.right = new TreeNode(1);
            cur = cur.right;
        }
        int i = solution.widthOfBinaryTree(node);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        private Map<Integer, Integer> map = new HashMap();
        private int res;
        public int widthOfBinaryTree(TreeNode root) {
            dfs(root, 1, 0);
            return res;
        }
        private void dfs(TreeNode node, int index, int level) {
            if (node == null) return;
            if (!map.containsKey(level)) {
                map.put(level, index);
            }
            res = Math.max(res, index - map.get(level) + 1);

            // 避免超过阈值，需要减去一个偏移量
            int cur = index - map.get(level) + 1;
            dfs(node.left, cur << 1, level + 1);
            dfs(node.right, (cur << 1) | 1, level + 1);
        }
    }

    class SolutionV1 {
        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            Deque<Pair<TreeNode, Integer>> queue = new LinkedList();
            queue.add(new Pair(root, 1));
            int res = 1;
            while (!queue.isEmpty()) {
                int sz = queue.size();
                int l = 1, r = 1;
                // 为了避免生成左右孩子的索引时超出阈值，需要减去偏移
                int offset = queue.peekFirst().index - 1;
                for (int i = 0; i < sz; i++) {
                    Pair<TreeNode, Integer> p = queue.pollFirst();
                    int cur = p.index - offset;
                    int leftIdx = cur << 1;
                    int rightIdx = (cur << 1) | 1;
                    if (p.node.left != null) {
                        queue.add(new Pair(p.node.left, leftIdx));
                    }
                    if (p.node.right != null) {
                        queue.add(new Pair(p.node.right, rightIdx));
                    }
                    if (i == 0) {
                        l = p.index;
                    }
                    if (i == sz - 1) {
                        r = p.index;
                    }
                }
                res = Math.max(res, r - l + 1);
            }
            return res;
        }
    }

    class Pair<K, V> {
        K node;
        V index;

        Pair(K node, V index) {
            this.node = node;
            this.index = index;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}
