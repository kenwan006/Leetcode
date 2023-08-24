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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            //insert the left child to the leftmost of right child
            if (root.right == null) return root.left;
            if (root.left == null) return root.right;
            
            TreeNode curr = root.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            curr.left = root.left;
            root = root.right;
            return root;
        }
        
        if (root.val < key) root.right = deleteNode(root.right, key);
        if (root.val > key) root.left = deleteNode(root.left, key);
        
        return root;
    }
}
//Time: O(log(n)); Space: O(1)
