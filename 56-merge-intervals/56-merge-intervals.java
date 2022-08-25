class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        
        //sort the array
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        //use two pointers - start and end
        int start = intervals[0][0], end = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] > end) {
                res.add(new int[]{start, end}); // no intersection between current interval and new interval
                start = interval[0];
                end = interval[1]; 
            } else if (interval[1] > end) {
                end = interval[1];
            } else continue;
        }
        
        res.add(new int[]{start, end}); 
        return res.toArray(new int[res.size()][]);
    }
}