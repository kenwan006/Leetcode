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
/** DFS
* Start from root, find all the leaves and then remove all the leaves;
* Repeated the last step
*/
class Solution {
    List<Integer> leaves;
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        while (root != null) {
            leaves = new ArrayList<>();
            if(isLeaf(root)) root = null; //remove the leaf
            res.add(leaves);
        }
        return res;
    }
    
    //dfs - remove all the leaves from current root
    public boolean isLeaf(TreeNode root) {
        if (root.left == null &&  root.right == null) {
            leaves.add(root.val);
            return true;
        }
        if (root.left != null) {
            if (isLeaf(root.left)) root.left = null; //remove the leaf
        }
        if (root.right != null) {
            if (isLeaf(root.right)) root.right = null; //remove the leaf
        }
        return false;
    }
}
//Time: O(n ^ 2); Space: O(n)