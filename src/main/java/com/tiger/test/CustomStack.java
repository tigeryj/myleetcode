package com.tiger.test;

/**
 * @auther Jack
 * @date 2020/3/15 10:41
 */
class CustomStack {

    private int[] arr;

    private int top = -1;

    public CustomStack(int maxSize) {
        arr = new int[maxSize];
    }

    public void push(int x) {
        if (top == arr.length - 1) return;

        arr[++top] = x;
    }

    public int pop() {
        if (top == -1) throw new IllegalStateException("Empty Stack!");

        return arr[top--];
    }

    public void increment(int k, int val) {
        for (int i = 0; i < k && i <= top; i++) {
            arr[i] += val;
        }
    }
}

