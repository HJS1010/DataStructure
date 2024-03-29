package com.stone.bst;

/**
 * 测试:前序遍历\中序遍历\后序遍历\层序遍历(递归方式)
 */
public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            bst.add(num);

        /////////////////
        //      5      //
        //     /  \    //
        //    3    6    //
        //   / \    \   //
        //  2  4     8  //
        /////////////////
        bst.preOrder();
        System.out.println();

        bst.inOrder();
        System.out.println();

        bst.postOrder();
        System.out.println();

        bst.levelOrder();
        System.out.println();
    }
}
