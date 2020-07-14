//146.LRU缓存机制
//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在
//写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得关键字 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得关键字 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计

package com.tiger.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LruCache {
	public static void main(String[] args) {
//last_testcase:["LRUCache","put","put","get","put","get","put","get","get","get"] [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
		LruCache lruCache = new LruCache();
		LRUCache lru = lruCache.new LRUCache(1);
		lru.put(2, 1);//12
		lru.get(2);//21
		lru.put(3, 2);//13
		lru.get(2);//-1
		lru.get(3);//43
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	//Date:2020-07-14 21:29:17
	//解答成功: 执行耗时:21 ms,击败了51.44% 的Java用户
	class Node {
		int key;
		int val;
		Node pre;
		Node next;

		Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	class LRUCache {
		Map<Integer, Node> map;
		Node head;
		Node tail;
		int capacity;

		public LRUCache(int capacity) {
			this.map = new HashMap<>();
			this.head = new Node(-1, -1);
			this.tail = new Node(-1, -1);
			this.capacity = capacity;
			head.next = tail;
			tail.pre = head;
		}

		public int get(int key) {
			Node node = map.get(key);
			if (node == null) return -1;
			put(key, node.val);

			return node.val;
		}

		public void put(int key, int value) {
			Node newNode = new Node(key, value);
			addLast(newNode);

			if (map.containsKey(key)) {
				Node node = map.get(key);
				remove(node);
			}

			map.put(key, newNode);

			if (map.size() > capacity) {
				Node toRemove = head.next;
				remove(toRemove);
				map.remove(toRemove.key);
			}

		}

		private void addLast(Node node) {
			Node pre = tail.pre;
			pre.next = node;

			node.pre = pre;
			node.next = tail;

			tail.pre = node;
		}

		private Node remove(Node node) {
			Node pre = node.pre;
			pre.next = node.next;
			node.next.pre = pre;

			node.next = null;
			node.pre = null;
			return node;
		}
	}

	/**
	 * Your LRUCache object will be instantiated and called as such:
	 * LRUCache obj = new LRUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */
//leetcode submit region end(Prohibit modification and deletion)
//Date:2020-07-14 00:31:34
//执行耗时:22 ms,击败了42.45% 的Java用户

	class LRUCacheV1 {
		int size = 0;
		Map<Integer, Node> map;
		Node head;
		Node tail;

		public LRUCacheV1(int capacity) {
			size = capacity;
			map = new HashMap<>(capacity);
			head = new Node(-1, -1);
			tail = head;
		}

		public int get(int key) {
			Node node = map.get(key);
			if (node == null) return -1;
			if (tail == node) return tail.val;

			Node pre = node.pre;
			Node next = node.next;
			pre.next = next;

			if (next != null) {
				next.pre = pre;
			}

			tail.next = node;
			node.pre = tail;
			node.next = null;
			tail = node;

			return node.val;
		}

		public void put(int key, int value) {
			if (size == 0) return;
			if (map.size() >= size || map.containsKey(key)) {
				Node remove;
				if (map.containsKey(key)) {
					remove = map.remove(key);
				} else {
					remove = map.remove(head.next.key);
				}

				Node pre = remove.pre;
				Node next = remove.next;

				pre.next = next;
				if (next != null) {
					next.pre = pre;
				}

				if (tail == remove) {
					tail = pre;
				}
			}
			Node node = new Node(key, value);
			tail.next = node;
			node.pre = tail;
			tail = node;
			map.put(key, node);
		}
	}

}