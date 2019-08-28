/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Solution203WithDummyHead {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(arr);
        System.out.println(head);
        ListNode listNode = new Solution203WithDummyHead().removeElements(head, 6);
        System.out.println(listNode);

        int[] arr1 = {1,1,2,2,2,2};
        ListNode head1 = new ListNode(arr1);
        System.out.println(head1);
        ListNode listNode1 = new Solution203WithDummyHead().removeElements(head1, 1);
        System.out.println(listNode1);
    }

}
