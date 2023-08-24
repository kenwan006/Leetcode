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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode insert = new TreeNode(val);
        if (root == null) return insert;
        
        // find the position to insert the new node
        TreeNode parent = null;
        TreeNode curr = root;
        while (curr != null) {
            parent = curr;
            if (curr.val > val) curr = curr.left;
            else curr = curr.right;
        }
        
        // insert
        if (parent.val > val) parent.left = insert;
        else parent.right = insert;
        
        return root;
    }
}
//Time: O(n); Space: O(1)
