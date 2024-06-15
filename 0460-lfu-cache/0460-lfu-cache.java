class LFUCache {
    Map<Integer, Integer> cache;
    Map<Integer, Integer> keyToFreq;
    Map<Integer, LinkedHashSet<Integer>> freqToKeys;
    int capacity;
    int min_freq;
    
    public LFUCache(int capacity) {
        min_freq = 1;
        cache = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        
        int val = cache.get(key);
        int freq = keyToFreq.get(key);
        
        //remove the key from current freq
        freqToKeys.get(freq).remove(key);
        if (freqToKeys.get(freq).isEmpty()) {
            if (min_freq == freq) min_freq++;
            freqToKeys.remove(freq); //check if this freq has none keys left after the removal of the given key
        }
        
        freq++;
        
        //update the freq for this key
        keyToFreq.put(key, freq);
        
        //add to freqToKeys
        freqToKeys.putIfAbsent(freq, new LinkedHashSet<>());
        freqToKeys.get(freq).add(key);
        
        return val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            get(key);
            return;
        }
        
        //if full, then remove the least frequently used item
        if (cache.size() == capacity) {
            Set<Integer> keys = freqToKeys.get(min_freq);
            int evict = keys.iterator().next();
            
            keys.remove(evict);
            if (keys.isEmpty()) freqToKeys.remove(min_freq);
            
            cache.remove(evict);
            keyToFreq.remove(evict);
        }
        
        cache.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        
        min_freq = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */