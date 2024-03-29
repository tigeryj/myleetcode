// [剑指 Offer II 073] 狒狒吃香蕉
//狒狒喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。 
//
// 狒狒可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后
//这一小时内不会再吃更多的香蕉，下一个小时才会开始吃另一堆的香蕉。 
//
// 狒狒喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。 
//
// 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：piles = [3,6,7,11], h = 8
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：piles = [30,11,23,4,20], h = 5
//输出：30
// 
//
// 示例 3： 
//
// 
//输入：piles = [30,11,23,4,20], h = 6
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= piles.length <= 10⁴ 
// piles.length <= h <= 10⁹ 
// 1 <= piles[i] <= 10⁹ 
// 
//
// 
//
// 
// 注意：本题与主站 875 题相同： https://leetcode-cn.com/problems/koko-eating-bananas/ 
//
// Related Topics 数组 二分查找 👍 55 👎 0


package com.tiger.leetcode.editor.cn;

public class NZZqjQ {
    public static void main(String[] args) {
        Solution solution = new NZZqjQ().new Solution();
        System.out.println(solution.minEatingSpeed(new int[]{312884470}, 968709470));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            if (piles == null || h < piles.length) throw new IllegalArgumentException("参数非法");
            int l = 1, r = Integer.MAX_VALUE;
            while (l < r) {
                int mid = l + (r - l) / 2;
                int needHours = getHours(piles, mid);
                if (needHours > h) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }

        /**
         * 向上取整的公式
         * (x + k - 1 ) / k
         * @param piles
         * @param speed
         * @return
         */
        private int getHours(int[] piles, int speed) {
            int res = 0;
            for (int p : piles) {
                res += (p + speed - 1) / speed;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
