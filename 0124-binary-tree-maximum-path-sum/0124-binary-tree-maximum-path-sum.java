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
* Define a global variable maxSum
* For each node we calculate the max path starting from this node, sumPathDown = node.val + max{left, right, 0 } //left and right could be both < 0 !!
* Meanwhile we have to update the maxSum = max(maxSum, node.val + left + right)
*/
class Solution {
    public int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        sumPathDown(root); //no need to return a value
        return maxSum;
    }
    
    //helper function
    public int sumPathDown(TreeNode node) {
        if (node == null) return 0;
        
        int left = Math.max(0, sumPathDown(node.left));
        int right = Math.max(0, sumPathDown(node.right));
        maxSum = Math.max(maxSum, node.val + left + right);
        
        return node.val + Math.max(left, right);
    }
}

//Time: O(n); Space: O(h)