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
    public void reorderList(ListNode head) {
        //find the second half
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next; 
            fast = fast.next.next;
        }
        
        ListNode second = slow.next;
        slow.next = null; //break the connection with first half
        
        //reverse the second half
        second = reverse(second);
        
        //weave with first half
        weave(head, second);
        
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next; 
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    
    private void weave(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        while (list1 != null && list2 != null) {
            head.next = list1;
            head = head.next;
            list1 = list1.next;
        
            head.next = list2;
            head = head.next;
            list2 = list2.next;
        }
        head.next = list1 == null? list2 : list1;
    }
}