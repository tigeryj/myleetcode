//202.快乐数
//编写一个算法来判断一个数是不是“快乐数”。 
//
// 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
//如果可以变为 1，那么这个数就是快乐数。 
//
// 示例: 
//
// 输入: 19
//输出: true
//解释: 
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
// Related Topics 哈希表 数学

package com.tiger.leetcode.editor.cn;

public class HappyNumber {
    public static void main(String[] args) {
        Solution solution = new HappyNumber().new Solution();
        System.out.println(solution.isHappy(19));
        System.out.println(solution.isHappy(20));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isHappy(int n) {
            if (n < 1) return false;
            int slow = n, fast = getNext(getNext(n));
            while (slow != fast) {
                slow = getNext(slow);
                fast = getNext(getNext(fast));
            }
            return slow == 1;
        }

        private int getNext(int n) {
            int sum = 0;
            while (n != 0) {
                int last = n % 10;
                sum += last * last;
                n = n / 10;
            }
            return sum;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private int squareSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }

}