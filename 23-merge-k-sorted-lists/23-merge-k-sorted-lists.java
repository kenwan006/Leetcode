/** Prioirty Queue
* Say there are k lists to be merged. Initialize a Minheap by selecting the head val (min val) of each linkedlist
* pop out the minimum value from the heap, and add it to the result
* add a new item to the heap and repeat the last step
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (x1, x2) -> x1.val - x2.val); // define a comparator using lambda 
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        // construct the heap
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }
        
        // find the min node and add to the result
        while (!pq.isEmpty()) {
            ListNode min = pq.poll(); // pop out the head of the heap, which has the min value
            if (min.next != null) pq.add(min.next); // add it's next node back to the heap
            head.next = min;
            head = head.next; // move head to next position
        } 
      return dummy.next;  
    }
}