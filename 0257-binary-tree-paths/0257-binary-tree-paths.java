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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, res, "");
        return res;
    }
    
    private void dfs(TreeNode root, List<String> res, String s) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            s += root.val;
            res.add(s);
            return;
        }
        
        s += root.val;
        s += "->";
        
        dfs(root.left, res, s);
        dfs(root.right, res, s);
    }
}