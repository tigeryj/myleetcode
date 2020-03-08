/*543:二叉树的直径
给定一棵二叉树，你需算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。

示例 :
给定二叉树
          1
         / \
        2   3
       / \
      4   5


返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。

注意：两结点之间的路径长度是以它们之间边的数目表示。
Related Topics 树

思路：对于每一个结点，经过其的最长路径长度是左孩子节点的深度+右孩子节点的深度
问题就转化为了求这棵树的深度，在递归求深度的时候，顺便求一下路径长度，即可

*/

package com.tiger.leetcode.editor.cn;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        int maxDiameter = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            getDepth(root);
            return maxDiameter;
        }

        public int getDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftDepth = getDepth(root.left);
            int rightDepth = getDepth(root.right);
            maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
            return Math.max(leftDepth, rightDepth) + 1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}