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

/** BFS + HashMap
* For each node at column i, push its left child and i -1, and right child and i+1 to the queue
* Use a hashmap to store <column index, list of node vals in this column>
*/
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        
        Map<Integer, List<Integer>> map = new HashMap<>(); //map col -> all nodes(val) in this col
        int minCol = 0, maxCol = 0;
        
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>(); //pair(node, col)
        queue.offer(new Pair(root, 0));
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();//current node
                TreeNode node = pair.getKey();
                int col = pair.getValue();
                
                map.putIfAbsent(col, new ArrayList<>());
                map.get(col).add(node.val);
                
                if (node.left != null) {
                    queue.offer(new Pair(node.left, col - 1));
                    minCol = Math.min(minCol, col - 1);
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, col + 1));
                    maxCol = Math.max(maxCol, col + 1);
                }
            }
        }
        
        for (int i = minCol; i <= maxCol; i++) {//no need to sort the map by key
            res.add(map.get(i));
        }
        return res;
    }
}
//Time: O(n); Space: O(n)