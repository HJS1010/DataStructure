package com.stone.list;

/**
 * 链表：使用递归实现
 */
public class LinkedListWithRecursion<E> {

    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListWithRecursion() {
        dummyHead = new Node();
        size = 0;
    }

    // 获取链表中元素个数
    public int getSize() {
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e) {
        add(0, e);
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }

    // 在链表的 index(0-based) 位置添加新的元素e
    public void add(int index, E e) {
        // TODO: 2019/8/28  

    }

    // 获取链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获取链表的最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 获取链表的第 index 位置的元素
    private E get(int index) {
        // TODO: 2019/8/28  
        return null;
    }

    // 修改链表的第 index 位置的元素为e
    public void set(int index, E e) {
        // TODO: 2019/8/28  

    }

    // 查找链表中是否有元素e
    public boolean contains(E e) {

        return false;
    }

    // 删除链表第一个元素
    public E removeFirst() {
        return remove(0);
    }

    // 删除链表最后一个元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 删除链表中 index 位置元素，并返回删除元素
    public E remove(int index) {
        // TODO: 2019/8/28  
        return null;
    }

    // 从链表中删除元素e
    public void removeElement(E e) {
        removeElement(dummyHead, e);
    }

    private Node removeElement(Node head, E e) {
        if (head == null) {
            return null;
        }
        head.next = removeElement(head.next, e);
        if (head.e == e) {
            return head.next;
        } else {
            return head;
        }
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur.e);
            res.append("->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
