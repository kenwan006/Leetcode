/** Approach1: HashMap + TreeMap 
* HashMap<String, TreeMap<Integer, String>>  --> HashMap<key, TreeMap<timestamp, value>>
* TreeMap is a sorted map. It has the method floorKey(key), which returns the greatest key <= the given key, return null if no such key;
*/

/*
class TimeMap {
    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<Integer, String>());
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        // if the key does not exist
        if (!map.containsKey(key)) return "";
        
        // get the floor timestamp
        Integer floorKey = map.get(key).floorKey(timestamp);
        if (floorKey == null) return "";
        return map.get(key).get(floorKey);
    }
}
*/

/** Approach2: HsahMap + Binary Search
* HashMap<String, List<Node>>  --> HashMap<key, ArrayList<Node>>
* We have to define a class Node to include the timestamp and the value
* All the timestamps for set function are strictly increasing. Eg, set('foo', 'bar1', 2), set('foo', 'bar2', 4), set('foo', 'bar3', 5).
For the get(), we can do the binary search among the List{Node(2, 'bar1'), Node(4, 'bar2'), Node(5, 'bar3')..}. If timestamp = 3, return 'bar1';If timestamp = 1, return empty string "".
*/

class TimeMap {
    class Node {
        int time;
        String val;
        Node (int time, String val) {
            this.val = val;
            this.time = time;
        }
    }
    
    Map<String, List<Node>> map;
    public TimeMap() {
        map = new HashMap<String, List<Node>>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<Node>());
        map.get(key).add(new Node(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Node> list = map.get(key);
        if (timestamp < list.get(0).time) return ""; // If timestamp is earlier than the earliest time
    
        //Binary search
        int lo = 0, hi = list.size(); // do not use list.size() - 1
        while (lo < hi) { 
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid).time <= timestamp) lo = mid + 1; // use <= not <
            else hi = mid;
        }
        if (hi == 0) return "";
        return list.get(hi - 1).val;
    }    
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */