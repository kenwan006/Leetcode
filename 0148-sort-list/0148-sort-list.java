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
/** Merger sort 
** Break the linkedlist at the middle, sort the first half and second half, then merge them.
*/
class Solution {
    public ListNode sortList(ListNode head) {
        // base case
        if (head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }
    
    //merge two sorted linkedlist
    public ListNode merge(ListNode p, ListNode q) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                curr.next = p;
                p = p.next;
            } else {
                curr.next = q;
                q = q.next;
            }
            curr = curr.next;
        }
        curr.next = p == null? q : p; //append the non depleted one
        return dummy.next;
    }
    
    //break the linkedlist at the middle, return this middle node
    public ListNode getMid(ListNode head) {
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; //break the connection 
        return slow;
    }
}
//Time: O(n*log(n)); Space: O(1)