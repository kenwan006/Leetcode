class Solution {
    public int findMinArrowShots(int[][] points) {
        // sort the points by their end position
        // do not use the comparator (a, b) -> a[1] - b[1] to avoid int overflow
        Arrays.sort(points, new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        
        int burst = 1;
        int end = points[0][1];
        for (int[] point : points) {
            // let the burst position overlap with other points as many as possible
            // if no overlap, then start a new burst - at end of the point
            if (end < point[0]) {
                end = point[1];
                burst++;
            }
        }
        return burst;
    }
}
//Time: O(n * log(n)); Space: O(1)

