//150.逆波兰表达式求值
//根据逆波兰表示法，求表达式的值。 
//
// 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。 
//
// 说明： 
//
// 
// 整数除法只保留整数部分。 
// 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。 
// 
//
// 示例 1： 
//
// 输入: ["2", "1", "+", "3", "*"]
//输出: 9
//解释: ((2 + 1) * 3) = 9
// 
//
// 示例 2： 
//
// 输入: ["4", "13", "5", "/", "+"]
//输出: 6
//解释: (4 + (13 / 5)) = 6
// 
//
// 示例 3： 
//
// 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
//输出: 22
//解释: 
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22 
// Related Topics 栈

package com.tiger.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {
	public static void main(String[] args) {
		Solution solution = new EvaluateReversePolishNotation().new Solution();
		int i = solution.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
		System.out.println(i);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int evalRPN(String[] tokens) {
			Set<String> set = new HashSet<>();
			set.add("+");
			set.add("-");
			set.add("*");
			set.add("/");
			Stack<String> st = new Stack<>();
			for (String token : tokens) {
				if (!set.contains(token)) {
					st.add(token);
				} else {
					String num2 = st.pop();
					String num1 = st.pop();
					int res = calculate(Integer.parseInt(num1), Integer.parseInt(num2), token);
					st.add(String.valueOf(res));
				}
			}
			return Integer.parseInt(st.pop());
		}

		private int calculate(int a, int b, String operator) {
			switch (operator) {
				case "+":
					return a + b;
				case "-":
					return a - b;
				case "*":
					return a * b;
				case "/":
					return a / b;
				default:
					throw new IllegalArgumentException("Illegal operator");
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}