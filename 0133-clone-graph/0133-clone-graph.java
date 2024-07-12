/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node adj : curr.neighbors) {
                if (!map.containsKey(adj)) {
                    map.put(adj, new Node(adj.val));
                    queue.offer(adj);
                }
                map.get(curr).neighbors.add(map.get(adj));
            }
        }
        return map.get(node);
    }
}