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
/** DFS **/
class Solution {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        dfs(root, targetSum);
        return res;
    }
    
    private void dfs(TreeNode root, int targetSum) {
        if (root == null) return;
        
        path.add(root.val);
        
        if (root.left == null && root.right == null && targetSum - root.val == 0) {
                res.add(new LinkedList<>(path));
        } else {
            dfs(root.left, targetSum - root.val);
            dfs(root.right, targetSum - root.val);
        }
       
        path.removeLast();
    }
}