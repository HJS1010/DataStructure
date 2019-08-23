package com.stone.stack;

/**
 * 栈
 * 后进先出
 * LIFO：Last In, First Out
 */
public interface Stack<E> {

    // 入栈
    void push(E e);

    // 出栈
    E pop();

    // 获取栈顶元素
    E peek();

    // 获取栈中元素个数
    int getSize();

    // 栈是否为空
    boolean isEmpty();

}
