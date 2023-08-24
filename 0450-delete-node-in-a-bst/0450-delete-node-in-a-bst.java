/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) return insert(root.left, root.right);
        
        //find the node to be deleted
        TreeNode parent = null;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val == key) break;
            parent = curr;
            if (curr.val < key) curr = curr.right;
            else curr = curr.left;
        }
        
        //key is not in the BST
        if (curr == null) return root;
        
        //break the connection between parent and the deleted node
        if (parent.left != null && parent.left.val == key) parent.left = null;
        if (parent.right != null && parent.right.val == key) parent.right = null;
        
        //insert one child to the child
        TreeNode child = insert(curr.left, curr.right);
        
        //break connection between deleted node and child nodes
        curr.left = null;
        curr.right = null;
        
        //insert the combined child to parent
        insert(parent, child);
        
        return root;
    }
    
    //insert a node to a BST
    private TreeNode insert(TreeNode root, TreeNode node) {
        if (root == null) return node;
        if (node == null) return root;
        if (root.val > node.val) root.left = insert(root.left, node);
        else root.right = insert(root.right, node);
        return root;
    }
}