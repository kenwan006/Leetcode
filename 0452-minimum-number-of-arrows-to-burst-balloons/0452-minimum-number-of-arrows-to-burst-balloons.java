class Solution {
    public int findMinArrowShots(int[][] points) {
        Comparator<int[]> comparator = new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] > b[1]) return 1;
                else if (a[1] < b[1]) return -1;
                else return 0;
            }
        };
        Arrays.sort(points, comparator);
        
        //always shoot the end 
        int end = points[0][1], count = 1;
        for (int[] p : points) {
            if (end < p[0]) {
                count++;
                end = p[1]; // start a new burst
            } 
        }
        return count;
    }
}
//Time: O(n * log(n)); Space: O(1)
