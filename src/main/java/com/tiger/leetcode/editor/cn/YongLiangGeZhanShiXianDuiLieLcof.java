//剑指 Offer 09.用两个栈实现队列
//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 ) 
//
// 
//
// 示例 1： 
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
// 
//
// 示例 2： 
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
// 
//
// 提示： 
//
// 
// 1 <= values <= 10000 
// 最多会对 appendTail、deleteHead 进行 10000 次调用 
// 
// Related Topics 栈 设计

package com.tiger.leetcode.editor.cn;

import java.util.Stack;

public class YongLiangGeZhanShiXianDuiLieLcof {
	public static void main(String[] args) {
		//
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	//Date:2020-06-27 21:00:00
	//解答成功: 执行耗时:59 ms,击败了62.30% 的Java用户
	class CQueue {
		Stack<Integer> appendStack;
		Stack<Integer> deleteStack;

		public CQueue() {
			appendStack = new Stack<>();
			deleteStack = new Stack<>();
		}

		public void appendTail(int value) {
			appendStack.push(value);
		}

		public int deleteHead() {
			if (appendStack.isEmpty() && deleteStack.isEmpty()) return -1;
			if (deleteStack.isEmpty()) {
				while (!appendStack.isEmpty()) {
					deleteStack.push(appendStack.pop());
				}
			}
			return deleteStack.pop();
		}
	}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}