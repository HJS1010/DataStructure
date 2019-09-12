package com.stone.seg;

/**
 * 线段树
 */
public class SegmentTree<E> {
    private final Merger<E> merger;
    private E[] tree;
    private E[] data;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, arr.length - 1);
    }

    // 在treeIndex的位置创建表示区间[lt...rt]的线段树
    private void buildSegmentTree(int treeIndex, int lt, int rt) {
        if (lt == rt) {
            tree[treeIndex] = data[lt];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = lt + (rt - lt) / 2;
        buildSegmentTree(leftTreeIndex, lt, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, rt);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Illegal Index.");
        }
        return data[index];
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // 返回区间[queryL, queryR]的值
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length ||
                queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("Illegal Index.");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    // 在以treeIndex为根的线段树中[lt...rt]的范围里，搜索区间[queryL...queryR]的值
    private E query(int treeIndex, int lt, int rt, int queryL, int queryR) {
        if (lt == queryL && rt == queryR) {
            return tree[treeIndex];
        }
        int mid = lt + (rt - lt) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (queryL >= mid + 1) {
            return query(rightTreeIndex, mid + 1, rt, queryL, queryR);
        } else if (queryR <= mid) {
            return query(leftTreeIndex, lt, mid, queryL, queryR);
        }

        E leftResult = query(leftTreeIndex, lt, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, rt, mid + 1, queryR);

        return merger.merge(leftResult, rightResult);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if (i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
