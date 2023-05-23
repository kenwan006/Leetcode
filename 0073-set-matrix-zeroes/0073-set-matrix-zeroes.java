/** Math
* Use first row and first column as two indicators
**/
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        
        //check if 0 exists in the first row and first column of original array
        boolean first_row = false, first_column = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                first_column = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                first_row = true;
                break;
            }
        }
        
        //update the indicators in first row and first column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) { //set two indicators to 0 if current checked cell is 0
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        //set the cell to 0 if its corresponding indicator is 0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) matrix[i][j] = 0;
            }
        }
        
        //check first row and first column at last
        if (first_column) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
        if (first_row) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }
    }
}
//Time: O(m * n); Space: O(1)

