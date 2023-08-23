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
    int maxCount = 0;
    int count = 0;
    TreeNode prev = null;
    List<Integer> res = new ArrayList<>();
    
    public int[] findMode(TreeNode root) {
        traverse(root);
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) ans[i] = res.get(i);
        return ans;
    }
    
    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        
        if (prev != null && prev.val == root.val) count++;
        else count = 1;
        
        if (count > maxCount) {
            res.clear();
            maxCount = count;
        } 
        if (count == maxCount) {
            res.add(root.val);
        }
        prev = root; //move to next node
        
        traverse(root.right);
    }
}