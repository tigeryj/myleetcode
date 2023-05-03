// [105] 从前序与中序遍历序列构造二叉树
//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1951 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        private Map<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode build(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
            if (l1 > r1) return null;
            // 当前节点中序遍历的索引
            int inorderNodeIdx = map.get(preorder[l1]);
            // 左子数的个数
            int leftCount = inorderNodeIdx - l2;

            TreeNode node = new TreeNode(preorder[l1]);

            node.left = build(preorder, l1 + 1, l1 + leftCount, inorder, l2, inorderNodeIdx - 1);

            node.right = build(preorder, l1 + leftCount + 1, r1, inorder, inorderNodeIdx + 1, r2);

            return node;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
