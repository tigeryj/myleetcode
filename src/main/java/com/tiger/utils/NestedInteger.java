package com.tiger.utils;

import java.util.List;

/**
 * @auther Jack
 * @date 2020/5/4 12:26
 */

public interface NestedInteger {
	// @return true if this NestedInteger holds a single integer, rather than a nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a single integer
//	 Return null if this NestedInteger holds a nested list
	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();

	public Integer getInteger();
}
