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
    Map<Integer, Integer> map = new HashMap<>();// val -> index 
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) map.put(inorder[i], i);
        return buildTree(preorder, 0, n- 1, inorder, 0, n-1);
    }
    
    public TreeNode buildTree(int[] preorder, int  preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preEnd < preStart) return null;
        int val = preorder[preStart];
        int index = map.get(val);
        int left_size = index - inStart; //size of left child
        TreeNode root = new TreeNode(val);
        root.left = buildTree(preorder, preStart + 1, preStart + left_size, inorder, inStart, index - 1);
        root.right = buildTree(preorder, preStart + left_size + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }
}
//Time: O(n); Space: O(n)