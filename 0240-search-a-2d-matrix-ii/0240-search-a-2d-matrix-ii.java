/** Divide & Conquer **/
class Solution {
    private int m, n;
    public boolean searchMatrix(int[][] matrix, int target) {
        m = matrix.length;
        n = matrix[0].length;
        return search(matrix, target, 0, m -1, 0, n - 1); 
    }
    
    public boolean search(int[][] matrix, int target, int top, int down, int left, int right) {
        if (top > down || left > right) return false;
        
        int row = (top + down) /2, col = (left + right) / 2;
        
        if (matrix[row][col] == target) return true;
        else if (matrix[row][col] > target) {
            return search(matrix, target, row, down, left, col - 1) || 
                   search(matrix, target, top, row - 1, col, right) ||
                   search(matrix, target, top, row - 1, left, col - 1);
        } else {
            return search(matrix, target, row + 1, down, left, col) || 
                   search(matrix, target, top, row, col + 1, right) ||
                   search(matrix, target, row + 1, down, col + 1, right);
        }
    }
}
//Time: O(log(m * n)); Space: O(log(m * n))