//17:电话号码的字母组合
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
// 示例:
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// 说明:
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
// Related Topics 字符串 回溯算法

package com.tiger.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        List<String> list = solution.letterCombinations("23");
        System.out.println(list.toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<String> res = new ArrayList<>();
        private String[] phone = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        public List<String> letterCombinations(String digits) {
            if (digits ==  null || digits.isEmpty()) return res;
            combine(digits, 0, new StringBuilder());
            return res;
        }

        private void combine(String digits, int i, StringBuilder path) {
            if (i >= digits.length()) {
                res.add(path.toString());
                return;
            }
            String letters = phone[digits.charAt(i) - '0'];
            for (char c : letters.toCharArray()) {
                path.append(c);
                combine(digits, i + 1, path);
                path.deleteCharAt(path.length() - 1);
            }
        }

    }

    //leetcode submit region end(Prohibit modification and deletion)


    class SolutionV1 {

        Map<Character, String> phone = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };

        List<String> result = new ArrayList<>();

        public List<String> letterCombinations(String digits) {

            if (digits == null || digits.isEmpty()) {
                return result;
            }
            backTrack(digits, "");

            return result;
        }

        public void backTrack(String digits, String combinedLetter) {

            if (digits.isEmpty()) {
                result.add(combinedLetter);
                return;
            }

            String letters = phone.get(digits.charAt(0));
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                backTrack(digits.substring(1), combinedLetter + letter);
            }
        }
    }

}