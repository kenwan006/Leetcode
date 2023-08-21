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
/** DFS **
* go to the deepest level and see from the leftside view 
*/
class Solution {
    int maxDepth = -1; // just in case root is a leaf
    int res = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    
    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (depth > maxDepth) {
            maxDepth = depth;
            res = root.val;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
//Time: O(n); Space: O(log(n))

