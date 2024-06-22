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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode prev = null;
        TreeNode prev_right = null; //right node of this prev node
        TreeNode next = null;
        TreeNode right = null;
        
        while (root != null) {
            next = root.left;
            right = root.right;
            
            root.left = prev_right;
            root.right = prev;
            
            prev = root;
            prev_right = right;
            
            root = next;
        }
        return prev;
    }
}