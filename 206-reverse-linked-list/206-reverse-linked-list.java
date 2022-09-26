/** Iterative
* Use to node pointer curr and prev
* save the next node of curr, next_curr = curr.next
* point curr to prev, curr.next = prev, then move prev to curr, prev = curr and move curr to next_curr, curr = next_curr;
*/

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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next_curr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next_curr;
        }
        return prev;
    }
}