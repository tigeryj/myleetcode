package com.tiger.test;

import com.tiger.structure.MaxHeap;

import java.util.Arrays;
import java.util.Random;

/**
 * @auther Jack
 * @date 2020/2/27 22:12
 */

public class Test {
    public static void main(String[] args) {


    }

    public String generateTheString(int n) {
        if (n <= 0) return "";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n - 1; i++) {
            sb.append("a");
        }

        if (n % 2 == 0) {
            sb.append("b");
        } else {
            sb.append("a");
        }
        return sb.toString();
    }
}
