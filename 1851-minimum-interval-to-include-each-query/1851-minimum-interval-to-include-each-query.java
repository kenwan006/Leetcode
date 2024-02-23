class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        //add index of each query into a heap
        int m = intervals.length, n = queries.length;
        PriorityQueue<Integer> heap1 = new PriorityQueue((o1, o2) -> queries[(int)o1] - queries[(int)o2]);
        for (int i = 0; i < n; i++) heap1.offer(i);
        
        //sort the intervals by their start
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        
        //for each query, find all valid intervals and add them to a heap
        PriorityQueue<int[]> heap2 = new PriorityQueue<>((x, y) -> x[1] - x[0] - y[1] + y[0]);
        
        int[] res = new int[n];
        int i = 0;
        
        while (!heap1.isEmpty()) {
            int idx = heap1.poll(), query = queries[idx];
            
            //add all interval which start before the query
            while (i < m && intervals[i][0] <= query) heap2.offer(intervals[i++]);
            
            //Remove if the smallest sized interval on heap2 ends before the query
            while (!heap2.isEmpty() && query > heap2.peek()[1]) heap2.poll();
            
            //don't poll this smallest valid interval because it may be used by the later query
            res[idx] = heap2.isEmpty()? -1 : heap2.peek()[1] - heap2.peek()[0] + 1; 
        }
        
        return res;
    }
}