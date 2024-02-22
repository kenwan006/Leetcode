class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        //use a min heap to store the ending time of each conference room
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.offer(intervals[0][1]);
        
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            if (start >= heap.peek()) heap.poll();
            heap.offer(end);
        }
        return heap.size();
    }
}