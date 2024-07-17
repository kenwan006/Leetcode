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
    public int amountOfTime(TreeNode root, int start) {
        //build the graph
        Map<Integer, List<Integer>> map = new HashMap<>();
        dfs(root, null, map);
        
        //bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                visited.add(curr);
                for (int adj : map.get(curr)) {
                    if (visited.contains(adj)) continue;
                    queue.offer(adj);
                }
            }
            count++;
        }
        return count - 1;
        
    }
    
    private void dfs(TreeNode root, TreeNode parent, Map<Integer, List<Integer>> map) {
        if (root == null) return;
        
        map.putIfAbsent(root.val, new ArrayList<>());
        if (parent != null) {
            map.get(root.val).add(parent.val);
            map.get(parent.val).add(root.val);
        }
         dfs(root.left, root, map);
         dfs(root.right, root, map);
    }
}