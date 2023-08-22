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
    Map<Integer, Integer> valToIndex = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd) {
        // base case
        if (inStart > inEnd) return null;
        
        int val = postorder[poEnd];
        int index = valToIndex.get(val); //root index in inorder
        int lsize = index - inStart;
        TreeNode root = new TreeNode(val);
        root.left = buildTree(inorder, inStart, index - 1, postorder, poStart, poStart + lsize - 1);
        root.right = buildTree(inorder, index + 1, inEnd, postorder, poStart + lsize, poEnd - 1);
        return root;
    }
}
//Time: O(n); Space: O(n)
