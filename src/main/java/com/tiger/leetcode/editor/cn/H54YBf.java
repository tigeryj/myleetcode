// [剑指 Offer II 048] 序列化与反序列化二叉树
//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反
//序列化为原始的树结构。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，也可以采用其他的方法解决这
//个问题。 
// 树中结点数在范围 [0, 10⁴] 内 
// -1000 <= Node.val <= 1000 
// 
//
// 
//
// 
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-
//binary-tree/ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 71 👎 0


package com.tiger.leetcode.editor.cn;

public class H54YBf {
    public static void main(String[] args) {
//        Codec codec = new Codec();
//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
//        n1.left = n2;
//        n1.right = n3;
//        String serialize = codec.serialize(n1);
//        System.out.println(codec.deserialize(serialize));
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
    public class Codec {

        private int cur = 0;

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            dfsS(sb, root);
            return sb.toString();
        }

        private void dfsS(StringBuilder sb, TreeNode root) {
            if (root == null) {
                sb.append("#").append(",");
                return;
            } else {
                sb.append(root.val).append(",");
            }
            dfsS(sb, root.left);
            dfsS(sb, root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) return null;
            return dfsD(new StringBuilder(data));
        }

        private TreeNode dfsD(StringBuilder sb) {
            if (cur >= sb.length()) return null;
            int start = cur;
            while (sb.charAt(cur) != ',') {
                cur++;
            }
            String nodeVal = sb.substring(start, cur);
            if (nodeVal.equals("#")) {
                cur++;
                return null;
            }
            TreeNode treeNode = new TreeNode(Integer.valueOf(nodeVal));
            cur++;
            treeNode.left = dfsD(sb);
            treeNode.right = dfsD(sb);
            return treeNode;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}
