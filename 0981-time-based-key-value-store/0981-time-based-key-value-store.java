/** Binary Search **/

class TimeMap {
    Map<String, List<Pair<Integer, String>>> map; // key, (timestamp, value)
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        
        List<Pair<Integer, String>> list = map.get(key);
        if (list.get(0).getKey() > timestamp) return "";
        
        int lo = 0, hi = list.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int time = list.get(mid).getKey();
            if (time == timestamp) return list.get(mid).getValue();
            else if (time > timestamp) hi = mid - 1;
            else lo = mid + 1;
        }
        return list.get(hi).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */