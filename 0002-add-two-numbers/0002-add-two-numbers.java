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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode l = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null? 0 : l1.val;
            int val2 = l2 == null? 0 : l2.val;
            int sum = val1 + val2 + carry;
            l.next = new ListNode(sum % 10);
            carry = sum / 10; // eith 0 or 1
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            l = l.next;
        }
        // check if carry exist after checking the last node
        if (carry > 0) l.next = new ListNode(carry);
        
        return dummy.next;
    }
}

//Time: O(max(l1, l2)); Space: O(max(l1, l2));