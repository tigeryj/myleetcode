package com.tiger.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @auther Jack
 * @date 2020/2/23 20:29
 */

public class Quick<T extends Comparable<T>> extends Sort<T>
{
    @Override
    public void sort(T[] arr)
    {
        quickSort3Ways(arr, 0, arr.length - 1);

    }

    public void quickSort(T[] arr, int l, int r)
    {
        if (l >= r)
        {
            return;
        }

        Random random = new Random(System.currentTimeMillis());
        int randomIndex = l + random.nextInt(r - l + 1);
        swap(arr, l, randomIndex);

        int partitionIndex = partitionV2(arr, l, r);

        quickSort(arr, l, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, r);
    }

    public void quickSort3Ways(T[] arr, int l, int r)
    {
        if (l >= r)
        {
            return;
        }

        Random random = new Random(System.currentTimeMillis());
        int randomIndex = l + random.nextInt(r - l + 1);
        swap(arr, l, randomIndex);

        T v = arr[l];
        int lt = l;//arr[l+1...lt]<v
        int gt = r + 1;//arr[gt...r]>v
        int i = l + 1;

        while (i < gt)
        {
            if (less(arr[i], v))
            {
                swap(arr, i, lt + 1);
                i++;
                lt++;
            } else if (less(v, arr[i]))
            {
                swap(arr, i, --gt);
            } else
            {
                i++;
            }
        }
        swap(arr, l, lt);

        quickSort3Ways(arr, l, lt - 1);
        quickSort3Ways(arr, gt, r);
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

    //双路排序
    public int partitionV2(T[] arr, int l, int r)
    {
        int i = l + 1;
        int j = r;
        T v = arr[l];
        while (true)
        {
            while (i <= r && (less(arr[i], v)))
            {
                i++;
            }
            while (j >= l + 1 && (less(v, arr[j])))
            {
                j--;
            }
            if (i > j)
            {
                break;
            }
            swap(arr, i, j);

            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    public static void main(String[] args)
    {
//        Integer[] arr = new Integer[]{5, 4, 3, 2, 1};
//        Integer[] arr = new Integer[]{1, 2, 4, 3, 5, 9, 2, 7, 4, 5, 6, 8};
        Integer[] arr = new Integer[]{2, 3, 5, 4, 3, 3, 3, 3, 3, 3, 3, 3};

        new Quick<Integer>().sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
