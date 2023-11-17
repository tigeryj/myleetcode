package com.tiger.sort;

public interface LessAble<T extends Comparable> {

    default boolean less(T t, T b) {
        return t.compareTo(b) < 0;
    }
}
