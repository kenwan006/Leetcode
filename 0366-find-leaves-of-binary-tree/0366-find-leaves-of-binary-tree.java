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
/** post order traversal 
* Check the heights for each node in the tree, for those with the same height, add them to one list.
* - all the leaves have the height 0, include them into one list, and put this list to the 0th position of the result list
* - for all the nodes 1 layer higher than the leaves, include them into one list and put the list to 1st postion of the res list
* We can easily come up with a bottom-up recusive way to check each node
*/
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> findLeaves(TreeNode root) {
        res = new ArrayList<>();
        getHeight(root);
        return res;
    }
    
    //
    public int getHeight(TreeNode root) {
        if (root == null) return -1; //if we want the leaf be in 0 height, then it's -1 for null
        int lHeight = getHeight(root.left);
        int rHeight = getHeight(root.right);
        int height = Math.max(lHeight, rHeight) + 1;
        
        //start a new level
        if (height == res.size()) res.add(new ArrayList());
        res.get(height).add(root.val); //add the nodes in the same height
        
        return height;
    }
}
//Time: O(n); Space: O(n)