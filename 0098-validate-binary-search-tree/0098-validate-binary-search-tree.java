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
/** Inorder traversal **/
class Solution {
    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        boolean left = isValidBST(root.left);
        
        if (max == null || max.val < root.val) max = root;
        else return false;
        
        boolean right = isValidBST(root.right);
        
        return left && right;
    }
}
//Time: O(n); Space: O(log(n))
