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

        int N = 10;
        Random random = new Random(System.currentTimeMillis());

        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = random.nextInt(100);
        }


        MaxHeap<Integer> integerMaxHeap = new MaxHeap<Integer>(Integer.class,arr);

        System.out.println(Arrays.toString(integerMaxHeap.getArr()));

        for (int i = 0; i < N; i++) {
            System.out.print(integerMaxHeap.popMax() + " ");
        }
    }
}
