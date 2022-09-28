/** Greedy
* Find all intervals ending before the new interval, add them to the output;
* Find the intervals overlap with the new interval, merge them and add them to the output;
* Find all intervals starting after the end of new interval, add them to the output.
*/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> output = new ArrayList<int[]>();
        int start = newInterval[0], end = newInterval[1], i = 0, n = intervals.length;
        
        while (i < n && intervals[i][1] < start) output.add(intervals[i++]);
        
        while (i < n && intervals[i][0] <= end) {
            start = Math.min(intervals[i][0], start);
            end = Math.max(intervals[i][1], end);
            i++;
        }
        output.add(new int[]{start, end});
        
        while (i < n && intervals[i][0] > end) output.add(intervals[i++]);
        
        return output.toArray(new int[output.size()][2]);
        
    }
}