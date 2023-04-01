// [剑指 Offer II 065] 最短的单词编码
//单词数组 words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足： 
//
// 
// words.length == indices.length 
// 助记字符串 s 以 '#' 字符结尾 
// 对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 
//words[i] 相等 
// 
//
// 给定一个单词数组 words ，返回成功对 words 进行编码的最小助记字符串 s 的长度 。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["time", "me", "bell"]
//输出：10
//解释：一组有效编码为 s = "time#bell#" 和 indices = [0, 2, 5] 。
//words[0] = "time" ，s 开始于 indices[0] = 0 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
//words[1] = "me" ，s 开始于 indices[1] = 2 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
//words[2] = "bell" ，s 开始于 indices[2] = 5 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
// 
//
// 示例 2： 
//
// 
//输入：words = ["t"]
//输出：2
//解释：一组有效编码为 s = "t#" 和 indices = [0] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 2000 
// 1 <= words[i].length <= 7 
// words[i] 仅由小写字母组成 
// 
//
// 
//
// 
// 注意：本题与主站 820 题相同： https://leetcode-cn.com/problems/short-encoding-of-words/ 
//
// Related Topics 字典树 数组 哈希表 字符串 👍 39 👎 0


package com.tiger.leetcode.editor.cn;

public class ISwD2y {
    public static void main(String[] args) {
        Solution solution = new ISwD2y().new Solution();
        int i = solution.minimumLengthEncoding(new String[]{"time", "me", "bell"});
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Trie root = new Trie();
        int res = 0;

        public int minimumLengthEncoding(String[] words) {
            if (words == null || words.length == 0) return 0;
            for (String w : words) {
                insert(w);
            }
            dfs(root, 1);
            return res;

        }

        private void dfs(Trie node, int depth) {
            if (node.childs == null) {
                res += depth;
                return;
            }
            for (int i = 0; i < 26; i++) {
                if (node.childs[i] != null) {
                    dfs(node.childs[i], depth + 1);
                }
            }
        }

        private void insert(String s) {
            Trie node = root;
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                int idx = c - 'a';
                if (node.childs == null) {
                    node.childs = new Trie[26];
                }
                if (node.childs[idx] == null) {
                    node.childs[idx] = new Trie();
                }
                node = node.childs[idx];
            }
            node.isEnd = true;
        }
    }

    class Trie {
        Trie[] childs;
        boolean isEnd = false;
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
