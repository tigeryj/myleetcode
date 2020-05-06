//341.扁平化嵌套列表迭代器
//给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。 
//
// 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。 
//
// 
//
// 示例 1: 
//
// 输入: [[1,1],2,[1,1]]
//输出: [1,1,2,1,1]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。 
//
// 示例 2: 
//
// 输入: [1,[4,[6]]]
//输出: [1,4,6]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
// 
// Related Topics 栈 设计

package com.tiger.leetcode.editor.cn;

import com.tiger.utils.NestedInteger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FlattenNestedListIterator {
	public static void main(String[] args) {

	}
	//leetcode submit region begin(Prohibit modification and deletion)

//	public interface NestedInteger {
	// @return true if this NestedInteger holds a single integer, rather than a nested list.
//		public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return null if this NestedInteger holds a single integer
//		public List<NestedInteger> getList();

//		public Integer getInteger();

//	}

	public class NestedIterator implements Iterator<Integer> {

		private Queue<Integer> queue = new LinkedList<>();

		public NestedIterator(List<NestedInteger> nestedList) {
			DFS(nestedList);
		}

		@Override
		public Integer next() {
			return queue.poll();
		}

		@Override
		public boolean hasNext() {
			return !queue.isEmpty();
		}

		private void DFS(List<NestedInteger> nestedList) {
			if (nestedList == null || nestedList.isEmpty()) return;
			for (NestedInteger nestedInteger : nestedList) {
				if (nestedInteger.isInteger()) {
					queue.offer(nestedInteger.getInteger());
				} else {
					DFS(nestedInteger.getList());
				}
			}
		}
	}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
//leetcode submit region end(Prohibit modification and deletion)

}