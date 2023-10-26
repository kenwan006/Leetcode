class TimeMap {
    class Node {
        int time;
        String value;
        public Node(int time, String value) {
            this.time = time;
            this.value = value;
        }
    }
    
    Map<String, List<Node>> map; //key -> list of nodes
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Node(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Node> list = map.get(key);
        if (timestamp < list.get(0).time) return "";
        
        //binary search - find the larget time <= timestamp
        int lo = 0, hi = list.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            Node node = list.get(mid);
            int time = node.time;
            
            if (time == timestamp) {
                return node.value;
            } else if (time > timestamp) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return list.get(hi).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */