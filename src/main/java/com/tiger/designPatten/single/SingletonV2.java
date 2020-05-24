package com.tiger.designPatten.single;

/**
 * @auther Jack
 * @date 2020/5/23 22:50
 */

public class SingletonV2 {
	private static SingletonV2 instance = new SingletonV2();

	private SingletonV2() {
	}

	public static SingletonV2 getInstance() {
		return instance;
	}
}
