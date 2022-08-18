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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null); // second parameter is the min limit for right tree; third is max limit for left tree
    }
    
    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if(min != null && min.val >= root.val) return false; 
        if(max != null && max.val <= root.val) return false;
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}