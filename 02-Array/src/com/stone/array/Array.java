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
}
