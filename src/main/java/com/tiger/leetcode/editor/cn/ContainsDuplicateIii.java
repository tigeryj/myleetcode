//220.存在重复元素 III
//给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的
//差的绝对值最大为 ķ。 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3, t = 0
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1, t = 2
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
//输出: false 
// Related Topics 排序 Ordered Map

package com.tiger.leetcode.editor.cn;

import java.util.TreeSet;

public class ContainsDuplicateIii {
	public static void main(String[] args) {
		Solution solution = new ContainsDuplicateIii().new Solution();
		System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		//s3:桶排序的思想 todo
		public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
			TreeSet<Long> set = new TreeSet<>();
			for (int i = 0; i < nums.length; i++) {
				Long floor = set.floor((long) nums[i]);
				if (floor != null && floor >= (long) nums[i] - t) return true;
				Long ceiling = set.ceiling((long) nums[i]);
				if (ceiling != null && ceiling <= (long) nums[i] + t) return true;

				set.add((long) nums[i]);
				if (set.size() > k) set.remove((long)nums[i - k]);
			}
			return false;
		}

		public boolean containsNearbyAlmostDuplicateV1(int[] nums, int k, int t) {
			TreeSet<Long> set = new TreeSet<>();
			for (int i = 0; i < nums.length; i++) {
				long num = nums[i];
				Long ceiling = set.ceiling(num - t);
				if (ceiling != null && ceiling.longValue() <= num + t) {
					return true;
				}
				set.add(num);
				if (set.size() > k) set.remove((long) nums[i - k]);
			}
			return false;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
