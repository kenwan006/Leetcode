class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for (int[] interval : intervals) {
            if (end < interval[0]) {
                list.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            } else {
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }
        }
        list.add(new int[]{start, end});
        
        //convert list to array
        int[][] res = list.toArray(new int[list.size()][2]);
        return res;
        
    }
}