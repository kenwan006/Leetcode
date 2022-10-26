/** Binary Search
* This m * n 2D array is equivalent to a 1D array since it's ordered
* The num in the 2d at index [i,j] is the same as the num in the 1d at index i* m + j
* Similarly the num in the 1d at index i is the same as the num in the 2d at index [i/n, i % n]
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midVal = matrix[mid / n][mid % n];
            if (midVal == target) return true;
            else if (midVal < target) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }
}
//Time: O(log(m*n)); Space: O(1)