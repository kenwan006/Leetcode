class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    Random random;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>(); //val -> index in the list
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int i = map.get(val);
        int lastVal = list.get(list.size() - 1);
        
        //swap the ith item and last item, then remove the last one
        map.put(lastVal, i);
        list.set(i, lastVal);
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    public int getRandom() {
        int i = random.nextInt(list.size());
        return list.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */