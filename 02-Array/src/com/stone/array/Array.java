package com.stone.array;

/**
 * 动态数组
 * 数组的容量动态变化的，不是固定的不变的
 * 随着数组元素的增加，动态扩容
 * 随着数组元素的减小，动态缩容
 */
public class Array {
    private static final int DEFAULT_CAPACITY = 10;

    private int[] data;
    private int size;

    // 构造函数，数组的容量：capacity
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // 无参的构造函数，默认数组的容量：DEFAULT_CAPACITY
    public Array() {
        this(DEFAULT_CAPACITY);
    }

    // 获取数组中元素的个数
    public int getSize() {
        return size;
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向数组所有元素之后添加一个新元素
    public void addLast(int e) {
//        if (size == data.length) {
//            throw new IllegalArgumentException("AddLast failed. Array is full.");
//        }
//        data[size] = e;
//        size++;
        add(size, e);
    }

    // 向数组所有元素之前插入一个新元素 e
    public void addFirst(int e) {
        add(0, e);
    }

    // 在 index 索引位置插入一个新元素e
    public void add(int index, int e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        if (size == data.length) {
            throw new IllegalArgumentException("Add failed. Array is full.");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 获取数组的第一个元素
    public int getFirst() {
        return get(0);
    }

    // 获取数组的最后一个元素
    public int getLast() {
        return get(size - 1);
    }

    // 获取 index 索引位置的元素
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        return data[index];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size: %d, capacity: %d\n",
                size, getCapacity()));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }


}
