package com.tiger.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @auther Jack
 * @date 2020/2/27 21:19
 */

public class Heap<T extends Comparable<T>> extends Sort<T> {


    @Override
    public void sort(T[] arr) {

        heapify(arr);

        for (int i = arr.length - 1; i > 0; i--) {

            swap(arr, i, 0);

            shiftDown(arr, 0, i);
        }
    }

    public void heapify(T[] arr) {

        int N = arr.length;

        for (int i = (N - 2) / 2; i >= 0; i--) {
            shiftDown(arr, i, N);
        }
    }

    private void shiftDown(T[] arr, int j, int N) {

        T toShift = arr[j];

        while (2 * j + 1 < N) {

            int largerChildIndex = 2 * j + 1;


            if (largerChildIndex + 1 < N && less(arr[largerChildIndex], arr[largerChildIndex + 1])) {
                largerChildIndex++;
            }

            if (less(arr[largerChildIndex], toShift)) {
                break;
            }

            arr[j] = arr[largerChildIndex];
            j = largerChildIndex;
        }

        arr[j] = toShift;

    }

    public static void main(String[] args) {
        int N = 20;
        Integer[] arr = new Integer[N];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < N; i++) {
            arr[i] = random.nextInt(100);
        }

        System.out.println("排序前");

        System.out.println(Arrays.toString(arr));

        new Heap<Integer>().sort(arr);

        System.out.println("排序后");

        System.out.println(Arrays.toString(arr));

    }
}
