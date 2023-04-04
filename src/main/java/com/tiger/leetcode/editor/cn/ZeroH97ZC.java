// [剑指 Offer II 075] 数组相对排序
//给定两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
//
// 
//
// 
// 注意：本题与主站 1122 题相同：https://leetcode-cn.com/problems/relative-sort-array/ 
//
// Related Topics 数组 哈希表 计数排序 排序 👍 51 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ZeroH97ZC {
    public static void main(String[] args) {
        Solution solution = new ZeroH97ZC().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 计数排序
         */
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int[] freq = new int[1001];
            for (int a : arr1) {
                freq[a]++;
            }
            int[] res = new int[arr1.length];
            int j = 0;
            for (int i = 0; i < arr2.length; i++) {
                while (freq[arr2[i]] != 0) {
                    res[j++] = arr2[i];
                    freq[arr2[i]]--;
                }
            }

            for (int i = 0; i < freq.length; i++) {
                while (freq[i] != 0) {
                    res[j++] = i;
                    freq[i]--;
                }
            }
            return res;
        }
    }

    class SolutionV1 {
        /**
         * 主要思想就是设计一个自己的comparator
         */
        int[] comparator = new int[1001];

        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < arr2.length; i++) {
                comparator[arr2[i]] = i;
                set.add(arr2[i]);
            }
            for (int a : arr1) {
                if (!set.contains(a)) {
                    comparator[a] = a + arr2.length;
                }
            }

            return Arrays.stream(arr1).boxed().sorted((n1, n2) -> comparator[n1] - comparator[n2]).mapToInt(Integer::intValue).toArray();
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}
