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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }
    
    private TreeNode construct(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        int i = findMax(nums, lo, hi);
        TreeNode root = new TreeNode(nums[i]);
        root.left = construct(nums, lo, i - 1);
        root.right = construct(nums, i + 1, hi);
        return root;
    }
    
    private int findMax(int[] nums, int lo, int hi) {
        int index = lo;
        for (int i = lo; i <= hi; i++) {
            if (nums[index] < nums[i]) index = i;
        }
        return index;
    }
}
//Time: O(n * log(n)); Space: O(n)
