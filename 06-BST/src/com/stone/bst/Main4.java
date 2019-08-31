package com.stone.bst;

import java.util.Random;

/**
 * 测试: 删除元素e所在的节点
 */
public class Main4 {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Random random = new Random();
        int n = 1000;

        Integer[] orders = new Integer[n];
        for (int i = 0; i < n; i++) {
            orders[i] = i;
        }
        // 打乱order数组的顺序
        shuffle(orders);

        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(n));
        }

        // 乱序删除[0...n)范围里的所有元素
        for (int i = 0; i < n; i++) {
            Integer order = orders[i];
            if (bst.contains(order)) {
                bst.remove(order);
                System.out.println("After remove " + order
                        + ", size = " + bst.getSize());
            }
        }
        System.out.println(bst.getSize());
    }

    private static void shuffle(Integer[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int pos = (int) (Math.random() * (i + 1));
            Integer t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }
    }
}
