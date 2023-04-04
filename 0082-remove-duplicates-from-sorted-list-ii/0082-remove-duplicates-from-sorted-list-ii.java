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

/** Two pointers */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy; //initialize the prev pointing to the dummy head
      
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {//skip the duplicate numbers
                while (head.next != null && head.val == head.next.val) head = head.next;
                prev.next = head.next;
            } else {
                prev.next = head;
                prev = prev.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
//Time: O(n); Space: O(1)