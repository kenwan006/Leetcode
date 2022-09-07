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

/** Recursion
preorder: [root val, left branch, right branch]
inorder:  [left branch, root val at i, right branch]
- The first element in the preorder array is the root val of the tree. Find the position i where
this root val is in the inorder array.
- At the left side of i, there are (i - inStart) elements, and (inEnd - i) elements at the right side
- So in the preorder array, the left branch starts at preStart + 1 and ends at preStarat + (i - inStart),
  the right branch starts at preStart + (i-instart) + 1 and ends at preEnd
- Build the left tree and right tree using the boundary indices - preStart, preEnd, inStart, inEnd
*/

class Solution {
    
    HashMap<Integer, Integer> valToIndex = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // map the root val to its index in the inorder array
        for (int i = 0; i < inorder.length; i++) valToIndex.put(inorder[i], i);
        
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length -1);
    }
    
    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        //base case
        if(preStart > preEnd || inStart > inEnd) return null;
        
        int rootVal = preorder[preStart];
        int index = valToIndex.get(rootVal);
        int leftSize = index - inStart; // size of left branch
        
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }
}