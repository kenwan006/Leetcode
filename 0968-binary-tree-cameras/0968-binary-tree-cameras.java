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
    int notCovered = 0, hasCamera = 1, covered = 2;
    int count = 0;
    public int minCameraCover(TreeNode root) {
        int top = dfs(root);
        if (top == notCovered) count++; //if root not covered, then put a camera there
        return count;
    }
    
    /** post order traversal **/
    private int dfs(TreeNode root) {
        if (root == null) return covered;
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        if (left == covered && right == covered) { //both childs are covered but w/o camera
            return notCovered;
        } else if (left == notCovered || right == notCovered) {//If one child is not covered, then put camera at the parent node
            count++;
            return hasCamera;
        } else {// if one child has camera, then the parent node will be covered
            return covered;
        }
    }
}
//Time: O(n); Space: O(n)
