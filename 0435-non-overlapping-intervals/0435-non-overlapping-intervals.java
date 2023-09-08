class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
                else return Integer.compare(a[1], b[1]);
            }
        });
        int count = 1; //count of overlapped groups
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            if (end <= interval[0]) {
                count++;
                end = interval[1];
            }
        }
        return intervals.length - count;
    }
}