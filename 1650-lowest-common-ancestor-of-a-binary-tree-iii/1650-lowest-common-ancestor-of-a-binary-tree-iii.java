/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        //store all ancestors of node p including itself
        Set<Node> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = p.parent;
        }
        
        //find the lowest ancestor of p that is also q's ancestor
        while (q != null) {
            if (ancestors.contains(q)) return q;
            q = q.parent;
        }
        
        return null;
    }
}