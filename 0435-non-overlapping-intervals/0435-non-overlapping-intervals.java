/** Greedy
* Sort by the end in ascending order 
*/
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
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
//Time:  O(n * log(n)); Space: O(log(n))