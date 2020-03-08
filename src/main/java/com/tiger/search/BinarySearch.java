package com.tiger.search;

import com.tiger.sort.Quick;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @auther Jack
 * @date 2020/3/1 11:31
 */

//二分查找法
public class BinarySearch {

    public int find(int[] sortedArr, int target) {

        int l = 0;
        int r = sortedArr.length - 1;

        while (l <= r) {

            int mid = l + (r - l) / 2;
            if (sortedArr[mid] == target) {
                return mid;
            } else if (sortedArr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public int find(int[] arr, int l, int r, int target) {
        int mid = l + (r - l) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return find(arr, mid + 1, r, target);
        } else {
            return find(arr, l, mid - 1, target);
        }
    }

    public static void main(String[] args) {

        int[] arr = {-9, 3, 5, 76, 192};

        int index = new BinarySearch().find(arr, 0, arr.length - 1, 3);

        System.out.println(index);
    }
}
