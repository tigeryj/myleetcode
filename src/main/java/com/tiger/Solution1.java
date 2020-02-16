package com.tiger;

import java.util.HashMap;

/**
 * 1.两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution1
{
    public static void main(String[] args)
    {
        int[] nums = {3, 3};
        int target = 6;

        int[] ints = new Solution1().twoSumV2(nums, target);

        System.out.println(ints[0] + "  " + ints[1]);
    }

    //v1
    public int[] twoSum(int[] nums, int target)
    {
        if (nums == null)
        {
            return null;
        }
        for (int i = 0; i < nums.length - 1; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[i] == target - nums[j])
                {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //v2
    public int[] twoSumV2(int[] nums, int target)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
        {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++)
        {
            int tofind = target - nums[i];

            Integer anotherIndex = map.get(tofind);

            if (anotherIndex != null && anotherIndex != i)
            {
                return new int[]{i, anotherIndex};
            }
        }
        return null;
    }

    //v3
    public int[] twoSumV3(int[] nums, int target)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
        {

            int anotherOne = target - nums[i];

            if (map.containsKey(anotherOne) && map.get(anotherOne) != i)
            {
                return new int[]{map.get(anotherOne), i};
            }

            map.put(nums[i], i);
        }
        return null;
    }

}




















