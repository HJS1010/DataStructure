package com.stone.queue;

/**
 * 队列：先进先出
 * First In, First Out. FIFO
 */
public interface Queue<E> {

    // 入队：添加元素到队列的尾部
    void enqueue(E e);

    // 出队：取出队列首部的元素
    E dequeue();

    // 获取队首元素
    E getFront();

    // 获取队列的元素个数
    int getSize();

    // 队列是否为空
    boolean isEmpty();

}
