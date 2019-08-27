package com.stone.queue;

import com.stone.LinkedList;

/**
 * 基于链表实现的队列
 * enqueue: O(n)
 * dequeue: O(1)
 * getFront: O(1)
 */
public class LinkedListQueue<E> implements Queue<E> {
    private LinkedList<E> list;

    public LinkedListQueue() {
        list = new LinkedList<>();
    }

    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }

    @Override
    public E getFront() {
        return list.getFirst();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
