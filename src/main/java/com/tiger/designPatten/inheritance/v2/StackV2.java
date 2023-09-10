package com.tiger.designPatten.inheritance.v2;

import java.util.Vector;

/**
 * 在V1的基础上，明确了给子类重写或增强的方法
 *
 * @param <E>
 */
public class StackV2<E> {

    private Vector<E> vector = new Vector<>();


    protected void doPush(E e) {
        vector.add(e);
    }

    final public void push(E e) {
        doPush(e);
    }

    final public void multiPush(E... items) {
        for (E e : items) {
            doPush(e);
        }
    }
}
