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
    int dia = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root); //the depth returned will not be used
        return dia;
    }
    
    public int getDepth(TreeNode root) {
        if (root == null) return 0;
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        dia = Math.max(dia, l + r);
        return Math.max(l, r) + 1;
    }
}