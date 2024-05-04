/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //build graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        build(root, null, graph);
        
        //bfs - find the node with distance k from the target node
        LinkedList<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(target.val);
        visited.add(target.val);
        
        while (!queue.isEmpty() && k > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int next : graph.get(curr)) {
                    if (visited.contains(next)) continue;
                    visited.add(next);
                    queue.offer(next);
                }
            }
            k--;
        }
        return queue;
    }
    
    //build a undirected graph
    private void build(TreeNode root, TreeNode parent, Map<Integer, List<Integer>> graph) {
        if (root == null) return;
        graph.put(root.val, new ArrayList<>());
        
        if (parent != null) {
            graph.get(root.val).add(parent.val);
            graph.get(parent.val).add(root.val);
        }

        build(root.left, root, graph);
        build(root.right, root, graph);
    }
}

//Time: O(v); Space: O(v + e)