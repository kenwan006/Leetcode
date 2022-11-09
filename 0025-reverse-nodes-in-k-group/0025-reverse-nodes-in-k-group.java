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
/** Iteration 
* Fisrt define a reverse function to reverse all nodes between start and end exclusively
  -reverse(start, end), it returns the tail node of the reversed list
* Iterate through the original list, and count the nodes walked by, once count % k == 0, then run reveser(start, end)
* eg: -1(dummy) -> 1 -> 2 ->3 ->4 -> 5 -> 6, k = 3, start = -1, ptr = 1, when count == 3, ptr walks to 4, and reverse nodes between -1 and 4, run reverse(-1, 4) we get new start = 1, and the new list is: -1(dummy) -> 3 -> 2-> 1(new start)-> 4 -> 5 -> 6
*/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head; //pointer to iterate through the linked list
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode start = dummy;
        int count = 0;
        while (ptr != null) {
            count++;
            ptr = ptr.next;
            if (count % k == 0) 
                start = reverse(start, ptr);
        }
        return dummy.next;
    }
    
    // reverse nodes between start and end, (start, end) exclusively 
    //eg: -1(start) -> 1(revTail) -> 2 -> 3 -> 4(end), after the reverse -1 -> 3 -> 2 -> 1(revTail) -> 4, return the revTail 
    public ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = start; // start always represent the end of the previously reversed list
        ListNode curr = start.next;
        ListNode revTail = start.next;
        while (curr != end) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        start.next = prev; //point -1(start) to 3(new head)
        revTail.next = end; //point the 1(new tail) to 4 (end)
        return revTail;
    }
}