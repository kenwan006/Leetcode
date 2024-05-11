/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    Map<Node, NodeCopy> map;
    public NodeCopy copyRandomBinaryTree(Node root) {
        map = new HashMap<>(); //map original node -> node copy
        traverse1(root); //check all node and copy the node val
        traverse2(root); // check all node and copy the random, left, right relationship
        return map.get(root);
    }
    
    private void traverse1(Node root) {
        if (root == null) return;
        
        map.putIfAbsent(root, new NodeCopy(root.val));
        traverse1(root.left);
        traverse1(root.right);
    }
    
    private void traverse2(Node root) {
        if (root == null) return;
        
        Node left = root.left;
        Node right = root.right;
        Node random = root.random;
        
        map.get(root).left = map.get(left);
        map.get(root).right = map.get(right);
        map.get(root).random = map.get(random);
        
        traverse2(root.left);
        traverse2(root.right);
    }
}