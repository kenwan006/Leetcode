class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0, n = intervals.length, start = newInterval[0], end = newInterval[1];
        List<int[]> list = new ArrayList<>();
        while (i < n && intervals[i][1] < start) list.add(intervals[i++]);
        while (i < n && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        list.add(new int[]{start, end});
        while (i < n && intervals[i][0] > end) list.add(intervals[i++]);
        
        int[][] res = new int[list.size()][2];
        for (i = 0; i < res.length; i++) res[i] = list.get(i);
        return res;
    }
}
//Time: O(n); Space: O(1)
