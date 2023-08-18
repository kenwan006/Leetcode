/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

/** DFS **/
class Solution {
    int max = 0;
    public int maxDepth(Node root) {
        if (root == null) return 0;
        traverse(root, 1);
        return max;
    }
    
    private void traverse(Node root, int depth) {
        if (root == null) return;
        max = Math.max(max, depth);
        //check each child
        for (Node child : root.children) {
            traverse(child, depth + 1);
        }
    }
}