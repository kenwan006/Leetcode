class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        
        for (int[] interval : intervals) {
            if (interval[0] > end) {
                list.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            } else {
                end = Math.max(end, interval[1]);
            }
        }
        list.add(new int[]{start, end});
        
        //convert list to array
        int[][] res = new int[list.size()][2];
        list.toArray(res);
        return res;
    }
}