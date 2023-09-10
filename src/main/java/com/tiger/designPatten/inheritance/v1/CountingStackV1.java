package com.tiger.designPatten.inheritance.v1;


/**
 * 通过继承Stack，实现一个计数的Stack
 * 这个子类看上去没什么问题，在执行push和multipush方法时，都进行了计数
 * 但是是不稳定的，因为如果父类的multipush方法，修改了实现方式，不直接调用push方法，则count变量就统计有误
 *
 * @param <E>
 */
public class CountingStackV1<E> extends StackV1<E> {

    private int count;

    public void push(E t) {
        count++;
        super.push(t);
    }

    public int getPushCount() {
        return count;
    }
}
