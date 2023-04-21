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
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node == null) continue;
            heap.offer(node);
        }
        while (!heap.isEmpty()) {
            ListNode curr = heap.poll();
            head.next = curr;
            head = head.next;
            if (curr.next != null) heap.offer(curr.next); 
        }
        return dummy.next;
    }
}
//Time: O(m * log(n)); Space: O(n), n- number of lists, m - length of the result linkedlist