/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //find the length diff
        int len1 = 0, len2 = 0;
        for (ListNode p = headA; p != null; p = p.next) len1++;
        for (ListNode q = headB; q != null; q = q.next) len2++;
        if (len1 > len2) return getIntersectionNode(headB, headA);
        
        //two pointers
        int n = len2 - len1;
        for (int i = 0; i < n; i++) headB = headB.next;
        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
//Time: O(n); Space: O(1)