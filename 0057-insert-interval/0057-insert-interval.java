class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int start = newInterval[0], end = newInterval[1];
        
        for (int[] t : intervals) {
            if (end < t[0]) {
                list.add(new int[]{start, end});
                start = t[0];
                end = t[1];
            } else if (start > t[1]) {
                list.add(t);
            } else {
                start = Math.min(start, t[0]);
                end = Math.max(end, t[1]);
            }
        }
        list.add(new int[]{start, end}); //need to add the last interval
        
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) res[i] = list.get(i);
        return res;
    }
}
//Time: O(n); Space: O(1)