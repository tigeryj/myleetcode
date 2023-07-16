package com.tiger.acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 思路：
 * https://www.acwing.com/solution/content/40978/
 */

public class 表达式计算 {

    static Stack<Character> opSt = new Stack<>();
    static Stack<Integer> dgSt = new Stack<>();
    static Map<Character, Integer> map = new HashMap(){{
        put('+', 1);
        put('-', 1);
        put('*', 2);
        put('/', 2);
    }};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            int caculate = caculate(str);
            System.out.println(caculate);
        }
    }
    // 10+2*(1+3*4)+3*4*(1+2*3)
    public static int caculate(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                int x = 0, j = i;
                for (; j < chars.length && Character.isDigit(chars[j]); j++) {
                    x = x * 10 + chars[j] - '0';
                }
                dgSt.push(x);
                i = j - 1;
            } else if (c == '(') {
                opSt.add(c);
            } else if (c == ')') {
                while (opSt.peek() != '(') eval();
                opSt.pop();
            } else {
                while (!opSt.isEmpty() && opSt.peek() != '(' && map.get(opSt.peek()) >= map.get(c)) {
                    eval();
                }
                opSt.push(c);
            }
        }
        while (!opSt.isEmpty()) {
            eval();
        }
        return dgSt.peek();
    }

    private static void eval() {
        int num2 = dgSt.pop();
        int num1 = dgSt.pop();
        char op = opSt.pop();
        int res;
        if (op == '+') {
            res = num1 + num2;
        } else if (op == '-')  {
            res = num1 - num2;
        } else if (op == '*') {
            res = num1 * num2;
        } else {
            res = num1 / num2;
        }
        dgSt.push(res);
    }
}
