package com.tiger.sort;

import java.util.Arrays;

/**
 * @auther Jack
 * @date 2020/2/25 21:47
 */

public class Merge<T extends Comparable<T>> implements Sortable<T> {

    private T[] aux;

    @Override
    public void sort(T[] arr) {

        aux = (T[]) new Comparable[arr.length];

        mergeBU(arr);

    }

    public void sort(T[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;

        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private void merge(T[] arr, int l, int mid, int r) {

        if (l == r) {
            return;
        }

        for (int i = l; i <= r; i++) {
            aux[i] = arr[i];
        }

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {

            if (i > mid) {
                arr[k] = aux[j++];
            } else if (j > r) {
                arr[k] = aux[i++];
            } else if (less(aux[j], aux[k])) {
                arr[k] = aux[j++];
            } else {
                arr[k] = aux[i++];
            }
        }
    }

    private void mergeBU(T[] arr) {

        int n = arr.length;

        for (int sz = 1; sz < n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                //arr[i,i+sz-1],arr[i+sz,i+sz+sz-1]
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }
        }
    }

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{4, 3, 2, 1, 5};

        new Merge<Integer>().sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
