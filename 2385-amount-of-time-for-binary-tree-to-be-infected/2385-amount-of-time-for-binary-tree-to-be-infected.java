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
    int amount = 0;
    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start);
        return amount;
    }
    
    /**
    * Return the depth of tree
    * If both left and right child have depth >= 0, then depth of the tree is positive
    * If start at the root, then depth of root is -1
    * Any subtree contains the start has negative depth
    */
    private int dfs(TreeNode root, int start) {
        if (root == null) return 0;
        
        int left = dfs(root.left, start);
        int right = dfs(root.right, start);
        
        if (root.val == start) {
            amount = Math.max(left, right); //the max depth could be one child
            return -1;
        } else if (left >= 0 && right >= 0) { //start is not in this sub-tree
            return Math.max(left, right) + 1;
        } else {
            amount = Math.max(amount, Math.abs(right - left));
            return Math.min(left, right) - 1;
        }
    }
}