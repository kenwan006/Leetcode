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
    private Map<Node, Node> map = new HashMap<>();// node -> copy node
    
    public Node cloneGraph(Node node) {
        return clone(node);
    }
    
    //dfs
    public Node clone(Node node) {
        if (node == null) return null;
        
        if (map.containsKey(node)) return map.get(node);
        
        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(node, newNode);
        
        //copy the neighbors
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(clone(neighbor));
        }
        return newNode;
    }
}
//Time: O(v + e); Space: O(v)