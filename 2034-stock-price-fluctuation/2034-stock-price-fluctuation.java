class StockPrice { 
    Map<Integer, Integer> map;
    int latestTime;
    PriorityQueue<Node> maxHeap, minHeap;
    
    public StockPrice() {
        latestTime = 0;
        map = new HashMap<>(); //map timestamp -> price
        maxHeap = new PriorityQueue<>((a, b) -> b.price - a.price); // max price on the top
        minHeap = new PriorityQueue<>((a, b) -> a.price - b.price); // min price on the top
    }
    
    public void update(int timestamp, int price) {
        latestTime = Math.max(latestTime, timestamp);
        map.put(timestamp, price);
        Node node = new Node(timestamp, price);
        minHeap.add(node);
        maxHeap.add(node);
        
    }
    
    public int current() {
        return map.get(latestTime); 
    }
    
    public int maximum() {
        Node node = maxHeap.peek();
        while (node.price != map.get(node.timestamp)) {
            maxHeap.poll();
            node = maxHeap.peek();
        }
        return node.price;
    
    }
    
    public int minimum() {
        Node node = minHeap.peek();
        //poll unitl the top node has the correct pair {timestamp : price} as in the map
        while (node.price != map.get(node.timestamp)) {
            minHeap.poll();
            node = minHeap.peek();
        }
        return node.price;
    }
    
    class Node {
        int timestamp;
        int price;
        public Node(int timestamp, int price){
            this.timestamp = timestamp;
            this.price = price;
        }
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */