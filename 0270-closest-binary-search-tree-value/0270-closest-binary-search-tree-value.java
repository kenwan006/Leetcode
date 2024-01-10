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
    int prev = -1000000001;
    int res  = Integer.MIN_VALUE;
    
    public int closestValue(TreeNode root, double target) {
        traverse(root, target);
        if (res == Integer.MIN_VALUE) return prev;
        return res;
    }
    
    private void traverse(TreeNode root, double target) {
        if (root == null) return;
        
        traverse(root.left, target);
        
        if (target >= prev && target <= root.val) {
            res = target - prev <= root.val - target? prev : root.val;
        }
        
        prev = root.val;
        
        traverse(root.right, target);
    }
}