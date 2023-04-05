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
* n - the total length of the linkedlist, connect the tail to the head of the linkedlsit - a cycle formed
* if k is greater than n, one can just rotate k % n. One can just break the list at (k % n)th node
**/
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        
        int n = 1;
        ListNode p = head;
        for (; p.next != null; p = p.next) n++;
        p.next = head; //connect tail to head; then break the cycle
        
        k = k % n; //in case k is greater than n
        
        //find the break point
        ListNode q = head; 
        for (int i = 1; i < n - k; i++) q = q.next;
        
        head = q.next; //new head
        q.next = null; //new tail
        
        return head;
    }
}
//Time: O(n); Space: O(1)