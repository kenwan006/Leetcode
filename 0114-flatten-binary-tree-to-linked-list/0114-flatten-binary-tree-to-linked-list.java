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
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        flatten(root.left);
        flatten(root.right);
        
        TreeNode flat_left = root.left;
        TreeNode flat_right = root.right;
        
        //find the rightmost node in the flat_left, and connect flat_right to this end
        if (flat_left == null) return;
        TreeNode ptr = flat_left;
        while (ptr.right != null) ptr = ptr.right;
        ptr.right = flat_right;
        
        root.right = flat_left;
        root.left = null;
     }
}
//Time: O(n); Space: O(n)

