class MaxStack {
    TreeMap<Integer, LinkedList<Node>> map;
    Node head;
    Node tail;
    
    public MaxStack() {
        map = new TreeMap<>();
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public void push(int x) {
        //add the node to end of the doubly linked list
        Node node = new Node(x);
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        
        //add the node to the map
        map.putIfAbsent(x, new LinkedList<>());
        map.get(x).add(node); //log(n)
    }
    
    public int pop() {
        int x = tail.prev.val;
        
        //remove the node from the end of the doubly linked list
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        
        
        //remove the node from the map
        map.get(x).removeLast(); //log(n)
        if (map.get(x).isEmpty()) map.remove(x); //remove the key if its value is empty
        
        return x;
        
    }
    
    public int top() {
        return tail.prev.val;
    }
    
    public int peekMax() {
        return map.lastKey(); //log(n)
    }
    
    public int popMax() {
        //remove the node from the map
        int x = map.lastKey();
        Node node = map.get(x).removeLast();
        if (map.get(x).isEmpty()) map.remove(x); 
        
        //remove from the doubly linked list
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
        return x;
    }
    
    class Node{
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