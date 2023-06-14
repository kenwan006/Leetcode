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
    Map<Integer, Integer> valToIndex;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        valToIndex = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) valToIndex.put(inorder[i], i);
        return buildTree(inorder, 0, n - 1, postorder, 0, n - 1);
    }
    
    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) return null;
        int val = postorder[postEnd], index = valToIndex.get(val);
        int lsize = index - inStart;
        TreeNode left = buildTree(inorder, inStart, index - 1, postorder, postStart, postStart + lsize - 1);
        TreeNode right = buildTree(inorder, index + 1, inEnd, postorder, postStart + lsize, postEnd - 1);
        return new TreeNode(val, left, right);
        
    }
}