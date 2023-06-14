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
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                //find the right-most position and connect root.right to here
                TreeNode ptr = curr.left;
                while (ptr.right != null) ptr = ptr.right;
                ptr.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right; //move curr to next node
        }
    }
}
//Time: O(n); Space: O(1)

