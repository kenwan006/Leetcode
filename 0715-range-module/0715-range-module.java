class RangeModule {
    TreeMap<Integer, Integer> map; //map start -> end of an range
    
    public RangeModule() {
        map = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        while (true) {
            Integer start = map.floorKey(right);
            if (start == null || map.get(start) < left) break; 
            left = Math.min(left, start);
            right = Math.max(right, map.get(start));
            map.remove(start); //remove the curr range that intersects with [left, right)
        }
        map.put(left, right);
    }
    
    public boolean queryRange(int left, int right) {
        Integer start = map.floorKey(left);
        return start != null && right <= map.get(start);
    }
    
    public void removeRange(int left, int right) {
        addRange(left, right);
        
        Integer start = map.floorKey(left);
        Integer end = map.get(start);
        map.remove(start);
        
        if (start < left) map.put(start, left);
        if (end > right) map.put(right, end);
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */