/** Search space reduction **/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1; //starting from the upper right corner
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) { //go down for for larger number
                row++;
            } else { //go left for smaller number
                col--;
            }
        }
        return false;
    }
}
//Time: O(m + n); Space: O(1)