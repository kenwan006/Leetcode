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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode curr = dummy;
        ListNode first;
        ListNode second;
        ListNode tmp;
        while (curr.next != null && curr.next.next != null) {
            tmp = curr.next.next.next;
            first = curr.next;
            second = curr.next.next;
            curr.next = second;
            second.next = first;
            first.next = tmp;
            curr = first;
        }
        return dummy.next;
    }
}