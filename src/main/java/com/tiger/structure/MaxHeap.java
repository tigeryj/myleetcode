package com.tiger.structure;

import java.lang.reflect.Array;

/**
 * @auther Jack
 * @date 2020/2/27 22:07
 */

public class MaxHeap<T extends Comparable<T>> {

    private T[] arr;

    private int count;

    private int capacity = 10;

    public MaxHeap(Class<T> type, int N) {
        arr = (T[]) Array.newInstance(type, N);

        capacity = N;
    }

    public MaxHeap() {
        T[] arr = (T[]) new Object[capacity];
    }

    public MaxHeap(Class<T> type, T[] input) {
        arr = (T[]) Array.newInstance(type, input.length);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = input[i];
        }
        capacity = input.length;
        count=capacity;
        int N = arr.length;

        for (int i = (N - 2) / 2; i >= 0; i--) {
            shiftDown(i, N);
        }
    }

    public void add(T t) {

        assertCapacity();

        arr[count] = t;

        shiftUp(count);

        count++;

    }

    public T popMax() {
        if (count <= 0) {
            throw new RuntimeException("Has no element.");
        }
        T e = arr[0];

        arr[0] = arr[count - 1];

        shiftDown(0, count - 1);

        count--;

        return e;
    }

    private void shiftDown(int j, int N) {
        T toShift = arr[j];

        while (2 * j + 1 < N) {

            int largerChildIndex = 2 * j + 1;


            if (largerChildIndex + 1 < N && arr[largerChildIndex].compareTo(arr[largerChildIndex + 1]) < 0) {
                largerChildIndex++;
            }

            if (arr[largerChildIndex].compareTo(toShift) < 0) {
                break;
            }

            arr[j] = arr[largerChildIndex];
            j = largerChildIndex;
        }

        arr[j] = toShift;
    }

    private void assertCapacity() {
        if (count >= capacity) {
            throw new RuntimeException("OutOfBoundException");
        }
    }

    private void shiftUp(int k) {
        while (k > 0) {
            int parentIndex = (k - 1) >> 1;
            if (arr[parentIndex].compareTo(arr[k]) > 0) {
                break;
            }
            swap(arr, parentIndex, k);
            k = parentIndex;
        }
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public T[] getArr() {
        return arr;
    }

}
