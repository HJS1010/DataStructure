package com.stone.list;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Solution203 {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(arr);
        System.out.println(head);
        ListNode listNode = new Solution203().removeElements(head, 6);
        System.out.println(listNode);
    }

}
