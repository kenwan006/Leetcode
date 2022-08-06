class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0], end = newInterval[1];
        int i = 0;
        ArrayList<int[]> list = new ArrayList<>();
        
        // add all intervals ending before start of newInterval
        while(i < intervals.length && start > intervals[i][1]) {
            list.add(intervals[i++]);
        }
        
        // merge the newIterval with existing intervals
        while(i < intervals.length && end >= intervals[i][0]) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i++][1]);
        }
        list.add(new int[]{start, end});
        
        // add the rest intervals
        while(i < intervals.length) list.add(intervals[i++]);
        return list.toArray(new int[list.size()][]);
    }
}