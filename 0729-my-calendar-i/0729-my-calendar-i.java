class MyCalendar {
    PriorityQueue<int[]> booked;
    public MyCalendar() {
        booked = new PriorityQueue<>((a, b) -> a[0] - b[0]); //sort in the start time
    }
    
    public boolean book(int start, int end) {
        Iterator<int[]> iterator = booked.iterator();
        while (iterator.hasNext()) {
            int[] curr = iterator.next();
            if (start >= curr[1] || end <= curr[0]) continue;
            else return false;
        }
        booked.offer(new int[]{start, end});
        return true;
    }
}
//Time: O(n * log(n)); Space: O(n)
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */