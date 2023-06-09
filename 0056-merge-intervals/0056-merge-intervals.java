class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); //sort by start of interval
        List<int[]> list = new ArrayList<>();
        int prevStart = intervals[0][0], prevEnd = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            if (start > prevEnd) {
                list.add(new int[]{prevStart, prevEnd});
                prevStart = start;
                prevEnd = end;
            } else {
                prevStart = Math.min(prevStart, start);
                prevEnd = Math.max(prevEnd, end);
            }
        }
        
        //add the last interval
        list.add(new int[]{prevStart, prevEnd});
        
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) res[i] = list.get(i);
        return res;
                              
    } 
}
//Time: O(n * log(n)); Space: O(1)

