package com.stone.bst;

/**
 * 测试:层序遍历(非递归)
 */
public class Main2 {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }

        bst.preOrderNR();
    }
}
