package com.tiger.sort;

import java.util.Arrays;

/**
 * @auther Jack
 * @date 2020/2/23 20:29
 */

public class Quick<T extends Comparable<T>> extends Sort<T>
{
    @Override
    public void sort(T[] arr)
    {
        quickSort(arr, 0, arr.length - 1);

    }

    public void quickSort(T[] arr, int l, int r)
    {
        if (l >= r)
        {
            return;
        }

        int partitionIndex = partitionV1(arr, l, r);

        quickSort(arr, l, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, r);
    }


    //单边排序
    public int partitionV1(T[] arr, int l, int r)
    {
        //给0位置上的元素找位置，按道理应该随机选一个的
        T v = arr[l];

        //j是小于v的边界[1,j]上的元素都是小于v的
        int j = l;

        //i遍历指针
        for (int i = l + 1; i <= r; i++)
        {
            if (less(arr[i], v))
            {
                swap(arr, j + 1, i);
                j++;
            }
        }
        swap(arr, l, j);

        return j;
    }

    public static void main(String[] args)
    {
        Integer[] arr = new Integer[]{5, 4, 3, 2, 1};
//        Integer[] arr = new Integer[]{1, 2, 4, 3, 5};

        new Quick<Integer>().sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
