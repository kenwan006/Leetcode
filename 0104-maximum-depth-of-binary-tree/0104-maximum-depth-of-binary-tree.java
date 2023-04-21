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
    int max = 0;
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        traverse(root, 1);
        return max;
    }
    
    public void traverse(TreeNode root, int depth) {
        if (root == null) return;
        traverse(root.left, depth + 1);
        traverse(root.right, depth + 1);
        max = Math.max(max, depth);
    }
}