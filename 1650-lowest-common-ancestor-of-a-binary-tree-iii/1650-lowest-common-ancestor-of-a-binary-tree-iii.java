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
        //find all ancestors of p, including p
        Set<Node> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = p.parent;
        }
        
        //check the lowest ancestor of q that exist in p's ancestors
        while (q != null) {
            if (ancestors.contains(q)) return q;
            q = q.parent;
        }
        
        return null;
    }
}