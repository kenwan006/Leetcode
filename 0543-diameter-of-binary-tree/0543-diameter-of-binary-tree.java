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
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res;
    }
    
    private int depth(TreeNode root) {
        if (root == null) return 0;
        int d1 = depth(root.left);
        int d2 = depth(root.right);
        res = Math.max(res, d1 + d2);
        return Math.max(d1, d2) + 1;
    }
}