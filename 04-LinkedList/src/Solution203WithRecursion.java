/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Solution203WithRecursion {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        if (head.val == val) {
            return head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(arr);
        System.out.println(head);
        ListNode listNode = new Solution203WithRecursion().removeElements(head, 6);
        System.out.println(listNode);

        int[] arr1 = {1, 1, 2, 2, 2, 2};
        ListNode head1 = new ListNode(arr1);
        System.out.println(head1);
        ListNode listNode1 = new Solution203WithRecursion().removeElements(head1, 1);
        System.out.println(listNode1);
    }

}
