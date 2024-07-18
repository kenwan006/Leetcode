class Solution {
    public void setZeroes(int[][] matrix) {
        boolean top = false, left = false;
        int m = matrix.length, n = matrix[0].length;
        
        //check if top row or left column already has 0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) left = true; 
        }
        
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) top = true;
        }
        
        //use the top row and left column to store the value that if this row or column has 0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        //set the whole row or whole column to 0 as needed
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] != 0) continue;
            for (int j = 1; j < n; j++) matrix[i][j] = 0;
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] != 0) continue;
            for (int i = 1; i < m; i++) matrix[i][j] = 0;
        }
        
        //set the top row and left column to 0 as needed
        if (top) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }
        if (left) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }
}