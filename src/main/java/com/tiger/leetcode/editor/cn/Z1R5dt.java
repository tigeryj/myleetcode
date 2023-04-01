// [剑指 Offer II 066] 单词之和
//实现一个 MapSum 类，支持两个方法，insert 和 sum： 
//
// 
// MapSum() 初始化 MapSum 对象 
// void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 
//key 已经存在，那么原来的键值对将被替代成新的键值对。 
// int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//inputs = ["MapSum", "insert", "sum", "insert", "sum"]
//inputs = [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
//输出：
//[null, null, 3, null, 5]
//
//解释：
//MapSum mapSum = new MapSum();
//mapSum.insert("apple", 3);  
//mapSum.sum("ap");           // return 3 (apple = 3)
//mapSum.insert("app", 2);    
//mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= key.length, prefix.length <= 50 
// key 和 prefix 仅由小写英文字母组成 
// 1 <= val <= 1000 
// 最多调用 50 次 insert 和 sum 
// 
//
// 
//
// 
// 注意：本题与主站 677 题相同： https://leetcode-cn.com/problems/map-sum-pairs/ 
//
// Related Topics 设计 字典树 哈希表 字符串 👍 28 👎 0


package com.tiger.leetcode.editor.cn;

public class Z1R5dt {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MapSum {

        /**
         * Initialize your data structure here.
         */
        Trie root;

        public MapSum() {
            root = new Trie();
        }

        public void insert(String key, int val) {
            Trie node = root;
            for (char c : key.toCharArray()) {
                if (node.childs[c - 'a'] == null) {
                    node.childs[c - 'a'] = new Trie();
                }
                node = node.childs[c - 'a'];
            }
            node.isEnd = true;
            node.val = val;
        }

        public int sum(String prefix) {
            Trie node = root;
            for (char c : prefix.toCharArray()) {
                if (node.childs[c - 'a'] == null) return 0;
                node = node.childs[c - 'a'];
            }
            return dfs(node);
        }

        private int dfs(Trie node) {
            int sum = 0;
            if (node.isEnd) {
                sum += node.val;
            }
            for (Trie trie : node.childs) {
                if (trie == null) continue;
                sum += dfs(trie);
            }
            return sum;
        }
    }

    class Trie {
        Trie[] childs = new Trie[26];
        boolean isEnd;
        Integer val;
    }

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
