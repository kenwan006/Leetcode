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
    int res = 100000;
    TreeNode prev;
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return res;
    }
    
    private void traverse(TreeNode root) {
        if (root == null) return;
        
        traverse(root.left);
        
        if (prev == null) {
            prev = root;
        } else {
            res = Math.min(res, root.val - prev.val);
            prev = root;
        }
        
        traverse(root.right);
    }
}