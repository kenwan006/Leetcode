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
                end = Math.max(end, interval[1]);
            }
        }
        list.add(new int[]{start, end});
        
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) res[i] = list.get(i);
        return res;
    }
}
//Time: O(n); Space: O(1)