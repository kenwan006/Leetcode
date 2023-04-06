class HitCounter {
    
    List<Integer> list;
    public HitCounter() {
        list = new ArrayList<>();
    }
    
    public void hit(int timestamp) {
        list.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        int n = list.size();
        int start = n - 1; //find the start index for the past 300s timestamp
        if (timestamp <= 300) return n;
        
        while (start >= 0 && list.get(start) > timestamp - 300) start--;
        return n - 1 - start;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */