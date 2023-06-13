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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        valToIndex = new HashMap<>(); //map val -> index in inorder
        for (int i = 0; i < n; i++) valToIndex.put(inorder[i], i);
        return buildTree(preorder, 0, n - 1, inorder, 0, n - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart,int inEnd) {
        if (preEnd < preStart) return null;
        int val = preorder[preStart], index = valToIndex.get(val);// index of root in the inorder
        int lsize = index - inStart;
        TreeNode left = buildTree(preorder, preStart + 1, preStart + lsize, inorder, inStart, index - 1);
        TreeNode right = buildTree(preorder, preStart + lsize + 1, preEnd, inorder, index + 1, inEnd);
        return new TreeNode(val, left, right);
    }
}