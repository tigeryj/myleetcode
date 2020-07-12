//剑指 Offer 37.序列化二叉树
//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]"
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/ 
// Related Topics 树 设计

package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class XuLieHuaErChaShuLcof {
	public static void main(String[] args) {
		XuLieHuaErChaShuLcof xuLieHuaErChaShuLcof = new XuLieHuaErChaShuLcof();
		Codec codec = xuLieHuaErChaShuLcof.new Codec();

//		String s2 = codec.serialize(Utils.createTree(new Integer[]{5, 2, 3, null, null, 2, 4, 3, 1}));

//		System.out.println(s2);

		TreeNode deserialize = codec.deserialize("[5,2,3,null,null,2,4,3,1]");

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
	//Date:2020-07-12 17:23:49
	//解答成功: 执行耗时:39 ms,击败了15.20% 的Java用户
	public class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			if (root == null) return "[]";
			LinkedList<TreeNode> list = new LinkedList<>();
			list.add(root);
			List<String> nodes = new ArrayList();
			while (!list.isEmpty()) {
				TreeNode poll = list.poll();
				if (poll != null) {
					nodes.add(String.valueOf(poll.val));
					list.add(poll.left);
					list.add(poll.right);
				} else {
					nodes.add(null);
				}
			}
			int end = nodes.size() - 1;
			while (nodes.get(end) == null) {
				end--;
			}

			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for (int i = 0; i <= end; i++) {
				if (!sb.toString().equals("[")) {
					sb.append(",");
				}
				sb.append(nodes.get(i));
			}
			sb.append("]");
			return sb.toString();
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data == null || data.equals("[]")) return null;
			data = data.substring(1, data.length() - 1);
			String[] values = data.split(",");
			List<TreeNode> list = new LinkedList<>();
			int i = 1;
			TreeNode head = new TreeNode(Integer.parseInt(values[i]));
			list.add(head);
			while (!list.isEmpty()) {
				TreeNode remove = list.remove(0);
				if (i < values.length && !values[i].equals("null")) {
					TreeNode left = new TreeNode(Integer.parseInt(values[i + 1]));
					remove.left = left;
					list.add(left);
				}
				i++;
				if (i < values.length && !values[i].equals("null")) {
					TreeNode right = new TreeNode(Integer.parseInt(values[i + 2]));
					remove.right = right;
					list.add(right);
				}
				i++;
			}
			return head;
		}

	}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

	//Date:2020-07-12 17:23:49
	//解答成功: 执行耗时:39 ms,击败了15.20% 的Java用户
	public class CodecV1 {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			if (root == null) return "[]";
			LinkedList<TreeNode> list = new LinkedList<>();
			list.add(root);
			List<String> nodes = new ArrayList();
			while (!list.isEmpty()) {
				TreeNode poll = list.poll();
				if (poll != null) {
					nodes.add(String.valueOf(poll.val));
					list.add(poll.left);
					list.add(poll.right);
				} else {
					nodes.add(null);
				}
			}
			int end = nodes.size() - 1;
			while (nodes.get(end) == null) {
				end--;
			}

			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for (int i = 0; i <= end; i++) {
				if (!sb.toString().equals("[")) {
					sb.append(",");
				}
				sb.append(nodes.get(i));
			}
			sb.append("]");
			return sb.toString();
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data == null || data.equals("[]")) return null;
			data = data.substring(1, data.length() - 1);
			String[] values = data.split(",");
			List<TreeNode> list = new LinkedList<>();
			int i = 0;
			TreeNode head = new TreeNode(Integer.parseInt(values[i]));
			list.add(head);
			while (!list.isEmpty()) {
				TreeNode remove = list.remove(0);
				if (i + 1 < values.length && !values[i + 1].equals("null")) {
					TreeNode left = new TreeNode(Integer.parseInt(values[i + 1]));
					remove.left = left;
					list.add(left);
				}

				if (i + 2 < values.length && !values[i + 2].equals("null")) {
					TreeNode right = new TreeNode(Integer.parseInt(values[i + 2]));
					remove.right = right;
					list.add(right);
				}

				i = i + 2;
			}
			return head;
		}

	}

}