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
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, 0, path);
        return res;
    }
    
    private void dfs(TreeNode root, int targetSum, int pathSum, List<Integer> path) {
        if (root == null) return;
        pathSum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && pathSum == targetSum) res.add(new ArrayList<>(path));
        
        dfs(root.left, targetSum, pathSum, path);
        dfs(root.right, targetSum, pathSum, path);
        
        pathSum -= root.val;
        path.removeLast();
    }

}