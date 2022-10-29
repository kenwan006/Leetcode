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

/** Two pointers
* Define two pointers p1 and p2, both starts from head;
* Move p1 by n steps first and stops; (Attention on the edge case:  list.size() == n) 
* Move p1 and p2 at the same time, once p1 comes to the end of the list, p1 comes to the node that has to be removed
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        //We point p1 to dummy instead of head, so when n == head.size,
        //it won't become null after moving n steps since dummy.size = head.size + 1
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        
        //Move p1 by n steps first and stops
        for (int i = 0; i < n; i++) p1 = p1.next;
        
        //Move p1 and p1 at the same time until p1 comes to the end 
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        
        //Remove the nth node
        p2.next = p2.next.next;
        
        return dummy.next;
    }
}

// Time: O(L); Space: O(1);