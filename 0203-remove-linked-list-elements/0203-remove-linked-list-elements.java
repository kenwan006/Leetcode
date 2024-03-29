/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (head != null) {
            if (head.val == val) {
                p.next = head.next;
            } else {
                p.next = head;
                p = p.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}