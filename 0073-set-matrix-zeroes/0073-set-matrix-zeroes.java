class Solution {
    public void setZeroes(int[][] matrix) {
        //use row 0 and column 0 as two indicators
        
        //check if row 0 and column 0 already includes 0
        boolean inRow = false, inCol = false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                inCol = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                inRow = true;
                break;
            }
        }
        
        //update the indicators
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; //column 0 indicator
                    matrix[0][j] = 0; // row 0 indicator
                }
            }
        }
        
        //set zeros based on the indicators
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) matrix[i][j] = 0;
            }
        }
        
        //set row 0 and column 0 
        if (inRow) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0; //set the row 0 to zeros
        }
        if (inCol) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0; //set the column 0 to zeros
        }
        
    }
}