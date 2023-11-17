package com.tiger.sort;

import java.util.Arrays;

/**
 * @auther Jack
 * @date 2020/2/21 21:44
 */

public class Shell<T extends Comparable<T>> implements Sortable<T> {
    @Override
    public void sort(T[] arr) {
        int N = arr.length;
        int gap = 0;
        while (gap < N / 3) {
            gap = 3 * gap + 1;
        }

        while (gap >= 1) {
            for (int i = gap; i < N; i++) {
                for (int j = i; j >= gap && less(arr[j], arr[j - gap]); j -= gap) {
                    swap(arr, j, j - gap);
                }
            }

            gap /= 3;
        }


    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//        Integer[] arr = new Integer[]{1, 2, 4, 3, 5};

        new Shell<Integer>().sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
