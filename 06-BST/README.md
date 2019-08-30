# BST

## 为什么需要研究树结构？

> 1.树结构是一种天然的组织结构
>
> 2.将数据使用树结构存储后，出奇的高效

## 常见的树

1. 二分搜索树 Binary Search Tree；

2. 平衡二叉树：AVL、红黑树；

3. 堆；

4. 并查集；

5. 线段树；

6. Trie（字典树、前缀树）

##二叉树

1. 和链表一样，动态数据结构；

2. 二叉树具有唯一根节点；

3. 除了叶子节点，每个节点最多有左右两个子节点；

   ```java
   class Node {
       E e;
       Node left;
       Node right;
   }
   ```

4. 二叉树每个节点最多有一个父亲节点；

5. 二叉树具有天然的递归结构；

   每个节点的左子树也是二叉树；

   每个节点的右子树也是二叉树；

6. 二叉树不一定是“满”的；

## 二分搜索树 Binary Search Tree

1. 二分搜索树是二叉树；

2. 二分搜索树的每个节点的值：

   大于其左子树的所有节点的值

   小于其右子树的所有节点的值

3. 每一棵子树也是二分搜索树；

4.存储的元素必须有可比较性；
