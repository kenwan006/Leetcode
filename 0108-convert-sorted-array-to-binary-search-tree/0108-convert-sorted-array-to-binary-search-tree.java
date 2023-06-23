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
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int lo, int hi) {
        if (hi < lo) return null;
        int mid = lo + (hi - lo) / 2; 
        return new TreeNode(nums[mid], sortedArrayToBST(nums, lo, mid - 1), sortedArrayToBST(nums, mid + 1, hi));
    }
}