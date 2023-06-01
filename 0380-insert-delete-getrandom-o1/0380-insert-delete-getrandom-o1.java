class RandomizedSet {
    List<Integer> list;
    Random random;
    int size;
    public RandomizedSet() {
        size = 0;
        list = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (list.contains(val)) return false;
        list.add(val);
        size++;
        return true;
    }
    
    public boolean remove(int val) {
        if (!list.contains(val)) return false;
        list.remove(Integer.valueOf(val)); //the object is int type
        size--;
        return true;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(size));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */