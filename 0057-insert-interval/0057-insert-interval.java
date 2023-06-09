class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int start = newInterval[0], end = newInterval[1];
        for (int[] a : intervals) {
            if (end < a[0]) {
                list.add(new int[]{start, end});
                start = a[0];
                end = a[1];
            } else if(start > a[1]) {
                list.add(a);
            } else {
                start = Math.min(start, a[0]);
                end = Math.max(end, a[1]);
            }
        }
        list.add(new int[]{start, end});
        
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) res[i] = list.get(i);
        return res;
    }
}
//Time: O(n * log(n)); Space: O(n)

