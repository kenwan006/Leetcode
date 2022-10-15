/** Double-LinkedList + HashMap
create the node for doubly linkedlist, this node must contain key, val and also prev and next node
create a hashmap - map each key to a node, then we can obtain the corresponding value through the node, so get and put can run O(1) time.
*/

class LRUCache {
    HashMap<Integer, Node> cache = new HashMap<>();
    int capacity;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        // initialize the linkedlist with dummy head and tail
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        int val = node.val;
        remove(node);
        insert(node);
        return val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) remove(cache.get(key));
        if (cache.size() == capacity) remove(tail.prev);
        Node node = new Node(key, value);
        insert(node);
    }
    
    
    // remove any node between head and tail node
    private void remove(Node node) {
        // remove the key - node pair from the cache
        cache.remove(node.key);
        // remove the node from the doubly linkedlist
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    // insert the node to the front of the linkedlist (head - list - tail)
    private void insert(Node node) {
        cache.put(node.key, node);
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    // create the doubly linkedlist node 
    class Node {
        int key, val;
        Node prev, next;
        Node(int _key, int _val) {
            key = _key;
            val = _val;
        }
    }   
}

/**
 * Your LRUCache object will be instantiated and called as such:
 LRUCache obj = new LRUCache(capacity);
 int param_1 = obj.get(key);
 obj.put(key,value);
 */