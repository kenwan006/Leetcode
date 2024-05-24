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
    int longest = 1;
    public int longestConsecutive(TreeNode root) {
        dfs(null, root, 1);
        return longest;
    }
    
    private void dfs(TreeNode parent, TreeNode root, int path) {
        longest = Math.max(longest, path);
        
        if (root == null) return;
        
        if (parent != null && parent.val + 1 == root.val) {
            path++;
        } else {
            path = 1;
        }
        
        dfs(root, root.left, path);
        dfs(root, root.right, path);
    }
}