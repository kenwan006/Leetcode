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

/** bfs **/
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        Map<Node, Node> map = new HashMap<>(); //map node -> copy node
        map.put(node, new Node(node.val, new ArrayList<Node>()));
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<Node>()));
                    queue.offer(neighbor);
                }
                map.get(curr).neighbors.add(map.get(neighbor)); //add cloned neighbor to neighbors of cloned root
            }
        }
        return map.get(node);
    }
}

//Time: O(v + e); Space: O(v)