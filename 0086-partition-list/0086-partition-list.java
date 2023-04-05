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
/** Two Pointers
* Create the list to include all nodes with val < x, and another list to list all nodes with val >= x;
* Connnect two lists
*/
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p = dummy1; //val < x
        ListNode q = dummy2; //val >= x
        
        while (head != null) {
            if (head.val < x) {
                p.next = head;
                p = p.next;
            } else {
                q.next = head;
                q = q.next;
            }
            head = head.next;
            
        }
        q.next = null; //q finally points to null
        p.next = dummy2.next;
        return dummy1.next;
    }
}
//Time: O(n); Space: O(1)