/** TreeMap **/
class MyCalendar {
    TreeMap<Integer, Integer> booked;
    
    public MyCalendar() {
        booked = new TreeMap<>(); // map start -> end of a booked interval
    }
    
    public boolean book(int start, int end) {
        // the closest interval before this new start
        Integer s = booked.floorKey(start);
        if (s != null && booked.get(s) > start) return false;
        
        // the closest interval behind this new start
        Integer ss = booked.ceilingKey(start);
        if (ss != null && ss < end) return false;
        
        booked.put(start, end);
        return true;
    }
}
//Time: O(log(n)); Space: O(n)

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */