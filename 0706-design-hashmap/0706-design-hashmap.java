class MyHashMap {
    List<Node>[] buckets;
    int bucketNum = 2069;
    public MyHashMap() {
        buckets = new List[bucketNum];
    }
    
    public void put(int key, int value) {
        int bucketIdx = key % bucketNum;
        if (buckets[bucketIdx] == null) buckets[bucketIdx] = new ArrayList<>();
        for (Node node : buckets[bucketIdx]) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        buckets[bucketIdx].add(new Node(key, value));
    }
    
    public int get(int key) {
        int bucketIdx = key % bucketNum;
        List<Node> bucket = buckets[bucketIdx];
        if (bucket == null) return -1;
        for (Node node : bucket) {
            if (node.key == key) return node.value;
        }
        return -1;
    }
    
    public void remove(int key) {
        int bucketIdx = key % bucketNum;
        List<Node> bucket = buckets[bucketIdx];
        if (bucket == null) return;
        for (Node node : buckets[bucketIdx]) {
            if (node.key == key) {
                buckets[bucketIdx].remove(node);
                return;
            }
        }
    }
    
    class Node {
        int key;
        int value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */