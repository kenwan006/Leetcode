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
    private int longest = 1;
    
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.left, 1);
        dfs(root, root.right, 1);
        return longest;
    }
    
    private void dfs(TreeNode parent, TreeNode root, int path) {
        if (root == null) return;
        
        if (root.val == parent.val + 1) {
            path++;
        } else {
            path = 1;
        }
        longest = Math.max(longest, path);
        
        dfs(root, root.left, path);
        dfs(root, root.right, path);
        
    }
}