class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        
        //check if 0 exists in the first row and first col of original matrix
        boolean first_row = false, first_col = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) first_col = true;
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) first_row = true;
        }
        
        //set the indicator in the first row and first col
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        //check each cell and set it to 0 if needed
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //set first row and first col
        if (first_row) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }
        if (first_col) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }
}
//Time: O(m * n); Space: O(1)