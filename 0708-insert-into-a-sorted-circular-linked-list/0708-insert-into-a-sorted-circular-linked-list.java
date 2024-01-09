/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        
        //find the right place to insert
        Node node = head;
        while (node.next != head) {
            if (node.val <= node.next.val) { //normal non-descending case eg 1 ->1 ->3 -> insert 4 ->5
                if (insertVal >= node.val && insertVal <= node.next.val) break;
                
            } else { // insert at the turning point 3 ->5 ->5 -> (insert 0 or 6) ->1 
                if (insertVal >= node.val || insertVal <= node.next.val) break;
            }
            node = node.next;
        }
        
        //insert 
        Node next = node.next;
        node.next = new Node(insertVal, next);
        return head;
    }
}
//Time: O(n); Space: O(1)

