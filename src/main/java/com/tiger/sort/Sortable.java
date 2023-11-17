package com.tiger.sort;

/**
 * @auther Jack
 * @date 2020/2/18 22:11
 */

public interface Sortable<T extends Comparable> extends LessAble, SwapAble {
    void sort(T[] arr);
}
