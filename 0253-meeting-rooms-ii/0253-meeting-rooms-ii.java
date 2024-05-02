class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //sort the intervals by the start time in ascending order
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        //add the end time of each room to a min heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.offer(intervals[0][1]);
        
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int start = curr[0], end = curr[1];
            
            if (start >= heap.peek()) heap.poll(); //update end time for a room
            
            heap.offer(curr[1]);
        }
        
        return heap.size();
        
    }
}