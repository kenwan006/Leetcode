/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node dummy = new Node(-1);
        Node p = dummy; // next layer
        Node curr = root; //current layer
        while (curr != null) {
            if (curr.left != null) {
                p.next = curr.left;
                p = p.next;
            }
            if (curr.right != null) {
                p.next = curr.right;
                p = p.next;
            }
            
            if (curr.next != null) curr = curr.next;
            else {
                curr = dummy.next; //current layer all checked, need to move to next layer
                dummy.next = null; //and movenext layer to its next layer
                p = dummy;
            }
        }
        return root;
    }
}