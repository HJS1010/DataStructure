package com.stone.set;

/**
 * 集合
 */
public interface Set<E> {
    // 向集合中添加元素e
    void add(E e);

    // 返回集合是否包含元素e
    boolean contains(E e);

    // 从集合中删除元素e
    void remove(E e);

    // 获取集合中元素个数
    int getSize();

    // 返回集合是否为空
    boolean isEmpty();


}
