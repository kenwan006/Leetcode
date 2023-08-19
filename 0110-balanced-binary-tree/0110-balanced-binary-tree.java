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
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        getDepth(root);
        return res;
    }
    
    /** post order traversal **/
    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        if (Math.abs(l -r) > 1) res = false;
        return Math.max(l, r) + 1;
    }
}
//Time: O(n); Space: O(log(n))
