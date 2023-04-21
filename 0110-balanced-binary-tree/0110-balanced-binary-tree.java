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
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }
    
    public int getDepth(TreeNode root) {
        if (root == null) return 0;
        
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        
        if (Math.abs(l - r) > 1) isBalanced = false;
        
        return Math.max(l, r) + 1;
    }
}
//Time: O(n); Space: O(n)