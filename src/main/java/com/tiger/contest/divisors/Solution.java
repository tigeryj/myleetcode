package com.tiger.contest.divisors;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @auther Jack
 * @date 2020/3/22 11:00
 */

public class Solution {

	private HashMap<Integer, Integer> cache = new HashMap<>();

	public int sumFourDivisors(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			Set<Integer> divisors = getDivisors(num);
			for (int div : divisors) sum += div;
		}
		return sum;
	}

	private Set<Integer> getDivisors(int num) {
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0) set.add(i);
			if (set.size() > 3) return new HashSet<>();
		}
		set.add(num);

		return set.size() == 4 ? set : new HashSet<>();
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int i = new Solution().sumFourDivisors(nums);
		System.out.println(i);
	}
}
