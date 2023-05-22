class Solution {
    public void rotate(int[][] matrix) {
        //reverse each column
        int m = matrix.length, n = matrix[0].length;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m / 2; i++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m - 1 - i][j];
                matrix[m - 1 - i][j] = temp;
            }
        }
        
        //mirror by the diagonal
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
//Time: O(n * n); Space: O(1)
