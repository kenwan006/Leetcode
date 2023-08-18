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
        Node curr = root;
        Node dummy = new Node(-1);
        Node p = dummy;
        
        while (curr != null) {
            if (curr.left != null) {
                p.next = curr.left;
                p = p.next;
            }
            if (curr.right != null) {
                p.next = curr.right;
                p = p.next;
            }
            
            //check next of curr at the current level
            if (curr.next != null) {
                curr = curr.next;
            } else { //move curr to next level
                curr = dummy.next;
                dummy.next = null; //reset dummy and p
                p = dummy;
            }
        }
        return root;
    }
}