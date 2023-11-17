package com.tiger.sort;

public interface SwapAble<T> {

    default void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
