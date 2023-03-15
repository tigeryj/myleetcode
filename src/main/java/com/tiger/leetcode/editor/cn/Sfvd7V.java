// [剑指 Offer II 033] 变位词组
//给定一个字符串数组 strs ，将 变位词 组合在一起。 可以按任意顺序返回结果列表。 
//
// 注意：若两个字符串中每个字符出现的次数都相同，则称它们互为变位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// 
//
// 
// 注意：本题与主站 49 题相同： https://leetcode-cn.com/problems/group-anagrams/ 
//
// Related Topics 数组 哈希表 字符串 排序 👍 50 👎 0


package com.tiger.leetcode.editor.cn;


import sun.security.krb5.internal.crypto.Aes128CtsHmacSha1EType;

import java.util.*;
import java.util.stream.Collectors;

public class Sfvd7V {
    public static void main(String[] args) {
        Solution solution = new Sfvd7V().new Solution();
        List<String> strings = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
//        solution.groupAnagrams(strings.toArray(new String[]{}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * hash
         * @param strs
         * @return
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0) return new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();
            for (String s : strs) {
                int[] freq = new int[26];
                for (char c : s.toCharArray()) {
                    freq[c - 'a']++;
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 26; i++) {
                    sb.append(0 + 'a').append(freq[i]);
                }
                // hash key
                String key = sb.toString();
                List<String> ls = map.getOrDefault(key, new ArrayList<>());
                ls.add(s);
                map.put(key, ls);
            }
            return new ArrayList<>(map.values());
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    class SolutionV1 {
        /**
         * 先排序
         * @param strs
         * @return
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String s : strs) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(s);
                map.put(key, list);
            }
            return map.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
        }
    }


}
