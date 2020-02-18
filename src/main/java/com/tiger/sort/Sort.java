package com.tiger.sort;

/**
 * @auther Jack
 * @date 2020/2/18 22:11
 */

public abstract class Sort<T extends Comparable<T>>
{
    public abstract void sort(T[] arr);

    protected boolean less(T t, T w)
    {
        return t.compareTo(w) < 0;
    }

    protected void swap(T[] arr, int i, int j)
    {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
