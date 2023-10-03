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
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        Node dummy = new Node(-1); //dummy points to the head of each layer
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = dummy;
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
                prev.next = curr;
                prev = curr;
            }
            //break dummy with current layer and move it to next layer
            dummy.next = null; 
        }
        return root;
    }
}