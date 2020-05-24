package com.tiger.designPatten.single;

/**
 * @auther Jack
 * @date 2020/5/23 22:32
 */

//safe double check locking
public class SingletonV1 {

	private SingletonV1() {
	}

	private static volatile SingletonV1 instance;

	public static SingletonV1 getInstance() {
		if (instance == null) {
			synchronized (SingletonV1.class) {
				if (instance == null) {
					instance = new SingletonV1();
				}
			}
		}
		return instance;
	}
}
