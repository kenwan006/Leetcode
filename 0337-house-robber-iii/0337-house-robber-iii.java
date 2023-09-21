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
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }
    
    //return an array - {notRob, rob}
    //notRob - max amount of money to rob if skip the root; rob - max amount of money to rob if root if robbed
    private int[] helper (TreeNode root) { 
        int[] res = new int[2];
        if (root == null) return res;
        
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        int robRoot = root.val + left[0] + right[0];
        int notRobRoot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return new int[]{notRobRoot, robRoot};
    }
}
