package com.tiger.contest;

/**
 * @auther Jack
 * @date 2020/3/22 10:33
 */
class Solution {
	public int[] createTargetArray(int[] nums, int[] index) {
		int[] target = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			target[i] = 101;
		}
		for (int i = 0; i < index.length; i++) {
			if (target[index[i]] == 101) {
				target[index[i]] = nums[i];
			} else {
				int bucket = findBucket(target, index[i]);
				for (int j = bucket - 1; j >= index[i]; j--) {
					target[j + 1] = target[j];
				}
				target[index[i]] = nums[i];
			}
		}
		return target;
	}

	private int findBucket(int[] target, int i) {
		for (int j = i; j < target.length; j++) {
			if (target[j] == 101) return j;
		}
		throw new IllegalStateException("");
	}

	public static void main(String[] args) {
	}


}

