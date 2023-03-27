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

/** preorder traversal
* For a node, if its left child and right child are unival, then we need to check the subtree values;
* If its subtree is not null, then all the sub nodes need to have the same values as the node.
*/
class Solution {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        isUnival(root);
        return count;
    }
    
    //preorder traversal
    public boolean isUnival(TreeNode root) {
        if (root == null) return true;
        
        boolean l_result = isUnival(root.left);
        boolean r_result = isUnival(root.right);
        if (l_result && r_result) {
            if (root.left != null && root.val != root.left.val) return false;
            if (root.right != null && root.val != root.right.val) return false;
            count++;
            return true;
        }
        
        return false;
    }  
}
//Time: O(n); Space: O(log(n))