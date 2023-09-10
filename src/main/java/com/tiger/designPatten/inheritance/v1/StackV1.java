package com.tiger.designPatten.inheritance.v1;

import java.util.Vector;

/**
 * 实现一个stack，包含push和multiPush方法
 * 这个类里面存在一个问题，push方法分饰两角，既是公有的多态方法，又被内部实现使用。
 * 子类覆盖了该方法后，在运行时发生多态调用时可能会出现预期外的异常
 * @param <E>
 */
public class StackV1<E> {

    private Vector<E> vector = new Vector<>();

    public void push(E e) {
        vector.add(e);
    }

    public void multiPush(E... items) {
        for (E e : items) {
            push(e);
        }
    }
}
