class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        //mirror by the diagonal
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                swap(i, j, j, i, matrix);
            }
        }
        
        //mirror by the middle vertical column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(i, j, i, n - 1 - j, matrix);
            }
        }
    }
    
    private void swap(int i, int j, int k, int l, int[][] matrix) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[k][l];
        matrix[k][l] = temp;
    }
}