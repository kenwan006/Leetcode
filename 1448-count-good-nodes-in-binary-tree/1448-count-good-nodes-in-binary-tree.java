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

/** Pre-order traversal **/
class Solution {
    private int count = 0;
    
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return count;
    }
    
    private void dfs(TreeNode node, int pre_max) {
        if (node == null) return;
        if (node.val >= pre_max) {// "==" should be considered
            count++;
            pre_max = node.val; //update the current max val
        }
        dfs(node.left, pre_max);
        dfs(node.right, pre_max);
    }
}

//Time: O(n); Space: O(n)