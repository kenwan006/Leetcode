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
        if (root == null) return null;
        Node curr = root; //curr iterates from left to right at each layer
        
        Node dummy = new Node(-1);
        Node p = dummy; // p and dummy points to the head of next layer, it's always one layer lower than curr
        
        while (curr != null) {
            if (curr.left != null) {
                p.next = curr.left;
                p = p.next;
            }
            if (curr.right != null) {
                p.next = curr.right;
                p = p.next;
            }
            
            //if next of curr is null, then move to the next layer
            if (curr.next != null) {
                curr = curr.next;
            } else {
                curr = dummy.next; //move curr to the next layer
                dummy.next = null; //break dummy with current layer
                p = dummy;
            }
        }
        return root;
    }
}