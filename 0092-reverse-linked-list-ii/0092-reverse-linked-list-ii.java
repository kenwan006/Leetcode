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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode curr = dummy;
        
        for (int i = 0; i < left - 1; i++) curr = curr.next;
        
        ListNode l1 = curr;
        ListNode l2 = curr.next;
        
        ListNode prev = null;
        curr = curr.next;
        for (int i = left; i <= right; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        ListNode r = curr;
        
        l1.next = prev;
        l2.next = r;
        
        return dummy.next;
    }
}