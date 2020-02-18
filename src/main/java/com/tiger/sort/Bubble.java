package com.tiger.sort;

import java.util.Arrays;

/**
 * @auther Jack
 * @date 2020/2/18 22:06
 */

public class Bubble<T extends Comparable<T>> extends Sort<T>
{
    @Override
    public void sort(T[] arr)
    {

        for (int i = arr.length - 1; i > 0; i--)
        {
            boolean sorted = true;

            for (int j = 0; j < i; j++)
            {
                if (less(arr[j + 1], arr[j]))
                {
                    sorted = false;
                    swap(arr, j, j + 1);
                }
            }
            if (sorted)
            {
                break;
            }
        }
    }

    public static void main(String[] args)
    {
//        Integer[] arr = new Integer[]{5, 4, 3, 2, 1};
        Integer[] arr = new Integer[]{1,2,4,3,5};

        new Bubble<Integer>().sort(arr);

        System.out.println(Arrays.toString(arr));
    }


}
