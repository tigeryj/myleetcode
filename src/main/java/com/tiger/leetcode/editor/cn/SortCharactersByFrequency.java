//451.根据字符出现频率排序
//给定一个字符串，请将字符串里的字符按照出现的频率降序排列。 
//
// 示例 1: 
//
// 
//输入:
//"tree"
//
//输出:
//"eert"
//
//解释:
//'e'出现两次，'r'和't'都只出现一次。
//因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
// 
//
// 示例 2: 
//
// 
//输入:
//"cccaaa"
//
//输出:
//"cccaaa"
//
//解释:
//'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//注意"cacaca"是不正确的，因为相同的字母必须放在一起。
// 
//
// 示例 3: 
//
// 
//输入:
//"Aabb"
//
//输出:
//"bbAa"
//
//解释:
//此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//注意'A'和'a'被认为是两种不同的字符。
// 
// Related Topics 堆 哈希表

package com.tiger.leetcode.editor.cn;

import java.util.PriorityQueue;

public class SortCharactersByFrequency {
	public static void main(String[] args) {
		Solution solution = new SortCharactersByFrequency().new Solution();
		System.out.println(solution.frequencySort("tree"));
		System.out.println(solution.frequencySort("Aabb"));
		System.out.println(solution.frequencySort("cccaaa"));
		System.out.println(solution.frequencySort(""));

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public String frequencySort(String s) {
			int[] letterFreq = new int[128];
			for (char c : s.toCharArray()) {
				letterFreq[c] += 1;
			}

			PriorityQueue<Letter> priorityQueue = new PriorityQueue<>();

			for (int i = 0; i < letterFreq.length; i++) {
				if (letterFreq[i] != 0) {
					priorityQueue.add(new Letter((char) i, letterFreq[i]));
				}
			}

			StringBuilder sb = new StringBuilder();
			while (!priorityQueue.isEmpty()) {
				Letter letter = priorityQueue.poll();
				for (int i = 0; i < letter.count; i++) {
					sb.append(letter.c);
				}
			}
			return sb.toString();
		}

		public class Letter implements Comparable<Letter> {
			Integer count;
			Character c;

			public Letter(char c, Integer count) {
				this.c = c;
				this.count = count;
			}

			@Override
			public int compareTo(Letter o) {
				return o.count - this.count;
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}