/** Approach1: HashMap + TreeMap 
* HashMap<String, TreeMap<Integer, String>>  --> HashMap<key, TreeMap<timestamp, value>>
* TreeMap is a sorted map. It has the method floorKey(key), which returns the greatest key <= the given key, return null if no such key;
*/

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


/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */