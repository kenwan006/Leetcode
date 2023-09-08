/** Greedy
** Sort the points by the start in ascending order 
**/
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int end = points[0][1];
        int burst = 1;
        for (int[] point : points) {
            if (end < point[0]) { //if no intersection, start a new burst
                end = point[1];
                burst++;
            } else {
                //if intersection, update the end to be the min end among the intersected points
                end = Math.min(end, point[1]);
            }
        }
        return burst;
    }
}
//Time: O(n * log(n)); Space: O(log(n))
