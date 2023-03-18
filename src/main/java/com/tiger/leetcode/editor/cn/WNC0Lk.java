// [剑指 Offer II 046] 二叉树的右侧视图
//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 
// 注意：本题与主站 199 题相同：https://leetcode-cn.com/problems/binary-tree-right-side-
//view/ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 42 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class WNC0Lk {
    public static void main(String[] args) {
        Solution solution = new WNC0Lk().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            Deque<TreeNode> deque = new LinkedList<>();
            deque.offer(root);
            while (!deque.isEmpty()) {
                res.add(deque.peek().val);
                int size = deque.size();
                while (size-- > 0) {
                    TreeNode pNode = deque.poll();
                    if (pNode.right != null) {
                        deque.offer(pNode.right);
                    }
                    if (pNode.left != null) {
                        deque.offer(pNode.left);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
