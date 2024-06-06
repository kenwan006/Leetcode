class MaxStack {
    TreeMap<Integer, LinkedList<Node>> map; //num -> list of nodes with the same val
    Node head;
    Node tail; //use a doubly linkedlist to store all items like head <=> node1 <=>node2 ...node(n-1) <=> tail
    
    public MaxStack() {
        map = new TreeMap<>();
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public void push(int x) { //O(1)
         Node node = new Node(x);
        
        //add to end of the doubly list
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        
        //add to map
        map.putIfAbsent(x, new LinkedList<>());
        map.get(x).add(node);
    }
    
    public int pop() { //O(logn) as remove x from treemap
        Node node = tail.prev;
        int x = node.val;
        
        //remove from doubly list
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        
        //remove from map
        map.get(x).removeLast(); //x is mapped to multiple nodes, remove the top one
        if (map.get(x).isEmpty()) map.remove(x);
        
        return x;
    }
    
    public int top() { //O(1)
        return tail.prev.val;
    }
    
    public int peekMax() { //O(logn) as get the largest key from the treemap
        return map.lastKey();
    }
    
    public int popMax() { //O(logn)
        int x = map.lastKey();
        Node node = map.get(x).getLast();
        
        //remove from doubly list
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
        //remove from map
        map.get(x).removeLast();
        if (map.get(x).isEmpty()) map.remove(x);
        
        return x;
    }
    
    class Node {
        int val;
        Node prev;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */