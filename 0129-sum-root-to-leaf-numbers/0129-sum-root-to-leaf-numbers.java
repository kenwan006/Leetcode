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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, "");
        return sum;
    }
    
    private void dfs(TreeNode root, String path) {
        if (root == null) return;
        
        path += root.val;
        
        //return if a leaf found
        if (root.left == null && root.right == null) {
            sum += Integer.valueOf(path);
            return;
        }
        
        dfs(root.left, path);
        dfs(root.right, path);
    }
}