package com.tiger.utils;

import java.util.Random;

/**
 * @auther Jack
 * @date 2020/6/25 15:01
 */

public class RandomBox {
	private int min;
	private int max;

	private Random random;

	public RandomBox(int min, int max) {
		this.min = min;
		this.max = max;
		this.random = new Random(System.currentTimeMillis());
	}

	public int random() {
		return min + random.nextInt(max - min + 1);
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public int rand01() {
		int min = this.getMin();
		int max = this.getMax();

		int size = max - min + 1;
		boolean odd = (size & 1) != 0;
		int mid = size / 2;
		int random = 0;
		do {
			random = random() - min;
		} while (odd && mid == random);

		return random < mid ? 0 : 1;
	}

	public int randomMtoN(int m, int n) {
		if (m == n) return m;

		int range = n - m;
		//表示range的二进制位的个数
		int num = 1;
		while ((1 << num) - 1 < range) {
			num++;
		}

		int random = 0;
		do {
			random = 0;
			for (int i = 0; i < num; i++) {
				random += (rand01() << i);
			}
		} while (random > range);

		return m + random;
	}

	public static void main(String[] args) {
		RandomBox randomBox = new RandomBox(10, 20);

		int[] freq = new int[11];
		for (int i = 0; i < 1000000; i++) {
			freq[randomBox.randomMtoN(0, 10)]++;
		}

		System.out.println(freq[0]);
		System.out.println(freq[1]);
		System.out.println(freq[2]);
		System.out.println(freq[3]);
		System.out.println(freq[4]);

	}
}
