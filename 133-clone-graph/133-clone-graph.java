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
    private HashMap<Integer, Node> visited = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        return cloneNode(node);
    }
    
    // DFS - traverse the unvisited nodes
    public Node cloneNode(Node node) {
        if (node == null) return node;
        if(visited.containsKey(node.val)) return visited.get(node.val);
        
        //if unvisited, create a new node and clone all neighbors
        Node newNode = new Node(node.val, new ArrayList<Node>());
        visited.put(node.val, newNode);
        for(Node neighbor: node.neighbors) {
            newNode.neighbors.add(cloneNode(neighbor));
        }
        return newNode;
    }
}