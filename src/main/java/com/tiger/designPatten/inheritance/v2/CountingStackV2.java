package com.tiger.designPatten.inheritance.v2;


/**
 * 通过继承Stack，实现一个计数的Stack
 *
 * @param <E>
 */
public class CountingStackV2<E> extends StackV2<E> {

    private int count;

    @Override
    protected void doPush(E e) {
        count++;
        super.doPush(e);
    }

    public int getPushCount() {
        return count;
    }
}
