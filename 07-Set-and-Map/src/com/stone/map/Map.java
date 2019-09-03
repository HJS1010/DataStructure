package com.stone.map;

public interface Map<K, V> {

    int getSize();

    boolean isEmpty();

    void add(K key, V value);

    void set(K key, V value);

    V get(K key);

    boolean contains(K key);

    V remove(K key);
}
