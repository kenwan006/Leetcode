/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

/** HashMap 
* Map the orginal node to the coloned node
*
*/
class Solution {
    public Node copyRandomList(Node head) {
        //Map<original node, coloned node>
        Map<Node, Node> map = new HashMap<>();
        
        // copy all nodes
        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }
        
        // copy next and random
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        
        return map.get(head);
    }
}

//Time: O(n); Space: O(n)