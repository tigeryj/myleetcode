// [剑指 Offer II 036] 后缀表达式
//根据 逆波兰表示法，求该后缀表达式的计算结果。 
//
// 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。 
//
// 
//
// 说明： 
//
// 
// 整数除法只保留整数部分。 
// 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：tokens = ["2","1","+","3","*"]
//输出：9
//解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
// 
//
// 示例 2： 
//
// 
//输入：tokens = ["4","13","5","/","+"]
//输出：6
//解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
// 
//
// 示例 3： 
//
// 
//输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
//输出：22
//解释：
//该算式转化为常见的中缀算术表达式为：
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22 
//
// 
//
// 提示： 
//
// 
// 1 <= tokens.length <= 10⁴ 
// tokens[i] 要么是一个算符（"+"、"-"、"*" 或 "/"），要么是一个在范围 [-200, 200] 内的整数 
// 
//
// 
//
// 逆波兰表达式： 
//
// 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。 
//
// 
// 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。 
// 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。 
// 
//
// 逆波兰表达式主要有以下两个优点： 
//
// 
// 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。 
// 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。 
// 
//
// 
//
// 
// 注意：本题与主站 150 题相同： https://leetcode-cn.com/problems/evaluate-reverse-polish-
//notation/ 
//
// Related Topics 栈 数组 数学 👍 45 👎 0


package com.tiger.leetcode.editor.cn;

import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EightZf90G {
    public static void main(String[] args) {
        Solution solution = new EightZf90G().new Solution();
        System.out.println(solution.evalRPN(new String[]{"2","1","+","3","*"}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int evalRPN(String[] tokens) {
            if (tokens == null || tokens.length == 0) return 0;
            Set<String> set = Stream.of("+", "-", "*", "/").collect(Collectors.toSet());

            Stack<Integer> stack = new Stack<>();
            int res = 0;
            for (String s : tokens) {
                if (set.contains(s)) {
                    int second = stack.pop();
                    int first = stack.pop();
                    int result = caculate(s, first, second);
                    stack.add(result);
                } else {
                    stack.add(Integer.valueOf(s));
                }
            }
            return stack.peek();
        }

        private int caculate(String s, int first, int second) {
            switch (s) {
                case "+":
                    return first + second;
                case "-":
                    return first - second;
                case "*":
                    return first * second;
                case "/":
                    return first / second;
                default:
                    throw new IllegalArgumentException("参数异常");
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
