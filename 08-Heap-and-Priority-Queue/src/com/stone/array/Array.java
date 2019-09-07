package com.stone.array;


/**
 * 动态数组
 * 数组的容量动态变化的，不是固定的不变的
 * 随着数组元素的增加，动态扩容
 * 随着数组元素的减小，动态缩容
 */
public class Array<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private E[] data;
    private int size;

    // 构造函数，数组的容量：capacity
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // 无参的构造函数，默认数组的容量：DEFAULT_CAPACITY
    public Array() {
        this(DEFAULT_CAPACITY);
    }

    public Array(E[] arr) {
        int length = arr.length;
        data = (E[]) new Object[length];
        for (int i = 0; i < length; i++) {
            data[i] = arr[i];
        }
        size = length;
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
    public void addLast(E e) {
        add(size, e);
    }

    // 向数组所有元素之前插入一个新元素 e
    public void addFirst(E e) {
        add(0, e);
    }

    // 在 index 索引位置插入一个新元素e
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 获取数组的第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获取数组的最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 获取 index 索引位置的元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        return data[index];
    }

    // 修改 index 索引位置的元素为e
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 删除数组第一个元素，并返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 删除数组最后一个元素，并返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除 index 位置的元素，返回删除的元素
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    // 从数组中删除元素e
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
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

    // 将数组空间的容量变成 newCapacity 大小
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }


    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Illegal index.");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
}
