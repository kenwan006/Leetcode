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
* The root always has at least one child as perfect bst(every spot is filled).
* If left child and right child have the same height, then both of them are perfect bst, then count = 2 ^ height - 1;
* If they have different height, then count left child and right child seperately and sum up their counts.
 */
class Solution {
    public int countNodes(TreeNode root) {
        TreeNode curr = root;
        int l_height = 0;
        while (curr != null) { //depth of the leftmost node
            curr = curr.left;
            l_height++;
        }
        curr = root;
        int r_height = 0; //depth of the rightmost node
        while (curr != null) {
            curr = curr.right;
            r_height++;
        }

        if (l_height == r_height) return (int)Math.pow(2, l_height) - 1;
        else return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
//Time: O(log(n) ^ 2); Space: O(1)