/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean foundP = false;
    boolean foundQ = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = lca(root, p, q); //leetcode 236
        if (foundP && foundQ) return res;
        return null;
    }
    
    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        
        if (root == p) {
            foundP = true;
            return root;
        }
        
        if (root == q) {
            foundQ = true;
            return root;
        }
        
        if (left != null && right != null) return root;
        else if (left == null) return right;
        else return left;
    }
}