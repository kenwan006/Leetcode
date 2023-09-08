class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for (int[] interval : intervals) {
            if (end < interval[0]) { //start a new interval
                res.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            } else { //update the overlapped interval
                end = Math.max(end, interval[1]);
            }
        }
        
        //add the last interval
        res.add(new int[]{start, end});
        
        return res.toArray(new int[res.size()][2]);
    } 
}
//Time: O(n * log(n)); Space: O(log(n)) for sorting 
