/** Sorting  + greedy *
* Sort the points according to their Xend in ascending order
* Start from first point, compare its Xend with the Xstart of next point, If there is intersection then they can be burst in one shot;
* Otherwise, we need a new shot, use the Xend of this point as the new end..
*/
class Solution {
    public int findMinArrowShots(int[][] points) {
        //Sort the points by their ends
        //use a custom comparator to avoid int overflow 
        Comparator<int[]> comparator = new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] < b[1]) return -1;
                else if (a[1] > b[1]) return 1;
                else return 0;
            }
        };
        Arrays.sort(points, comparator);
        
        //Iterate over the points, compare current point with next one
        int shot = 1;
        int prevEnd = points[0][1];
        int n = points.length;
        for (int i = 1; i < n; i++) {
            int start = points[i][0];
            if (prevEnd < start) { //need a new shot
                shot++;
                prevEnd = points[i][1];//update the current end as the new preEnd
            }
        }
        return shot;
    }
}
//Time: O(n * log(n)); Space: O(n)