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
/** Iteratively *
* Eg, the list is 1 -> 2 -> 3 -> 4 -> 5 -> 6, left = 2, right = 4
* We have tail node at 2 and prev at 1,  1(prev) -> 2(tail) -> 3 -> 4 -> 5 -> 6, we need to put 3(fwd) to the front, and get
* 1(prev) -> 3 -> 2(tail) -> 4 -> 5 -> 6, now we have to put 4(fwd) to the front, and get
* 1(prev) -> 4 -> 3 -> 2(tail) -> 5 -> 6, Done!
* We need to put (right - left) nodes to the front
*/
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
          
        //the node positioned at index left is the *tail*, mark node before it as *prev*
        ListNode p = dummy;
        for (int i = 1; i < left; i++) p = p.next;
        ListNode prev = p;
        ListNode tail = p.next;
        
        //nodes between left+1 and right have to be put before the tail one by one
        for (int i = left + 1; i <= right; i++) {
            ListNode fwd = tail.next; //the one has to be put in front
            tail.next = tail.next.next;
            fwd.next = prev.next;
            prev.next = fwd;
        }
        return dummy.next;
    }
}
//Time: O(n); Space: O(1)

