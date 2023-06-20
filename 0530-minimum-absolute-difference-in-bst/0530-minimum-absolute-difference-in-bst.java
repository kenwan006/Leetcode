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
    int diff = 100000;
    int preval = 100000;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return diff;
    }
    
    //inorder traversal on a binary search tree - sequential order
    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        
        diff = Math.min(diff, Math.abs(root.val - preval));
        preval = root.val;
        
        dfs(root.right);
        
    }
}
//Time: O(n); Space: O(n)


