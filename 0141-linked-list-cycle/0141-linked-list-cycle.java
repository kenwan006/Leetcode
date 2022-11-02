/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/** HashSet 
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
//Time: O(n); Space: O(n)
// Two pointer is a better method as the space complexity can be optimized to O(1)
*/

/** Two pointers - fast and slow
* Use two pointers, fast and slow
* Move slow by one step and fast two steps every time. If there is no cycle, slow will never catch up with fast before it comes to the end; otherwise they will meet at some point.
*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) { // until slow catches up with fast
            if (fast == null || fast.next == null) { //fast pointer comes to the end of the linkedlist
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
//Time: O(n); Space: O(1)