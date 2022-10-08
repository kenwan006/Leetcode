/** Two pointers */

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        
        //sort the array by the start
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        
        //merge
        int start = intervals[0][0], end = intervals[0][1];
        for (int[] a : intervals) {
            if (end < a[0] ) {
                res.add(new int[]{start, end});
                start = a[0];
                end = a[1]; //move the pointer
            } else {
                end = Math.max(end, a[1]);
            }
        }
        res.add(new int[]{start, end});
        
        return res.toArray(new int[res.size()][2]);
    }
}