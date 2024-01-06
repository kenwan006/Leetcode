class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if (m == 1 || n == 1) return true;
        
        for (int i = 1; i < m; i++) {
            //compare each item in ith row with (i-1)th row
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) return false;
            }
        }
        return true;
    }
}